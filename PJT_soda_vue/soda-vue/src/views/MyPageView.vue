<template>
    <div class="block">
      <h2>마이페이지</h2>
      <hr>
      
      <!-- 기본 정보 표시 섹션 -->
      <div v-if="!isEditing" class="user-info">
        <div class="profile-section">
          <div class="profile-image">
            <img src="@/assets/logo/profile.png" alt="프로필 이미지" class="rounded-full">
            <button class="edit-profile-btn">프로필 수정</button>
          </div>
          
          <div class="info-grid">
            <div class="info-item">
              <label>이름</label>
              <p>{{ userData.name }}</p>
            </div>
            <div class="info-item">
              <label>닉네임</label>
              <p>{{ userData.userNickname }}</p>
            </div>
            <div class="info-item">
              <label>이메일</label>
              <p>{{ userData.email }}</p>
            </div>
            <div class="info-item">
              <label>휴대폰</label>
              <p>{{ userData.phoneNumber }}</p>
            </div>
            <div class="info-item">
              <label>생년월일</label>
              <p>{{ userData.birthDate || '미입력' }}</p>
            </div>
            <div class="info-item">
              <label>성별</label>
              <p>{{ getGenderText(userData.gender) }}</p>
            </div>
            <div class="info-item full-width">
              <label>주소</label>
              <p>{{ getFullAddress() }}</p>
            </div>
          </div>
  
          <div class="action-buttons">
            <button @click="startEditing" class="primary-button">정보 수정</button>
            <button @click="showPasswordChange" class="secondary-button">비밀번호 변경</button>
          </div>
        </div>
      </div>
  
      <!-- 정보 수정 폼 -->
      <div v-else class="edit-form">
        <h3>회원 정보 수정</h3>
        <div class="form">
          <div class="input-group">
            <p>이름<span class="required">*</span></p>
            <input v-model="editData.name" placeholder="이름을 입력해주세요" @blur="checkName">
            <p v-if="errors.name" class="error-message">이름을 입력해주세요.</p>
          </div>
  
          <div class="input-group">
            <p>이메일<span class="required">*</span></p>
            <input v-model="editData.email" placeholder="이메일을 입력해주세요" @blur="checkEmail">
            <p v-if="errors.email" class="error-message">이메일을 올바르게 입력해주세요.</p>
          </div>
  
          <div class="input-group">
            <p>휴대폰번호<span class="required">*</span></p>
            <input v-model="editData.phoneNumber" placeholder="'-'제외하고 입력" @blur="checkPhone">
            <p v-if="errors.phone" class="error-message">휴대폰번호를 '-'를 제외하고 올바르게 입력해주세요.</p>
          </div>
  
          <div class="input-group">
            <p>생년월일</p>
            <input v-model="editData.birthDate" placeholder="YYYYMMDD">
          </div>
  
          <div class="input-group">
            <p>성별</p>
            <select v-model="editData.gender" name="gender">
              <option value="F">여</option>
              <option value="M">남</option>
              <option value="N">비공개</option>
            </select>
          </div>
  
          <div class="input-group">
            <p>주소<span class="required">*</span></p>
            <input type="text" placeholder="우편번호" v-model="editData.zonecode" readonly>
            <button type="button" @click="execDaumPostcode">우편번호 찾기</button>
            <input type="text" placeholder="주소" v-model="editData.address" readonly>
            <input type="text" placeholder="상세주소" v-model="editData.detailAddress">
            <p v-if="errors.address" class="error-message">주소를 입력해주세요.</p>
          </div>
  
          <div class="input-group">
            <p>닉네임<span class="required">*</span></p>
            <input v-model="editData.userNickname" placeholder="닉네임을 입력해주세요" @blur="checkNickname">
            <p v-if="errors.nickname" class="error-message">닉네임을 입력해주세요.</p>
          </div>
  
          <div class="button-group">
            <button @click="handleSubmit" :disabled="!isFormValid" class="submit-button">
              수정하기
            </button>
            <button @click="cancelEdit" class="cancel-button">
              취소
            </button>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, computed, onMounted } from 'vue'
  import { useUserStore } from '@/stores/user'
  
  const userStore = useUserStore()
  const isEditing = ref(false)
  
  // 더미 데이터 (실제로는 스토어나 API에서 가져올 것)
  const userData = ref({
    name: '홍길동',
    email: 'hong@example.com',
    phoneNumber: '01012345678',
    birthDate: '19900101',
    gender: 'M',
    address: '서울특별시 강남구 테헤란로',
    zonecode: '06234',
    detailAddress: '101동 1001호',
    userNickname: '길동이'
  })
  
  // 수정용 데이터
  const editData = ref({...userData.value})
  
  // 에러 상태 관리
  const errors = ref({
    name: false,
    email: false,
    phone: false,
    address: false,
    nickname: false
  })
  
  // 유효성 검사 함수들
  const checkName = () => {
    errors.value.name = !editData.value.name.trim()
  }
  
  const checkEmail = () => {
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/
    errors.value.email = !emailRegex.test(editData.value.email.trim())
  }
  
  const checkPhone = () => {
    const phoneRegex = /^01[0-9][0-9]{8}$/
    errors.value.phone = !phoneRegex.test(editData.value.phoneNumber.trim())
  }
  
  const checkNickname = () => {
    errors.value.nickname = !editData.value.userNickname.trim()
  }
  
  // 필수 항목 유효성 검사
  const isFormValid = computed(() => {
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/
    const phoneRegex = /^01[0-9][0-9]{8}$/
    
    return (
      editData.value.name.trim() !== '' &&
      emailRegex.test(editData.value.email.trim()) &&
      phoneRegex.test(editData.value.phoneNumber.trim()) &&
      editData.value.address.trim() !== '' &&
      editData.value.userNickname.trim() !== ''
    )
  })
  
  // 주소 찾기
  const execDaumPostcode = () => {
    new window.daum.Postcode({
      oncomplete: function(data) {
        editData.value.zonecode = data.zonecode
        editData.value.address = data.address
        editData.value.detailAddress = ''
      }
    }).open()
  }
  
  // 성별 텍스트 변환
  const getGenderText = (gender) => {
    const genderMap = {
      'M': '남성',
      'F': '여성',
      'N': '비공개'
    }
    return genderMap[gender] || '비공개'
  }
  
  // 전체 주소 조합
  const getFullAddress = () => {
    const parts = [
      `(${userData.value.zonecode})`,
      userData.value.address,
      userData.value.detailAddress
    ].filter(Boolean)
    return parts.join(' ')
  }
  
  // 수정 모드 시작
  const startEditing = () => {
    editData.value = {...userData.value}
    isEditing.value = true
  }
  
  // 수정 취소
  const cancelEdit = () => {
    isEditing.value = false
    errors.value = {
      name: false,
      email: false,
      phone: false,
      address: false,
      nickname: false
    }
  }
  
  // 수정 제출
  const handleSubmit = async () => {
    if (!isFormValid.value) return
    
    try {
      // API 호출 또는 스토어 업데이트
      userData.value = {...editData.value}
      isEditing.value = false
      // 성공 메시지 표시
    } catch (error) {
      console.error('정보 수정 실패:', error)
      // 에러 메시지 표시
    }
  }
  
  // 비밀번호 변경 다이얼로그 표시
  const showPasswordChange = () => {
    // 비밀번호 변경 다이얼로그 구현
  }
  
  onMounted(() => {
    // 실제 사용자 데이터 로드
    // userStore.getUserData()
  })
  </script>
  
  <style scoped>
  .block {
    max-width: 800px;
    width: 90%;
    margin: 3rem auto;
    background-color: white;
    border-radius: 16px;
    padding: 3rem;
    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.06);
  }
  
  .user-info {
    padding: 1rem 0;
  }
  
  .profile-section {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 2rem;
  }
  
  .profile-image {
    text-align: center;
  }
  
  .profile-image img {
    width: 70px;
    height: 70px;
    border-radius: 50%;
    margin-bottom: 1rem;
    margin-right: 1rem;
  }
  
  .edit-profile-btn {
    padding: 0.5rem 1rem;
    background-color: #f3f4f6;
    border-radius: 8px;
    font-size: 0.9rem;
  }
  
  .info-grid {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    gap: 1.5rem;
    width: 100%;
    margin-top: 2rem;
  }
  
  .info-item {
    display: flex;
    flex-direction: column;
    gap: 0.5rem;
  }
  
  .info-item.full-width {
    grid-column: span 2;
  }
  
  .info-item label {
    font-size: 0.9rem;
    color: #666;
  }
  
  .info-item p {
    font-size: 1rem;
    color: #333;
    padding: 0.5rem;
    background-color: #f9fafb;
    border-radius: 8px;
    min-height: 2.5rem;
    display: flex;
    align-items: center;
  }
  
  .action-buttons {
    display: flex;
    gap: 1rem;
    margin-top: 2rem;
  }
  
  .primary-button, .secondary-button {
    padding: 0.75rem 2rem;
    border-radius: 8px;
    font-weight: 500;
    transition: all 0.3s ease;
  }
  
  .primary-button {
    background-color: #9EC5FE;
    color: white;
  }
  
  .secondary-button {
    background-color: #f3f4f6;
    color: #333;
  }
  
  .primary-button:hover {
    background-color: #7DB0FE;
  }
  
  .secondary-button:hover {
    background-color: #e5e7eb;
  }
  
  /* 기존 스타일 유지 */
  .input-group, .form, .required, .error-message, .submit-button {
    /* 회원가입 폼의 스타일을 그대로 사용 */
  }
  
  .button-group {
    display: flex;
    gap: 1rem;
    margin-top: 2rem;
  }
  
  .cancel-button {
    width: 100%;
    height: 52px;
    border-radius: 12px;
    font-size: 1.1rem;
    background-color: #f3f4f6;
    color: #333;
  }
  
  @media (max-width: 768px) {
    .block {
      width: 95%;
      padding: 2rem;
    }
  
    .info-grid {
      grid-template-columns: 1fr;
    }
  
    .info-item.full-width {
      grid-column: span 1;
    }
  
    .action-buttons {
      flex-direction: column;
    }
  
    .button-group {
      flex-direction: column;
    }
    /* .rounded-full{
        width: 1px !important;
    } */
    .welcome-message {
  text-decoration: none;
  color: #333;
  padding: 0.5rem 1rem;
  border-radius: 8px;
  transition: all 0.3s ease;
}

.welcome-message:hover {
  background-color: #f3f4f6;
  color: #7DB0FE;
}
  }
  </style>