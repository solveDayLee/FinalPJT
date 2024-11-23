<template>
  <div class="chat-container">
    <!-- 질문 예시 섹션 (채팅 시작 전만 보임) -->
    <div v-if="!hasStarted" class="examples">
      <h6 class="examples-title">예시 질문</h6>
      <ul class="examples-list">
        <li v-for="(example, index) in exampleQuestions" :key="index">
          {{ example }}
        </li>
      </ul>
    </div>

    <!-- 채팅 메시지 섹션 -->
    <div class="messages" ref="chatBox">
      <div
        v-for="(msg, i) in chatStore.messages"
        :key="i"
        :class="['message', msg.type]"
      >
        <div class="message-content">{{ msg.content }}</div>
      </div>
      <!-- 로딩 표시 -->
      <div v-if="isLoading" class="loading-message">
        <div class="spinner"></div>
        <span>답변을 작성 중입니다...</span>
      </div>
    </div>

    <!-- 입력 섹션 -->
    <div class="input-area">
      <input
        v-model="userInput"
        @keyup.enter="sendMessage"
        type="text"
        placeholder="메시지를 입력하세요..."
        class="chat-input"
      />
      <button @click="sendMessage" class="chat-btn" :disabled="isLoading">Send</button>
      <button @click="resetChat" class="chat-btn reset-btn" :disabled="isLoading">Reset</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useChatStore } from '@/stores/chat'

const chatStore = useChatStore()
const userInput = ref('')
const isLoading = ref(false) // 로딩 상태 관리
const hasStarted = ref(false) // 채팅 시작 여부

// 질문 예시 데이터
const exampleQuestions = ref([
  '처음 세일링을 시작하려고 하는데 꼭 필요한 기본 장비가 뭐가 있나요?',
  '취미 발레에서 가장 먼저 배워야 할 기본 동작은 무엇인가요?',
  '리뽀스트가 정확히 무슨 뜻인가요?',
  '시합 중에 자주 하는 실수들은 어떤 것들이 있나요?'
])

const sendMessage = async () => {
  if (!userInput.value.trim()) return;

  hasStarted.value = true; // 채팅 시작
  isLoading.value = true; // 로딩 표시

  chatStore.messages.push({
    type: 'user',
    content: userInput.value
  });

  try {
    const response = await chatStore.sendMessage(userInput.value);
    chatStore.messages.push({
      type: 'ai',
      content: response
    });
    userInput.value = '';
  } catch (error) {
    chatStore.messages.push({
      type: 'error',
      content: '운동 및 스포츠 관련 질문만 답변드릴 수 있습니다. 다른 주제는 답변하지 않습니다.'
    });
    console.error(error);
  } finally {
    isLoading.value = false; // 로딩 종료
  }
};

const resetChat = async () => {
  try {
    await chatStore.resetConversation();
    chatStore.messages = [];
    hasStarted.value = false; // 초기 상태로 돌아감
  } catch (error) {
    console.error('대화 초기화 실패:', error);
  }
};
</script>

<style scoped>
.chat-container {
  font-family: 'Noto Sans KR', sans-serif;
  max-width: 500px;
  margin: 0 auto;
  background-color: #f8f9fa;
  border-radius: 12px;
  padding: 1.5rem;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

/* 질문 예시 스타일 */
.examples {
  margin-bottom: 1rem;
}

.examples-title {
  font-size: 0.95rem;
  font-weight: bold;
  color: #495057;
  margin-bottom: 0.5rem;
}

.examples-list {
  list-style: none;
  padding: 0;
  margin: 0;
  color: #6c757d;
  font-size: 0.9rem;
}

.examples-list li {
  margin-bottom: 0.5rem;
}

/* 로딩 표시 */
.loading-message {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  margin-top: 1rem;
  color: #6c757d;
  font-size: 0.9rem;
}

.spinner {
  width: 20px;
  height: 20px;
  border: 3px solid #abd6fe;
  border-top-color: transparent;
  border-radius: 50%;
  animation: spin 1s linear infinite;
}

@keyframes spin {
  from {
    transform: rotate(0deg);
  }
  to {
    transform: rotate(360deg);
  }
}

.messages {
  max-height: 400px;
  overflow-y: auto;
  display: flex;
  flex-direction: column;
  gap: 1rem;
  margin-bottom: 1rem;
}

.message {
  max-width: 70%;
  padding: 10px 15px;
  border-radius: 15px;
  word-wrap: break-word;
  line-height: 1.4;
  font-size: 0.9rem;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.message.user {
  align-self: flex-end;
  background-color: #abd6fe;
  color: #333;
  border-top-right-radius: 0;
}

.message.ai {
  align-self: flex-start;
  background-color: #f8f9fa;
  color: #495057;
  border: 1px solid #ddd;
  border-top-left-radius: 0;
}

.message.error {
  align-self: center;
  color: red;
  background-color: #ffecec;
  border: 1px solid #ffb6b6;
}

.input-area {
  display: flex;
  gap: 0.5rem;
}

.chat-input {
  flex: 1;
  padding: 0.8rem 1rem;
  border: none;
  border-radius: 20px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.chat-input:focus {
  outline: none;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
}

.chat-btn {
  padding: 0.8rem 1.5rem;
  background-color: #cee3f6;
  border: none;
  border-radius: 20px;
  font-weight: 500;
  color: #333;
  cursor: pointer;
  transition: all 0.3s ease;
}

.chat-btn:hover:not(:disabled) {
  background-color: #abd6fe;
}

.reset-btn {
  background-color: #f67280;
}

.reset-btn:hover {
  background-color: #f44336;
}
</style>
