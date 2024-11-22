import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_API_URL = `http://localhost:8080/etco`


export const useUserStore = defineStore('user', () => {
    const loginUser = ref(null)

    //로그인
    const userLogin = function(userId, password) {
        axios.post(`${REST_API_URL}/login`, {
            userId, 
            password,
        })
        .then((res) => { //로그인 성공하면
            console.log(res)
            //토큰 저장
            localStorage.setItem('access-token', res.data['access-token'])
            localStorage.setItem('role', res.data.role)

            if(res.data.role === 'ADMIN' && res.data.adminUrl) {
                location.href = res.data.adminUrl
                return
            }
            router.push({name: 'Home'})
        })

        .catch((err) => { //로그인 실패시
            console.log(err)
            alert('로그인 실패')
            router.push({name: 'Login'})
        })
    }

    //로그아웃
    const userLogout = function() {
        localStorage.removeItem('access-token')
        localStorage.removeItem('role')
        loginUser.value=null

        router.push({name:'Home'})
    }

    //회원가입
    const join = function(user) {
        axios.post(`${REST_API_URL}/signup`,user)
        .then(()=> {
            alert('회원가입 성공')
            router.push({name:Login})
        })
        .then((err)=> {
            console.log(err)
            alert('회원가입 실패')
        })
    }




  return { loginUser,userLogin,userLogout, join}
})