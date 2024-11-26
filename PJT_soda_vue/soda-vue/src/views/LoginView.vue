<template>
    <div class="login-container">
      <div class="input-group">
        <p>아이디</p>
        <input type="text" placeholder="아이디를 입력하세요" v-model="userId">
      </div>
      <div class="input-group">
        <p>비밀번호</p>
        <input type="password" placeholder="비밀번호를 입력하세요" v-model="password">
      </div>
      <div class="input-group">
        <button type="submit" @click="handleLogin">로그인</button>
      </div>
      <div class="links-section">
        <div class="find-links">
          <a href="/find-id">아이디 찾기</a>
          <a href="/find-pw">비밀번호 찾기</a>
        </div>
      </div>
      <button class="signup-button" @click="goToSignup">회원가입</button>
    </div>
  </template>

<script setup>
import { ref } from 'vue'
import {useRouter} from 'vue-router'
import { useUserStore } from '@/stores/user'

const router = useRouter()
const userId = ref('')
const password = ref('')
const userStore = useUserStore()


const handleLogin = async() => {
    try {
        //입력값 검증
        if(!userId.value || !password.value) {
            alert('아이디와 비밀번호 모두 입력해주세요.')
            return
        }
        // store의 userLogin 함수 호출 추가
        await userStore.userLogin(userId.value, password.value)
        
        //store에서 처리
        // //로그인 성공 시 메인 페이지 이동
        // router.push('/')

    } catch(error) {

        alert('로그인에 실패했습니다.')
    }

}

const goToSignup = () => {
  const user = {
    userId: userId.value,
    password: password.value
  }
  userStore.userLogin(user) 
  router.push('/join')
}


</script>
<style scoped>
  .login-container {
    max-width: 480px;
    margin: 3rem auto;
    padding: 2.5rem;
    background-color: white;
    border-radius: 16px;
    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.06);
  }

  .input-group {
    margin-bottom: 1.5rem;
  }

  .input-group p {
    font-size: 0.95rem;
    font-weight: 600;
    color: #2d3748;
    margin-bottom: 0.5rem;
  }

  input {
    width: 100%;
    padding: 0.8rem 1rem;
    border: 2px solid #F3F0E6;
    border-radius: 12px;
    font-size: 0.95rem;
    transition: all 0.3s ease;
    background-color: #FDFBF7;
  }

  input:focus {
    outline: none;
    border-color: #9EC5FE;
    box-shadow: 0 0 0 3px rgba(158, 197, 254, 0.2);
  }

  input::placeholder {
    color: #a0aec0;
  }

  button[type="submit"] {
    width: 100%;
    background-color: #9EC5FE;
    color: white;
    padding: 0.8rem;
    border: none;
    border-radius: 12px;
    font-size: 1rem;
    font-weight: 600;
    cursor: pointer;
    transition: all 0.3s ease;
    margin-bottom: 1.5rem;
    box-shadow: 0 2px 8px rgba(158, 197, 254, 0.3);
  }

  button[type="submit"]:hover {
    background-color: #7DB0FE;
    transform: translateY(-2px);
  }

  .links-section {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 1.5rem;
    padding: 1rem 0;
    border-bottom: 2px solid #F3F0E6;
  }

  .find-links {
    display: flex;
    gap: 1rem;
  }

  .find-links a {
    color: #4a5568;
    text-decoration: none;
    font-size: 0.9rem;
    transition: color 0.3s ease;
  }

  .find-links a:hover {
    color: #2d3748;
  }

  button.signup-button {
    background-color: white;
    color: #2d3748;
    padding: 0.7rem 1.5rem;
    border: 2px solid #F3F0E6;
    border-radius: 12px;
    font-size: 0.95rem;
    font-weight: 500;
    cursor: pointer;
    transition: all 0.3s ease;
    width: 100%;
  }

  button.signup-button:hover {
    background-color: #FDFBF7;
    transform: translateY(-2px);
  }
</style>