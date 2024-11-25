<template>
    <div class="write-container">
      <form @submit.prevent="createBoard">
        <h2 class="form-title">글쓰기</h2>
  
        <div class="form-content">
          <!-- 카테고리 선택 -->
          <div class="input-group">
            <label>게시판</label>
            <div class="category-wrapper">
              <select v-model="board.category" class="category" @change="handleMainCategoryChange">
                <option value="" disabled>게시판을 선택해주세요</option>
                <option v-for="sport in sports" :key="sport.code" :value="sport.code"
                  :disabled="sport.code === 'EDITOR'">
                  {{ sport.name }}
                </option>
              </select>
  
              <select v-if="board.category && showSubCategory" v-model="board.detailCategory" class="category sub-category">
                <option value="" disabled>세부 카테고리를 선택해주세요</option>
                <option v-for="menu in sportMenus" :key="menu.code" :value="menu.code">{{ menu.name }}</option>
              </select>
            </div>
          </div>
  
          <!-- 제목 -->
          <div class="input-group">
            <label>제목</label>
            <input
              v-model="board.title"
              class="form-input"
              placeholder="예: 자유게시판에 올릴 제목을 입력하세요"
              type="text"
            />
          </div>
  
          <!-- Quill Editor -->
          <div class="write-section">
            <label>내용</label>
            <div id="editor-container" class="quill-editor" placeholder="내용을 입력하세요"></div>
          </div>
  
          <!-- 액션 버튼 -->
          <div class="form-actions">
            <button class="cancel-button" type="button" @click="cancelPost">
              <span>취소</span>
            </button>
            <button class="submit-button" type="submit">
              <span>작성 완료</span>
            </button>
          </div>
        </div>
      </form>
    </div>
  </template>
  
  <script setup>
  import { ref, computed, onMounted } from 'vue';
  import Quill from 'quill';
  import axios from 'axios';
  import 'quill/dist/quill.snow.css'
  import { useBoardStore } from '@/stores/board';
  
  const board = ref({
    category: '',
    detailCategory: '',
    title: '',
    writer: '',
    content: '',
  });
  
  const sports = [
    { code: 'COMMUNITY', name: '자유게시판' },
    { code: 'WATERPOLO', name: '수구' },
    { code: 'BALLET', name: '발레' },
    { code: 'CURLING', name: '컬링' },
    { code: 'SCUBA', name: '스쿠버다이빙' },
    { code: 'SAILING', name: '세일링' },
    { code: 'ARCHERY', name: '양궁' },
  ];
  
  const sportMenus = [
    { code: 'GUIDE', name: '초보자 가이드' },
    { code: 'INFO', name: '정보/소식' },
    { code: 'QNA', name: 'Q&A' },
    { code: 'TIPS', name: '꿀팁 공유' },
    { code: 'LESSON', name: '강습/레슨' },
    { code: 'MARKET', name: '중고장터' },
    { code: 'CLUB', name: '동호회/모임' },
  ];
  
  const handleMainCategoryChange = () => {
    board.value.detailCategory = '';
  };
  
  const showSubCategory = computed(() => {
    return board.value.category !== 'COMMUNITY';
  });
  
  let quillEditor;
  
  onMounted(() => {
  quillEditor = new Quill('#editor-container', {
    theme: 'snow',
    placeholder: '내용을 입력해주세요', // 플레이스홀더 추가
    modules: {
      toolbar: {
        container: [
          ['bold', 'italic', 'underline', 'strike'],
          ['blockquote', 'code-block'],
          [{ list: 'ordered' }, { list: 'bullet' }],
          ['link', 'image']
        ],
        handlers: {
          image: imageHandler
        }
      }
    }
  });
});

// 이미지 핸들러 함수
const imageHandler = () => {
  const input = document.createElement('input');
  input.setAttribute('type', 'file');
  input.setAttribute('accept', 'image/*');
  input.click();

  input.onchange = async () => {
    const file = input.files[0];
    
    // 여기에 이미지 업로드 로직 추가
    // 예: FormData를 사용하여 서버에 업로드
    try {
      const formData = new FormData();
      formData.append('image', file);
      
      // 이미지 업로드 API 호출 (실제 API 엔드포인트로 수정 필요)
      // const response = await axios.post('/api/upload', formData);
      // const imageUrl = response.data.url;
          // 서버로 이미지 업로드
        const response = await axios.post('http://localhost:8080/img/upload', formData, {
            headers: {
                'Content-Type': 'multipart/form-data',
                'Authorization': `Bearer ${localStorage.getItem('token')}`
             }
            });
        const imageUrl = response.data.url;

      // 에디터에 이미지 삽입
      const range = quillEditor.getSelection();
      quillEditor.insertEmbed(range.index, 'image', imageUrl);
    } catch (error) {
      console.error('이미지 업로드 실패:', error);
    }
  };
};


  const createBoard = async () => {
    // Quill 에디터 내용 가져오기
    board.value.content = quillEditor.root.innerHTML;
  
    // 게시글 저장 API 호출
    const store = useBoardStore();
    await store.createBoard(board.value);
  };
  
  const cancelPost = () => {
    console.log('취소 버튼 클릭');
    history.back();
  };

  </script>
  
  <style scoped>

  .write-container {
    width: 100%;
    max-width: 900px;
    margin: 0 auto;
    background-color: white;
    border-radius: 16px;
    padding: 2rem 3rem;
    box-shadow: 0 4px 16px rgba(0, 0, 0, 0.1);
  }
  
  /* 제목 */
  .form-title {
    font-size: 1.8rem;
    font-weight: 700;
    color: #2e64a0;
    margin-bottom: 1.5rem;
    text-align: center;
  }
  
  /* 폼 그룹 */
  .input-group {
    display: flex;
    flex-direction: column;
    margin-bottom: 1.5rem;
  }
  
  label {
    font-size: 1rem;
    font-weight: 600;
    margin-bottom: 0.5rem;
    color: #2e64a0;
  }
  
  /* 카테고리 및 제목 */
  .category,
  .sub-category,
  .form-input {
    padding: 0.8rem 1rem;
    border: 1px solid #e5eef9;
    border-radius: 6px;
    font-size: 1rem;
    color: #4a7aab;
    transition: border-color 0.2s;
  }
  
  .category:hover,
  .sub-category:hover,
  .form-input:hover {
    border-color: #cee3f6;
  }
  
  .category:focus,
  .sub-category:focus,
  .form-input:focus {
    outline: none;
    border-color: #2e64a0;
    box-shadow: 0 0 0 3px rgba(46, 100, 160, 0.1);
  }
  
  /* Quill 에디터 스타일 */
  .quill-editor {
    height: 400px;
    border: 1px solid #e5eef9;
    border-radius: 8px;
    padding: 1rem;
    background-color: white;
    margin-top: 1rem;
  }
  
  /* 버튼 섹션 */
  .form-actions {
    display: flex;
    justify-content: space-between;
    gap: 1rem;
    margin-top: 2rem;
  }
  
  .cancel-button,
  .submit-button {
    padding: 0.8rem 2rem;
    font-size: 1rem;
    font-weight: 600;
    border-radius: 8px;
    cursor: pointer;
    transition: background-color 0.3s;
  }
  
  .cancel-button {
    background-color: white;
    border: 1px solid #cee3f6;
    color: #4a7aab;
  }
  
  .cancel-button:hover {
    background-color: #f7f9fc;
  }
  
  .submit-button {
    background-color: #2e64a0;
    border: none;
    color: white;
  }
  
  .submit-button:hover {
    background-color: #1b4e81;
  }
  </style>
  