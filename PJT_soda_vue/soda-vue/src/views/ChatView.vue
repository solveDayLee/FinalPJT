<template>
  <div class="chat-view">
    <h1 class="title">ETCO Chat</h1>
    <div class="chat-wrapper">
      <Chat />
    </div>
  </div>
</template>

<script setup>
import Chat from '@/components/Chat.vue'
</script>

<style scoped>
.chat-view {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  background-color: #ffffff;
  font-family: 'Noto Sans KR', sans-serif;
  /* margin-top: 30px; */
}

.title {
  font-size: 1.5rem;
  font-weight: bold;
  margin-bottom: 1.5rem;
  color: #495057;
}

.chat-wrapper {
  width: 100%;
  max-width: 600px;
}
</style>
