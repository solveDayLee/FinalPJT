<!-- AdminRequest.vue -->
<template>
    <div class="admin-request-container">
      <header class="header">
        <h1 class="title">커뮤니티 관리자 신청</h1>
        <p class="subtitle">스포츠 전문가이신가요? 커뮤니티를 함께 발전시켜주세요!</p>
      </header>
  
      <div class="dashboard-stats">
        <div class="stat-card">
          <span class="stat-number">127</span>
          <span class="stat-label">활동 관리자</span>
        </div>
        <div class="stat-card">
          <span class="stat-number">48</span>
          <span class="stat-label">승인 대기</span>
        </div>
        <div class="stat-card">
          <span class="stat-number">15</span>
          <span class="stat-label">이번 달 승인</span>
        </div>
      </div>
  
      <div class="request-form">
        <h2>관리자 신청서</h2>
        
        <div class="form-group">
          <label for="username">닉네임</label>
          <input type="text" id="username" v-model="username" placeholder="커뮤니티에서 사용중인 닉네임" />
        </div>
  
        <div class="form-group">
          <label for="email">이메일</label>
          <input type="email" id="email" v-model="email" placeholder="연락받으실 이메일 주소" />
        </div>
  
        <div class="form-group">
          <label>전문 분야 (다중 선택 가능)</label>
          <div class="checkbox-group">
            <label class="checkbox-label">
              <input type="checkbox" v-model="sports" value="fencing"> 펜싱
            </label>
            <label class="checkbox-label">
              <input type="checkbox" v-model="sports" value="ballet"> 발레
            </label>
            <label class="checkbox-label">
              <input type="checkbox" v-model="sports" value="waterpolo"> 수구
            </label>
            <label class="checkbox-label">
              <input type="checkbox" v-model="sports" value="archery"> 양궁
            </label>
            <label class="checkbox-label">
              <input type="checkbox" v-model="sports" value="rowing"> 조정
            </label>
          </div>
        </div>
  
        <div class="form-group">
          <label for="experience">전문가 경력</label>
          <select id="experience" v-model="experience">
            <option value="">경력을 선택해주세요</option>
            <option value="athlete">현역 선수</option>
            <option value="ex-athlete">은퇴 선수</option>
            <option value="coach">코치/지도자</option>
            <option value="referee">심판</option>
            <option value="enthusiast">열성 애호가</option>
          </select>
        </div>
  
        <div class="form-group">
          <label for="career">경력 사항</label>
          <textarea id="career" v-model="career" rows="3" 
            placeholder="관련 자격증, 수상 경력, 지도 경력 등을 자유롭게 기재해주세요"></textarea>
        </div>
  
        <div class="form-group">
          <label for="motivation">지원 동기</label>
          <textarea id="motivation" v-model="motivation" rows="3"
            placeholder="커뮤니티에서 어떤 역할을 하고 싶으신가요?"></textarea>
        </div>
  
        <div class="form-group">
          <label>관리자 활동 가능 시간</label>
          <div class="time-slots">
            <label class="time-slot">
              <input type="checkbox" v-model="timeSlots" value="morning"> 오전 (06:00-12:00)
            </label>
            <label class="time-slot">
              <input type="checkbox" v-model="timeSlots" value="afternoon"> 오후 (12:00-18:00)
            </label>
            <label class="time-slot">
              <input type="checkbox" v-model="timeSlots" value="evening"> 저녁 (18:00-24:00)
            </label>
          </div>
        </div>
  
        <button class="submit-btn" @click="submitRequest">관리자 신청하기</button>
      </div>
  
      <div class="request-list">
        <div class="list-header">
          <h2>신청 현황</h2>
          <div class="filters">
            <select v-model="statusFilter">
              <option value="all">전체 보기</option>
              <option value="pending">승인 대기</option>
              <option value="approved">승인됨</option>
              <option value="rejected">반려됨</option>
            </select>
          </div>
        </div>
  
        <table>
          <thead>
            <tr>
              <th>신청일</th>
              <th>닉네임</th>
              <th>전문 분야</th>
              <th>경력</th>
              <th>상태</th>
              <th>처리일</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(request, index) in previousRequests" :key="index">
              <td>{{ request.date }}</td>
              <td>{{ request.user }}</td>
              <td>{{ request.sports }}</td>
              <td>{{ request.experience }}</td>
              <td :class="request.status">{{ request.status }}</td>
              <td>{{ request.processDate }}</td>
            </tr>
          </tbody>
        </table>
  
        <div class="pagination">
          <button>&lt;</button>
          <button class="active">1</button>
          <button>2</button>
          <button>3</button>
          <button>&gt;</button>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'AdminRequest',
    data() {
      return {
        username: '',
        email: '',
        sports: [],
        experience: '',
        career: '',
        motivation: '',
        timeSlots: [],
        statusFilter: 'all',
        previousRequests: [
          { 
            date: '2024-11-20', 
            user: '펜싱마스터', 
            sports: '펜싱',
            experience: '현역 선수',
            status: '승인대기',
            processDate: '-'
          },
          { 
            date: '2024-11-19', 
            user: '발레리나99', 
            sports: '발레',
            experience: '코치/지도자',
            status: '승인',
            processDate: '2024-11-20'
          },
          { 
            date: '2024-11-18', 
            user: '수구왕', 
            sports: '수구',
            experience: '은퇴 선수',
            status: '반려',
            processDate: '2024-11-19'
          },
        ]
      }
    },
    methods: {
      submitRequest() {
        alert('관리자 신청이 접수되었습니다. 검토 후 이메일로 결과를 알려드리겠습니다.')
        this.resetForm()
      },
      resetForm() {
        this.username = ''
        this.email = ''
        this.sports = []
        this.experience = ''
        this.career = ''
        this.motivation = ''
        this.timeSlots = []
      }
    }
  }
  </script>
  
  <style scoped>
  .admin-request-container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 2rem;
    background-color: #f5f5f1;
  }
  
  .header {
    background-color: #4A90E2;
    padding: 2rem;
    border-radius: 12px;
    margin-bottom: 2rem;
    text-align: center;
  }
  
  .title {
    color: white;
    margin: 0;
    font-size: 2rem;
    margin-bottom: 0.5rem;
  }
  
  .subtitle {
    color: white;
    margin: 0;
    opacity: 0.9;
  }
  
  .dashboard-stats {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 1.5rem;
    margin-bottom: 2rem;
  }
  
  .stat-card {
    background-color: white;
    padding: 1.5rem;
    border-radius: 8px;
    text-align: center;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }
  
  .stat-number {
    display: block;
    font-size: 2rem;
    font-weight: bold;
    color: #4A90E2;
    margin-bottom: 0.5rem;
  }
  
  .stat-label {
    color: #666;
    font-size: 0.9rem;
  }
  
  .request-form {
    background-color: white;
    padding: 2rem;
    border-radius: 12px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    margin-bottom: 2rem;
  }
  
  .request-form h2 {
    color: #333;
    margin-bottom: 1.5rem;
  }
  
  .form-group {
    margin-bottom: 1.5rem;
  }
  
  label {
    display: block;
    margin-bottom: 0.5rem;
    color: #333;
    font-weight: bold;
  }
  
  input[type="text"],
  input[type="email"],
  select,
  textarea {
    width: 100%;
    padding: 0.8rem;
    border: 1px solid #ddd;
    border-radius: 6px;
    font-size: 1rem;
  }
  
  .checkbox-group {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(150px, 1fr));
    gap: 1rem;
    margin-top: 0.5rem;
  }
  
  .checkbox-label {
    display: flex;
    align-items: center;
    font-weight: normal;
  }
  
  .checkbox-label input[type="checkbox"] {
    margin-right: 0.5rem;
  }
  
  .time-slots {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
    gap: 1rem;
    margin-top: 0.5rem;
  }
  
  .time-slot {
    display: flex;
    align-items: center;
    font-weight: normal;
  }
  
  .time-slot input[type="checkbox"] {
    margin-right: 0.5rem;
  }
  
  .submit-btn {
    background-color: #4A90E2;
    color: white;
    border: none;
    padding: 1rem 2rem;
    border-radius: 6px;
    cursor: pointer;
    font-size: 1rem;
    width: 100%;
    font-weight: bold;
    transition: background-color 0.3s;
  }
  
  .submit-btn:hover {
    background-color: #357ABD;
  }
  
  .request-list {
    background-color: white;
    padding: 2rem;
    border-radius: 12px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }
  
  .list-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 1.5rem;
  }
  
  .filters select {
    padding: 0.5rem;
    border-radius: 4px;
    border: 1px solid #ddd;
  }
  
  table {
    width: 100%;
    border-collapse: collapse;
  }
  
  th, td {
    padding: 1rem;
    text-align: left;
    border-bottom: 1px solid #ddd;
  }
  
  th {
    background-color: #f8f9fa;
    font-weight: bold;
    color: #333;
  }
  
  .승인대기 {
    color: #F5A623;
  }
  
  .승인 {
    color: #27AE60;
  }
  
  .반려 {
    color: #E74C3C;
  }
  
  .pagination {
    display: flex;
    justify-content: center;
    gap: 0.5rem;
    margin-top: 1.5rem;
  }
  
  .pagination button {
    padding: 0.5rem 1rem;
    border: 1px solid #ddd;
    background-color: white;
    cursor: pointer;
    border-radius: 4px;
  }
  
  .pagination button.active {
    background-color: #4A90E2;
    color: white;
    border-color: #4A90E2;
  }
  
  @media (max-width: 768px) {
    .dashboard-stats {
      grid-template-columns: 1fr;
    }
    
    .checkbox-group,
    .time-slots {
      grid-template-columns: 1fr;
    }
    
    th, td {
      padding: 0.5rem;
      font-size: 0.9rem;
    }
  }
  </style>