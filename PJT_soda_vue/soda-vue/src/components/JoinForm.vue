<template>
    <div class="block">
        <h2>회원가입</h2>
        <hr>
        <h3>회원 정보를 입력해주세요</h3>
        <div class="form">
            <div class="input-group">
                <p>이름<span class="required">*</span></p>
                <input v-model="name" placeholder="이름을 입력해주세요" @blur="checkName">
                <p v-if="errors.name" class="error-message">이름을 입력해주세요.</p>
            </div>
            <div class="input-group">
                <p>이메일<span class="required">*</span></p>
                <input v-model="email" placeholder="이메일을 입력해주세요" @blur="checkEmail">
                <p v-if="errors.email" class="error-message">이메일을 올바르게 입력해주세요.</p>
            </div>

            <div class="input-group">
                <p>휴대폰번호<span class="required">*</span></p>
                <input v-model="phone" placeholder="'-'제외하고 입력" @blur="checkPhone">
                <p v-if="errors.phone" class="error-message">휴대폰번호를 '-'를 제외하고 올바르게 입력해주세요.</p>
            </div>
            <div class="input-group">
                <p>생년월일</p>
                <input v-model="birthDate" placeholder="YYYYMMDD">
            </div>
            <div class="input-group">


                <p>성별</p>
                <select v-model="gender" name="gender">
                    <option value="F">여</option>
                    <option value="M">남</option>
                    <option value="N">비공개</option>
                </select>

            </div>

            <div class="input-group">
                <p>주소<span class="required">*</span></p>
                <input v-model="address" placeholder="api 를 이용해서 수정할 예정" @blur="checkAddress">
                <p v-if="errors.address" class="error-message">주소를 입력해주세요.</p>
            </div>
            <hr>
            <div class="input-group">
                <p>닉네임<span class="required">*</span></p>
                <input v-model="nickname" placeholder="닉네임을 입력해주세요" @blur="checkNickname">
                <p v-if="errors.nickname" class="error-message">닉네임을 입력해주세요.</p>
            </div>

            <div class="input-group">
                <p>아이디<span class="required">*</span></p>
                <input v-model="userId" placeholder="아이디를 입력해주세요" @blur="checkUserId">
                <p v-if="errors.userId" class="error-message">아이디를 입력해주세요.</p>
            </div>

            <div class="input-group">
                <p>비밀번호<span class="required">*</span></p>
                <input type="password" v-model="password" placeholder="비밀번호를 입력해주세요" id="password"
                    @blur="checkPassword">
                <p v-if="errors.password" class="error-message">비밀번호를 입력해주세요.</p>
            </div>

            <div class="input-group">
                <p>비밀번호 확인<span class="required">*</span></p>
                <input type="password" v-model="passwordCheck" placeholder="비밀번호를 다시 입력해주세요" id="password-check"
                    @blur="checkPasswordCheck">
                <p v-if="errors.passwordCheck" class="error-message">비밀번호 확인을 입력해주세요.</p>
                <p v-if="!isPasswordMatch && password && passwordCheck" class="error-message">
                    비밀번호가 일치하지 않습니다.
                </p>
            </div>



            <button @click="handleSubmit" :disabled="!isFormValid" class="submit-button">
                가입하기
            </button>
        </div>
    </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import { useUserStore } from '@/stores/user'
const userStore = useUserStore()


// 폼 전체 유효성 검사
const isFormValid = computed(() => {
    return isRequiredFieldsFilled.value && isPasswordMatch.value
})

const handleSubmit = () => {
    // 제출 전 모든 필드 다시 체크
    checkAllFields()

    if (!isFormValid.value) {
        return
    }

    // 폼 제출 로직
    console.log('폼 제출 성공!')
    //서버에 데이터 전송하기 
    const user = {
        name: name.value,
        email: email.value,
        phoneNumber: phone.value,
        birthDate: birthDate.value,
        gender: gender.value,
        address: address.value,
        userNickname: nickname.value,
        userId: userId.value,
        password: password.value
    }
    // console.log({
    //    name: name.value,
    //     email: email.value,
    //     phoneNumber: phone.value,
    //     birthDate: birthDate.value,
    //     gender: gender.value,
    //     address: address.value,
    //     userNickname: nickname.value,
    //     userId: userId.value,
    //     password: password.value
    // })

    userStore.join(user);
}

// 폼 데이터
const name = ref('')
const email = ref('')
const phone = ref('')
const birthDate = ref('')
const gender = ref('N')
const address = ref('')
const nickname = ref('')
const userId = ref('')
const password = ref('')
const passwordCheck = ref('')

// 에러 상태 관리
const errors = ref({
    name: false,
    email: false,
    phone: false,
    address: false,
    nickname: false,
    userId: false,
    password: false,
    passwordCheck: false
})

// 각 필드별 체크 함수
const checkName = () => {
    errors.value.name = !name.value.trim()
}

const checkEmail = () => {
    const enteredEmail = email.value.trim()
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/
    errors.value.email = !emailRegex.test(enteredEmail)
}

const checkPhone = () => {
    const enteredPhone = phone.value.trim()
    const phoneRegex = /^01[0-9][0-9]{8}$/ // 01로 시작하는 총 11자리 숫자
    errors.value.phone = !phoneRegex.test(enteredPhone)
}

const checkAddress = () => {
    errors.value.address = !address.value.trim()
}

const checkNickname = () => {
    errors.value.nickname = !nickname.value.trim()
}

const checkUserId = () => {
    errors.value.userId = !userId.value.trim()
}

