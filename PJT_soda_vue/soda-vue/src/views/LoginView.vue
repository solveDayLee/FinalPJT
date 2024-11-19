<template>
    <div>
        <p>아이디</p>
        <input type="text" placeholder="아이디를 입력하세요" v-model="userId">
    </div>
    <div>
        <p>비밀번호</p>
        <input type="password" placeholder="비밀번호를 입력하세요" v-model="password">
    </div>
    <div>
        <button type="submit" @click="handleLogin">로그인</button>
    </div>
    <div>
        <div>
            <a href="/find-id">아이디 찾기</a> 
            <a href="/find-pw">비밀번호 찾기</a>
        </div>
        <button @click="goToSignup">회원가입</button>
    </div>


</template>

<script setup>
import { ref } from 'vue'
import {useRouter} from 'vue-router'

const router = useRouter()
const userId = ref('')
const password = ref('')

const handleLogin = async() => {
    try {
        //입력값 검증
        if(!userId.value || !password.value) {
            alert('아이디와 비밀번호 모두 입력해주세요.')
            return
        }
        //로그인 성공 시 메인 페이지 이동
        router.push('/')

    } catch(error) {

        alert('로그인에 실패했습니다.')
    }

}

const goToSignup = () => {
    router.push('/join')
}


</script>



<style scoped>
</style>