<template>
    <div class="chat-container">
      <div class="messages" ref="chatBox">
        <div v-for="(msg, i) in chatStore.messages" :key="i" :class="msg.type">
          <div>{{ msg.content }}</div>
        </div>
      </div>
      <div class="input-area">
        <input v-model="userInput" @keyup.enter="sendMessage" type="text">
        <button @click="sendMessage">Send</button>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  import { useChatStore } from '@/stores/chat';
  
  const chatStore = useChatStore()
  const userInput = ref('')
  
  const sendMessage = async () => {
    if (!userInput.value.trim()) return
    
    chatStore.messages.push({
      type: 'user',
      content: userInput.value
    })
  
    try {
      const response = await chatStore.sendMessage(userInput.value)
      chatStore.messages.push({
        type: 'ai',
        content: response
      })
      userInput.value = ''
    } catch (error) {
      console.error(error)
    }
  }
  </script>