const checkPassword = () => {
    errors.value.password = !password.value.trim()
}

const checkPasswordCheck = () => {
    errors.value.passwordCheck = !passwordCheck.value.trim()
}

// 모든 필드 체크
const checkAllFields = () => {
    checkName()
    checkEmail()
    checkPhone()
    checkAddress()
    checkNickname()
    checkUserId()
    checkPassword()
    checkPasswordCheck()
}

// 비밀번호 일치 여부 확인
const isPasswordMatch = computed(() => {
    return password.value === passwordCheck.value
})

// 필수 항목 유효성 검사
const isRequiredFieldsFilled = computed(() => {
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/
    const phoneRegex = /^01[0-9][0-9]{8}$/
    return (
        name.value.trim() !== '' &&
        email.value.trim() !== '' &&
        emailRegex.test(email.value.trim()) &&
        phone.value.trim() !== '' &&
        phoneRegex.test(phone.value.trim()) &&
        address.value.trim() !== '' &&
        nickname.value.trim() !== '' &&
        userId.value.trim() !== '' &&
        password.value.trim() !== '' &&
        passwordCheck.value.trim() !== ''
    )
})

</script>

<style scoped>
  .block {
    max-width: 800px; /* 600px에서 800px로 증가 */
    width: 90%; /* 반응형을 위한 설정 */
    margin: 3rem auto;
    background-color: white;
    border-radius: 16px;
    padding: 3rem; /* 2.5rem에서 3rem으로 증가 */
    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.06);
  }

  .form {
    width: 100%;
    max-width: 720px; /* 폼 내용의 최대 너비 설정 */
    margin: 0 auto;
  }

  /* 입력 필드 그룹 레이아웃 조정 */
  .input-group {
    margin-bottom: 1.8rem; /* 여백 살짝 증가 */
  }

  input, select {
    width: 100%;
    height: 52px; /* 높이 살짝 증가 */
    padding: 0 1.2rem; /* 좌우 패딩 증가 */
    border: 2px solid #F3F0E6;
    border-radius: 12px;
    font-size: 1rem; /* 폰트 크기 살짝 증가 */
    transition: all 0.3s ease;
    background-color: #FDFBF7;
    box-sizing: border-box;
  }

  /* 제목 크기 조정 */
  .block > h2 {
    text-align: center;
    color: #2d3748;
    font-size: 2rem; /* 1.8rem에서 2rem으로 증가 */
    margin-bottom: 1.8rem;
  }

  .block > h3 {
    color: #4a5568;
    font-size: 1.3rem; /* 1.2rem에서 1.3rem으로 증가 */
    margin: 1.8rem 0;
  }

  /* 라벨 크기 조정 */
  .form > p {
    font-size: 1rem; /* 0.95rem에서 1rem으로 증가 */
    font-weight: 600;
    color: #2d3748;
    margin: 1.2rem 0 0.6rem 0;
    display: flex;
    align-items: center;
  }

  /* 제출 버튼 크기 조정 */
  .submit-button {
    width: 100%;
    height: 52px; /* 48px에서 52px로 증가 */
    border-radius: 12px;
    font-size: 1.1rem; /* 폰트 크기 증가 */
    margin-top: 2.5rem; /* 상단 여백 증가 */
  }

  /* 구분선 여백 조정 */
  hr {
    border: none;
    border-top: 2px solid #F3F0E6;
    margin: 2.5rem 0; /* 2rem에서 2.5rem으로 증가 */
  }

  /* 나머지 스타일은 이전과 동일 */
  .required {
    color: #FF6B6B;
    margin-left: 4px;
    font-size: 1rem;
  }

  input:focus, select:focus {
    outline: none;
    border-color: #9EC5FE;
    box-shadow: 0 0 0 3px rgba(158, 197, 254, 0.2);
  }

  input::placeholder {
    color: #a0aec0;
  }

  select {
    cursor: pointer;
    appearance: none;
    background-image: url("data:image/svg+xml;charset=UTF-8,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24' fill='none' stroke='%234a5568' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'%3e%3cpolyline points='6 9 12 15 18 9'%3e%3c/polyline%3e%3c/svg%3e");
    background-repeat: no-repeat;
    background-position: right 1rem center;
    background-size: 1em;
  }

  .error-message {
    color: #FF6B6B;
    font-size: 0.85rem;
    margin-top: 0.5rem;
    margin-bottom: 0;
    display: flex;
    align-items: center;
    gap: 0.5rem;
  }

  .error-message::before {
    content: "!";
    display: inline-flex;
    align-items: center;
    justify-content: center;
    width: 16px;
    height: 16px;
    background-color: #FF6B6B;
    color: white;
    border-radius: 50%;
    font-size: 0.7rem;
    font-weight: bold;
  }

  .submit-button:hover:not(:disabled) {
    background-color: #7DB0FE;
    transform: translateY(-2px);
  }

  .submit-button:disabled {
    background-color: #E2E8F0;
    cursor: not-allowed;
    box-shadow: none;
  }

  input:hover:not(:focus), 
  select:hover:not(:focus) {
    border-color: #E2E8F0;
  }

  @keyframes fadeIn {
    from {
      opacity: 0;
      transform: translateY(-10px);
    }
    to {
      opacity: 1;
      transform: translateY(0);
    }
  }

  .error-message {
    animation: fadeIn 0.3s ease-out;
  }

  /* 반응형 디자인을 위한 미디어 쿼리 추가 */
  @media (max-width: 768px) {
    .block {
      width: 95%;
      padding: 2rem;
    }

    .form {
      padding: 0;
    }
  }
</style>