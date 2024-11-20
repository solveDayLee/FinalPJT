<template>
    <div class="write-container">
      <h2 class="form-title">글쓰기</h2>
      
      <div class="form-content">
        <div class="input-group">
          <label>게시판</label>
          <select class="form-select">
            <option value="" disabled selected>게시판을 선택해주세요</option>
            <option v-for="category in categories" 
                    :key="category" 
                    :value="category">
              {{category}}
            </option>
          </select>
        </div>
        
        <div class="input-group">
          <label>제목</label>
          <input class="form-input" 
                 placeholder="제목을 입력해주세요"
                 type="text">
        </div>
        
        <div class="write-section">
          <textarea class="content-textarea" 
                  rows="20" 
                  placeholder="여기에 글을 입력해주세요..."></textarea>
        </div>
  
        <div class="attach-section">
          <div class="attach-header">
            <div class="attach-left">
              <span class="attach-title">첨부파일</span>
              <button class="attach-button">
                <span class="icon">📎</span>
                파일 첨부
              </button>
            </div>
            <span class="attach-size">{{ `${attachBytes}/10.00MB` }}</span>
          </div>
          <div class="file-list">
            <!-- 파일 목록이 여기에 표시됩니다 -->
          </div>
        </div>
  
        <div class="form-actions">
          <button class="cancel-button" type="button">취소</button>
          <button class="submit-button" type="submit">완료</button>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  
  const categories = [
      "자유이야기방",
      "수구",
      "발레",
      "정보공유방",
      "홍보방"
  ]
  
  const attachBytes = ref(0);
  </script>
  
  <style scoped>
  .write-container {
      width: 100%;
      max-width: 100%; /* 최대 너비 설정 */
      background-color: white;
      border-radius: 16px;
      padding: 2rem 3rem;
      box-shadow: 0 4px 16px rgba(0, 0, 0, 0.08);
  }
  
  .form-title {
      font-size: 1.75rem;
      font-weight: 700;
      color: #2E64A0;
      margin: 0 0 2rem 0;
      padding-bottom: 1rem;
      border-bottom: 2px solid #E5EEF9;
  }
  
  .form-content {
      display: flex;
      flex-direction: column;
      gap: 1.5rem;
  }
  
  .input-group {
      display: flex;
      align-items: center;
      gap: 1.5rem;
      margin-bottom: 1rem;
  }
  
  label {
      min-width: 80px;
      color: #2E64A0;
      font-weight: 600;
  }
  
  .form-select, .form-input {
      flex: 1;
      padding: 0.6rem 1rem;
      border: 1px solid #E5EEF9;
      border-radius: 6px;
      font-size: 0.95rem;
      color: #4A7AAB;
      background-color: white;
      transition: all 0.2s ease;
  }
  
  .form-select {
      max-width: 400px;
  }
  
  .form-select:hover, .form-input:hover {
      border-color: #CEE3F6;
  }
  
  .form-select:focus, .form-input:focus {
      outline: none;
      border-color: #2E64A0;
      box-shadow: 0 0 0 3px rgba(46, 100, 160, 0.1);
  }
  
  .content-textarea {
      width: 100%;
      padding: 1.5rem;
      border: 1px solid #E5EEF9;
      border-radius: 8px;
      font-size: 0.95rem;
      resize: vertical;
      min-height: 400px;
      color: #4A7AAB;
      transition: all 0.2s ease;
      line-height: 1.6;
  }
  
  .content-textarea:hover {
      border-color: #CEE3F6;
  }
  
  .content-textarea:focus {
      outline: none;
      border-color: #2E64A0;
      box-shadow: 0 0 0 3px rgba(46, 100, 160, 0.1);
  }
  
  .attach-section {
      background-color: #F7F9FC;
      border-radius: 8px;
      padding: 1rem 1.5rem;
  }
  
  .attach-header {
      display: flex;
      align-items: center;
      justify-content: space-between;
  }
  
  .attach-left {
      display: flex;
      align-items: center;
      gap: 1.5rem;
  }
  
  .attach-title {
      color: #2E64A0;
      font-weight: 600;
  }
  
  .attach-size {
      color: #4A7AAB;
  }
  
  .attach-button {
      display: flex;
      align-items: center;
      gap: 0.5rem;
      background-color: white;
      color: #2E64A0;
      border: 1px solid #CEE3F6;
      padding: 0.4rem 1rem;
      border-radius: 6px;
      font-size: 0.9rem;
      font-weight: 500;
      cursor: pointer;
      transition: all 0.2s ease;
  }
  
  .attach-button:hover {
      background-color: #CEE3F6;
  }
  
  .file-list {
      margin-top: 1rem;
      min-height: 40px;
  }
  
  .form-actions {
      display: flex;
      justify-content: center;
      gap: 1rem;
      margin-top: 2rem;
  }
  
  .cancel-button, .submit-button {
      padding: 0.6rem 2.5rem;
      border-radius: 6px;
      font-weight: 600;
      cursor: pointer;
      transition: all 0.2s ease;
      min-width: 120px;
  }
  
  .cancel-button {
      background-color: white;
      color: #4A7AAB;
      border: 1px solid #CEE3F6;
  }
  
  .cancel-button:hover {
      background-color: #F7F9FC;
  }
  
  .submit-button {
      background-color: #CEE3F6;
      color: #2E64A0;
      border: none;
  }
  
  .submit-button:hover {
      background-color: #B4D3F1;
  }
  
  @media (max-width: 1200px) {
      .write-container {
          padding: 2rem;
      }
  }
  
  @media (max-width: 768px) {
      .write-container {
          padding: 1.5rem;
      }
  
      .input-group {
          flex-direction: column;
          align-items: flex-start;
          gap: 0.5rem;
      }
  
      label {
          min-width: auto;
      }
  
      .form-select {
          max-width: 100%;
      }
  }
  </style>