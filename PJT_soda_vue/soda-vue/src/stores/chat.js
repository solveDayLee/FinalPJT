import { defineStore } from 'pinia'
import axios from 'axios'

export const useChatStore = defineStore('chat', {
  state: () => ({
    messages: [] // 사용자와 AI 간의 메시지 기록
  }),
  actions: {
    async sendMessage(userMessage) {
      try {
        const response = await axios.post(`${import.meta.env.VITE_BASE_URL}/etco/chat`, {
          message: userMessage
        })
        return response.data
      } catch (error) {
        console.error('API 호출 에러:', error)
        throw new Error('AI 응답을 가져오지 못했습니다.')
      }
    },
    async resetConversation() {
      try {
        await axios.post(`${import.meta.env.VITE_BASE_URL}/etco/chat/reset`) // 백엔드 reset 엔드포인트 호출
      } catch (error) {
        console.error('대화 초기화 에러:', error)
        throw new Error('대화 초기화에 실패했습니다.')
      }
    }
  }
  
})
