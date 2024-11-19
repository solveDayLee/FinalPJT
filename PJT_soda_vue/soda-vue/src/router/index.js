import BoardView from '@/views/BoardView.vue'
import DetailView from '@/views/DetailView.vue'
import JoinView from '@/views/JoinView.vue'
import LoginView from '@/views/LoginView.vue'
import WriteView from '@/views/WriteView.vue'
import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Main',
      component: () => import('@/views/MainPageView.vue')
    },
    {
      path: '/board',
      name: 'Board',
      component: BoardView,
    },
    {
      path: '/write',
      name: 'Write',
      component: WriteView,
    },
    {
      path: '/join',
      name: 'Join',
      component: JoinView,
    },
    {
      path: '/detailboard', //:id는 동적 라우트 파라미터
      name: 'DetailBoard',
      component: DetailView
    },
    {
      path: '/login',
      name: 'Login',
      component: LoginView
    },

  ],


})



export default router
