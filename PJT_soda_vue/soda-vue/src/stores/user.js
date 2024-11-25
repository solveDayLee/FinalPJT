import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_API_URL = `http://localhost:8080/etco`
// axios 인터셉터 설정
axios.interceptors.request.use(
    config => {
        const token = localStorage.getItem('access-token');
        if (token) {
            config.headers.Authorization = token.startsWith('Bearer') ? token : `Bearer ${token}`;
        }
        return config;
    },
    error => {
        return Promise.reject(error);
    }
);

// 응답 인터셉터 추가 - 토큰 만료 등의 인증 에러 처리
axios.interceptors.response.use(
    response => response,
    error => {
        if (error.response?.status === 401 || error.response?.status === 403) {
            // 토큰 관련 에러시 로그아웃 처리
            localStorage.removeItem('access-token');
            localStorage.removeItem('role');
            localStorage.removeItem('userId');
            router.push({ name: 'Login' });
            alert('로그인이 필요한 서비스입니다.');
        }
        return Promise.reject(error);
    }
);

export const useUserStore = defineStore('user', () => {
    const loginUser = ref(null)

    const initializeUser = () => {
        const token = localStorage.getItem('access-token')
        const role = localStorage.getItem('role')
        const storedUserId = localStorage.getItem('userId')

        if (token && role && storedUserId) {
            loginUser.value = {
                userId: storedUserId,
                role: role
            }
        }
    }
    const userLogin = function (userId, password) {
        console.log('로그인 시도:', {userId, password}); // 요청 데이터 확인
    
        axios.post(`${REST_API_URL}/login`, {
            userId,
            password,
        })
        .then((res) => { 
            console.log('로그인 응답:', res.data);
                
            const token = res.data['access-token'];
            if(!token) {
                throw new Error('토큰이 없습니다.');
            }
    
            // 토큰 정보 디코딩 전에 상태 확인
            console.log('디코딩 전 토큰:', token);
    
            try {
                // 토큰 디코드 과정을 단계별로 나누어 확인
                const base64Url = token.split('.')[1];
                const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
                const jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
                    return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
                }).join(''));
    
                const tokenPayload = JSON.parse(jsonPayload);
                console.log('디코드된 토큰 정보:', tokenPayload);
    
                // 사용자 정보 저장 전 데이터 확인
                console.log('저장할 사용자 정보:', {
                    userId,
                    role: res.data.role,
                    userNo: tokenPayload.userNo
                });
    
                // 로그인 유저 정보 저장
                loginUser.value = {
                    userId: userId,
                    role: res.data.role,
                    userNo: tokenPayload.userNo
                };
    
                // localStorage에 저장
                localStorage.setItem('access-token', `Bearer ${token}`);
                localStorage.setItem('role', res.data.role);
                localStorage.setItem('userId', userId);
                localStorage.setItem('userNo', tokenPayload.userNo);
    
                // 저장 후 확인
                console.log('저장된 정보:', {
                    token: localStorage.getItem('access-token'),
                    role: localStorage.getItem('role'),
                    userId: localStorage.getItem('userId'),
                    userNo: localStorage.getItem('userNo')
                });
    
                if (res.data.role === 'ADMIN') {
                    location.href = 'http://localhost:8080/admin/main';
                    return;
                }
                router.push({ name: 'Home' });
            } catch (error) {
                console.error('토큰 처리 중 에러:', error);
                throw error;
            }
        })
        .catch((err) => {
            console.error('로그인 실패:', err);
            if (err.response) {
                console.error('에러 응답:', err.response.data);
            }
            alert('로그인에 실패했습니다.');
            router.push({ name: 'Login' });
        });
    }
    //로그아웃
    const userLogout = function () {
        localStorage.removeItem('access-token')
        localStorage.removeItem('role')
        localStorage.removeItem('userId')
        localStorage.removeItem('userNo')
        loginUser.value = null

        alert("로그아웃 되었습니다.")
        router.push({ name: 'Home' })
    }

    //회원가입
    const join = async function (user) {
        console.log('전송할 회원가입 데이터:', user)
        await axios.post(`${REST_API_URL}/signup`, user)
            .then(() => {
                alert('회원가입 성공')
                router.push({ name: 'Login' })
            })
            .catch((err) => {
                console.log(err)
                alert('회원가입 실패')
            })
    }

    return { loginUser, userLogin, userLogout, join, initializeUser }
})