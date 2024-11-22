import { defineStore } from 'pinia'

export const useChatStore = defineStore('chat', {
  state: () => ({
    messages: [],
    isLoading: false
  }),

  actions: {
    async sendMessage(message) {
      try {
        const response = await fetch('http://localhost:8080/ecto/chat', { // URL 수정
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({ message })
        })
        const result = await response.text()
        return result
      } catch (error) {
        console.error('Error:', error)
        throw error
      }
    }
  }
})