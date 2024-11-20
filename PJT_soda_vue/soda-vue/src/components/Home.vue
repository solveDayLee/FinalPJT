<template>
  <div class="homepage">
    <Banner />


    <!-- 실제 사용자 게시글 섹션 -->
    <section class="community-posts">
      <div class="section-header">
        <div class="section-tag">What's new?</div>
        <h2 class="section-title">추천 게시글</h2>
      </div>
      
      <div class="content-grid">
        <div v-for="post in communityPosts" :key="post.id" class="card">
          <div class="card-image">
            <img :src="`https://picsum.photos/400/400?random=${post.id}`" :alt="post.title">
          </div>
          <div class="card-content">
            <span class="card-tag">{{ post.category }}</span>
            <h4 class="card-title">{{ post.title }}</h4>
            <p class="card-meta">
              <span class="author">{{ post.author }}</span>
              <span class="views">조회수 {{ post.views }}</span>
            </p>
          </div>
        </div>
      </div>

      <div class="view-more">
        <button class="btn-more" @click="goToCommunity">
          더보기
          <i class="bi bi-chevron-right"></i>
        </button>
      </div>
    </section>

    <!-- 광고/프로모션 섹션 -->
    <section class="promotion-section">
      <div class="section-header">
        <div class="section-tag">Special</div>
        <h2 class="section-title">추천 스포츠</h2>
      </div>
      
      <div class="promotion-grid">
        <div v-for="promo in promotions" :key="promo.id" class="promo-card">
          <div class="card-image">
            <img :src="`https://picsum.photos/400/400?random=${promo.id + 20}`" :alt="promo.title">
          </div>
          <div class="card-content">
            <span class="promo-tag">{{ promo.tag }}</span>
            <h4 class="card-title">{{ promo.title }}</h4>
            <p class="card-description">{{ promo.description }}</p>
            <button class="promo-btn" @click="goToPromotion(promo.id)">자세히 보기</button>
          </div>
        </div>
      </div>
    </section>

    <!-- 에디터 기사 섹션 -->
    <section class="blog-section">
      <div class="section-header">
        <div class="section-tag">Editor's Pick</div>
        <h2 class="section-title">스포츠 이야기</h2>
      </div>

      <div class="content-grid">
        <div v-for="article in articles" :key="article.id" 
             class="article-card" 
             @click="goToArticle(article.id)">
          <div class="card-image">
            <img :src="`https://picsum.photos/400/400?random=${article.id + 30}`" :alt="article.title">
          </div>
          <div class="card-content">
            <span class="card-tag">{{ article.category }}</span>
            <h4 class="card-title">{{ article.title }}</h4>
            <p class="card-description">{{ article.description }}</p>
            <div class="article-meta">
              <span class="editor">{{ article.editor }}</span>
              <span class="date">{{ formatDate(article.publishDate) }}</span>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import Banner from '@/components/Layouts/Banner.vue'

const router = useRouter()

// 커뮤니티 게시글 데이터
const communityPosts = ref([
  {
    id: 1,
    title: '처음 배우는 수상스키',
    category: '수상스키',
    author: '물사랑',
    views: 1234,
  },
  {
    id: 2,
    title: '클라이밍 초보 도전기',
    category: '클라이밍',
    author: '산돌이',
    views: 856,
  },
  {
    id: 3,
    title: '패러글라이딩 첫 경험',
    category: '패러글라이딩',
    author: '하늘날다',
    views: 2341,
  },
  {
    id: 4,
    title: '윈드서핑 장비 추천',
    category: '윈드서핑',
    author: '파도타기',
    views: 654,
  },
  {
    id: 5,
    title: '스케이트보드 기술 공유',
    category: '스케이트보드',
    author: '보드킹',
    views: 1678,
  },
  {
    id: 6,
    title: '프리다이빙 팁',
    category: '프리다이빙',
    author: '물속여행',
    views: 943,
  },
  {
    id: 7,
    title: '볼더링 초보 꿀팁',
    category: '클라이밍',
    author: '암벽왕',
    views: 1532,
  },
  {
    id: 8,
    title: '카약 투어 후기',
    category: '카약',
    author: '강물친구',
    views: 876,
  }
])

// 프로모션 데이터
const promotions = ref([
  {
    id: 1,
    title: '동계 스포츠의 짜릿함',
    tag: 'Special',
    description: '스노우보드의 매력에 빠져보세요',
  },
  {
    id: 2,
    title: '여름 수상 스포츠',
    tag: 'Hot',
    description: '시원한 물과 함께하는 익스트림 스포츠',
  },
  {
    id: 3,
    title: '실내 클라이밍',
    tag: 'New',
    description: '안전하게 즐기는 실내 암벽등반',
  },
  {
    id: 4,
    title: '패러글라이딩 체험',
    tag: 'Adventure',
    description: '하늘을 나는 특별한 경험',
  }
])

