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
            config.headers.Authorization = `Bearer ${token}`;
            console.log('토큰 전송:', token); // 디버깅용
        }
        return config;
    },
    error => {
        return Promise.reject(error);
    }
);

export const useUserStore = defineStore('user', () => {
    const loginUser = ref(null)

        //새로고침해도 로그인 상태 유지 함수. app.vue에서 이 함수 호출해줌
        // 여기에 initializeUser 함수 추가
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


    //로그인
    const userLogin = function(userId, password) {
        axios.post(`${REST_API_URL}/login`, {
            userId,
            password,
        })
        .then((res) => { //로그인 성공하면
            console.log('로그인 응답:', res.data) // 디버깅용

            //로그인 유저 정보 저장
            loginUser.value = {
                userId: userId,
                // userNickname: res.data.userNickname,
                role: res.data.role,
            }



            //토큰 저장
            localStorage.setItem('access-token', res.data['access-token'])
            localStorage.setItem('role', res.data.role)
            localStorage.setItem('userId',userId)

            if(res.data.role && res.data.role.includes('ADMIN')) {
                console.log('관리자 로그인 감지'); // 디버깅용

                // 서버에 직접 관리자 페이지 접근 요청 (JWT 토큰 포함)
                // axios.get('http://localhost:8080/admin/main')
                //     .then(response => {
                //         // 서버에서의 응답이 성공적이라면 페이지 이동
                //         console.log('관리자 페이지 접근 성공:', response.data);
                //         // Vue Router를 사용하여 페이지 이동
                //         router.push({ path: '/admin/main' });
                //     })
                //     .catch(error => {
                //         console.log('관리자 페이지 접근 실패:', error);
                //         alert('관리자 권한이 없습니다.');
                //     });
                // return;
                console.log('관리자 로그인 감지') // 디버깅용
                console.log('Redirect URL:', res.data.redirectUrl); // 디버깅용
                // router.push({ path: '/admin/main' });
                location.href = "http://localhost:8080/admin/main";
                return;
            }
            console.log('일반사용자 로그인 감지') // 디버깅용
            console.log('관리자였다면 Redirect URL:', res.data.redirectUrl);
            router.push({name: 'Home'})
        })

        .catch((err) => { //로그인 실패시
            console.log('로그인 에러:', err)
            alert('로그인 실패')
            router.push({name: 'Login'})
        })
    }

    //로그아웃
    const userLogout = function() {
        localStorage.removeItem('access-token')
        localStorage.removeItem('role')
        localStorage.removeItem('userId')
        loginUser.value=null

        alert("로그아웃 되었습니다.")
        router.push({name:'Home'})
    }

    //회원가입
    const join = function(user) {
        console.log('전송할 회원가입 데이터:', user)
        axios.post(`${REST_API_URL}/signup`,user)
        .then(()=> {
            alert('회원가입 성공')
            router.push({name:'Login'})
        })
        .catch((err)=> {
            console.log(err)
            alert('회원가입 실패')
        })
    }




  return { loginUser,userLogin,userLogout, join, initializeUser  }
})