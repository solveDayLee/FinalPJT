<template>
    <div class="block">
        <h2>회원가입</h2>
        <hr>
        <h3>회원 정보를 입력해주세요</h3>
        <div class="form">
            <p>이름<span class="required">*</span></p>
            <input 
                v-model="name"
                placeholder="이름을 입력해주세요"
                @blur="checkName"
            >
            <p v-if="errors.name" class="error-message">이름을 입력해주세요.</p>

            <p>이메일<span class="required">*</span></p>
            <input 
                v-model="email"
                placeholder="이메일을 입력해주세요"
                @blur="checkEmail"
            >
            <p v-if="errors.email" class="error-message">이메일을 올바르게 입력해주세요.</p>

            <p>휴대폰번호<span class="required">*</span></p>
            <input 
                v-model="phone"
                placeholder="'-'제외하고 입력"
                @blur="checkPhone"
            >
            <p v-if="errors.phone" class="error-message">휴대폰번호를 '-'를 제외하고 올바르게 입력해주세요.</p>

            <p>생년월일</p>
            <input 
                v-model="birthDate"
                placeholder="YYYYMMDD"
            >

            <p>성별</p>
            <select v-model="gender" name="gender">
                <option value="F">여</option>
                <option value="M">남</option>
                <option value="N">비공개</option>
            </select>

            <p>주소<span class="required">*</span></p>
            <input 
                v-model="address"
                placeholder="api 를 이용해서 수정할 예정"
                @blur="checkAddress"
            >
            <p v-if="errors.address" class="error-message">주소를 입력해주세요.</p>

            <hr>
            <p>닉네임<span class="required">*</span></p>
            <input 
                v-model="nickname"
                placeholder="닉네임을 입력해주세요"
                @blur="checkNickname"
            >
            <p v-if="errors.nickname" class="error-message">닉네임을 입력해주세요.</p>

            <p>아이디<span class="required">*</span></p>
            <input 
                v-model="userId"
                placeholder="아이디를 입력해주세요"
                @blur="checkUserId"
            >
            <p v-if="errors.userId" class="error-message">아이디를 입력해주세요.</p>

            <p>비밀번호<span class="required">*</span></p>
            <input 
                type="password"
                v-model="password"
                placeholder="비밀번호를 입력해주세요" 
                id="password"
                @blur="checkPassword"
            >
            <p v-if="errors.password" class="error-message">비밀번호를 입력해주세요.</p>

            <p>비밀번호 확인<span class="required">*</span></p>
            <input 
                type="password"
                v-model="passwordCheck"
                placeholder="비밀번호를 다시 입력해주세요" 
                id="password-check"
                @blur="checkPasswordCheck"
            >
            <p v-if="errors.passwordCheck" class="error-message">비밀번호 확인을 입력해주세요.</p>
            <p v-if="!isPasswordMatch && password && passwordCheck" class="error-message">
                비밀번호가 일치하지 않습니다.
            </p>
            
            <button 
                @click="handleSubmit"
                :disabled="!isFormValid"
                class="submit-button"
            >
                가입하기
            </button>
        </div>
    </div>
</template>

<script setup>
import { ref, computed } from 'vue'

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
    console.log({
        name: name.value,
        email: email.value,
        phone: phone.value,
        birthDate: birthDate.value,
        gender: gender.value,
        address: address.value,
        nickname: nickname.value,
        userId: userId.value,
        password: password.value
    })
}
</script>

<style scoped>
.block{
    background-color: rgb(227, 246, 255);
    width: 600px;
    border-radius: 20px;
    padding: 30px;
}
.block > h2{
    text-align: center;
}
.required {
    color: red;
}
.form > p{
    margin-top: 15px;
    margin-bottom: 5px;
}
input, select {
    width: 100%;
    height: 40px;
    border-radius: 10px;
    border: none;
    padding: 0 10px;
    box-sizing: border-box;
}
.error-message {
    color: red;
    font-size: 0.9em;
    margin-top: 5px;
    margin-bottom: 0;
}
.submit-button {
    width: 100%;
    height: 40px;
    border-radius: 10px;
    border: none;
    background-color: #007bff;
    color: white;
    font-weight: bold;
    margin-top: 20px;
    cursor: pointer;
}
.submit-button:disabled {
    background-color: #cccccc;
    cursor: not-allowed;
}
</style>