// 에디터 기사 데이터
const articles = ref([
  {
    id: 1,
    title: '수상스키의 세계',
    category: '스포츠 가이드',
    description: '초보자도 쉽게 배우는 수상스키의 모든 것',
    editor: '김에디터',
    publishDate: new Date(),
  },
  {
    id: 2,
    title: '클라이밍의 매력',
    category: '스포츠 스토리',
    description: '실내 클라이밍부터 자연 암벽까지',
    editor: '이에디터',
    publishDate: new Date(),
  },
  {
    id: 3,
    title: '패러글라이딩 입문',
    category: '초보 가이드',
    description: '패러글라이딩을 시작하는 방법',
    editor: '박에디터',
    publishDate: new Date(),
  }
])

// 날짜 포맷 함수
const formatDate = (date) => {
  return new Date(date).toLocaleDateString('ko-KR', {
    year: 'numeric',
    month: 'long',
    day: 'numeric'
  })
}

// 페이지 이동 함수들
const goToCommunity = () => {
  router.push('/community')
}

const goToPromotion = (id) => {
  router.push(`/promotion/${id}`)
}

const goToArticle = (id) => {
  router.push(`/article/${id}`)
}
</script>

<style scoped>
.homepage {
  width: 100%;
  background-color: #FBF8EF;
}

/* Hero Section */
.hero-banner {
  background: linear-gradient(102.87deg,
          #4A90E2 0%,
          #67A6E4 50%,
          #81B9E5 100%);
  padding: 80px 40px;
  position: relative;
  margin: 0 auto;
  max-width: 2000px;
}

.hero-content {
  max-width: 800px;
  margin: 0 auto;
  text-align: center;
  color: white;
}

.one-more-friend {
  font-size: 48px;
  font-weight: bold;
  margin-bottom: 20px;
}

.thousands-more-fun {
  font-size: 36px;
  margin-bottom: 30px;
}

.hero-description {
  font-size: 18px;
  line-height: 1.6;
  margin-bottom: 40px;
  opacity: 0.9;
}

/* Common Section Styles */
section {
  padding: 60px 40px;
  max-width: 2000px;
  margin: 0 auto;
}

.section-header {
  text-align: center;
  margin-bottom: 40px;
}

.section-tag {
  color: #4A90E2;
  font-size: 18px;
  font-weight: 500;
  margin-bottom: 10px;
}

.section-title {
  font-size: 32px;
  color: #2D3748;
  font-weight: bold;
}

/* Grid Layout */
.content-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 30px;
  padding: 20px 0;
}

/* Card Styles */
.card {
  background: white;
  border-radius: 16px;
  overflow: hidden;
  box-shadow: 0 8px 24px rgba(0, 0, 0, 0.06);
  transition: transform 0.3s ease;
}

.card:hover {
  transform: translateY(-5px);
}

.card-image {
  aspect-ratio: 1;
  overflow: hidden;
}

.card-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.card-content {
  padding: 24px;
}

.card-tag {
  display: inline-block;
  padding: 6px 12px;
  background-color: #9EC5FE;
  color: #1a365d;
  border-radius: 20px;
  font-size: 14px;
  margin-bottom: 12px;
}

.card-title {
  font-size: 20px;
  color: #2D3748;
  margin-bottom: 12px;
  font-weight: 600;
}

.card-description {
  color: #4A5568;
  font-size: 16px;
  line-height: 1.6;
}

/* Promotion Section Styles */
.promotion-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
  gap: 30px;
  padding: 20px 0;
}

.promo-card {
  background: white;
  border-radius: 16px;
  overflow: hidden;
  box-shadow: 0 8px 24px rgba(0, 0, 0, 0.06);
  transition: transform 0.3s ease;
  cursor: pointer;
}

.promo-card:hover {
  transform: translateY(-5px);
}

.promo-tag {
  background-color: #FF6B6B;
  color: white;
  padding: 6px 12px;
  border-radius: 20px;
  font-size: 14px;
  margin-bottom: 12px;
  display: inline-block;
}

.promo-btn {
  background-color: #4A90E2;
  color: white;
  padding: 8px 16px;
  border-radius: 8px;
  border: none;
  margin-top: 12px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.promo-btn:hover {
  background-color: #357ABD;
}

/* Button Styles */
.hero-buttons, .banner-buttons {
  display: flex;
  gap: 20px;
  justify-content: center;
}

.btn-primary, .btn-secondary {
  padding: 14px 28px;
  border-radius: 57px;
  font-size: 16px;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.3s ease;
  display: flex;
  align-items: center;
  gap: 8px;
}

.btn-primary {
  background: white;
  color: #4A90E2;
  border: none;
}

.btn-secondary {
  background: transparent;
  border: 2px solid white;
  color: white;
}

.btn-more {
  background: #9EC5FE;
  color: white;
  padding: 12px 24px;
  border-radius: 12px;
  border: none;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.3s ease;
  display: flex;
  align-items: center;
  gap: 8px;
}

.btn-primary:hover, 
.btn-secondary:hover, 
.btn-more:hover {
  transform: translateY(-2px);
}

.view-more {
  display: flex;
  justify-content: center;
  margin-top: 40px;
}

/* Meta Information Styles */
.card-meta {
  display: flex;
  justify-content: space-between;
  color: #666;
  font-size: 14px;
  margin-top: 8px;
}
/* 기사 카드 특별 스타일 */
.article-card {
  cursor: pointer;
}

.article-meta {
  display: flex;
  justify-content: space-between;
  margin-top: 12px;
  color: #666;
  font-size: 14px;
}

</style>