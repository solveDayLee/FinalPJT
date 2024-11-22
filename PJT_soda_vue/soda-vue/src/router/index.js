import MainPageView from '@/views/MainPageView.vue'
import BoardView from '@/views/BoardView.vue'
import WriteView from '@/views/WriteView.vue'
import JoinView from '@/views/JoinView.vue'
import DetailView from '@/views/DetailView.vue'
import LoginView from '@/views/LoginView.vue'
import { createRouter, createWebHistory } from 'vue-router'
import UpdateView from '@/views/UpdateView.vue'
import { useBoardStore } from '@/stores/board'
import SupportView from '@/views/SupportView.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Home',
      component: MainPageView
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
      path: '/detailboard/:no', //:id는 동적 라우트 파라미터
      name: 'DetailBoard',
      component: DetailView
    },
    {
      path: '/login',
      name: 'Login',
      component: LoginView
    },
    {
      path: '/board/category/:category/:detailCategory?',
      name: 'BoardCategory',
      component: BoardView,
      props: true
    },
    {
      path: '/detailboard/update/:no',
      name: 'UpdateBoard',
      component: UpdateView,
    },
    {
      path: '/support',
      name: 'Support',
      component: SupportView
    },

  ],


})

// 전역 가드 설정
router.beforeEach((to,from,next)=>{
  if(to.params.category){
    const store = useBoardStore()
    store.setSelectedCategory(to.params.category)
  }
  next()
})


export default router
