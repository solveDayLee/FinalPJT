<template>
    <div class="homepage">
      <!-- Hero Section -->
      <section class="hero-banner">
        <div class="background-elements">
          <div class="rectangle-1"></div>
          <div class="rectangle-2"></div>
          <div class="rectangle-8"></div>
          <div class="rectangle-9"></div>
          <div class="rectangle-3"></div>
          <div class="rectangle-5"></div>
          <div class="rectangle-6"></div>
          <div class="rectangle-7"></div>
        </div>
        <div class="hero-content">
          <h1 class="one-more-friend">One more friend</h1>
          <h2 class="thousands-more-fun">Thousands more fun!</h2>
          <p class="hero-description">
            Having a pet means you have more joy, a new friend, a happy person who will always be with you to have fun. We have 200+ different pets that can meet your needs!
          </p>
          <div class="hero-buttons">
            <button class="btn-primary">
              View Intro 
              <i class="bi bi-arrow-right-circle"></i>
            </button>
            <button class="btn-outline">
              Explore Now 
              <i class="bi bi-play-circle"></i>
            </button>
          </div>
        </div>
      </section>
  
      <!-- Featured Pets Section -->
      <section class="featured-section">
        <div class="section-header">
          <div class="whats-new">What's new?</div>
          <div class="div">추천 게시글</div>
        </div>
        
        <div class="pets-grid">
          <!-- First Row -->
          <div class="pets-row">
            <div v-for="n in 4" :key="`top-${n}`" class="product-card">
              <div class="pet-image">
                <img :src="`/placeholder-${n}.jpg`" :alt="`Pet ${n}`" class="placeholder-img">
              </div>
              <div class="pet-info">
                <h4>Pet Name {{ n }}</h4>
                <p>Description {{ n }}</p>
              </div>
            </div>
          </div>
          
          <!-- Second Row -->
          <div class="pets-row">
            <div v-for="n in 4" :key="`bottom-${n}`" class="product-card">
              <div class="pet-image">
                <img :src="`/placeholder-${n + 4}.jpg`" :alt="`Pet ${n + 4}`" class="placeholder-img">
              </div>
              <div class="pet-info">
                <h4>Pet Name {{ n + 4 }}</h4>
                <p>Description {{ n + 4 }}</p>
              </div>
            </div>
          </div>
        </div>
  
        <div class="view-more">
          <button class="btn-more">
            View more 
            <i class="bi bi-chevron-right"></i>
          </button>
        </div>
      </section>
  
      <!-- Products Section -->
      <section class="products-section">
        <div class="section-header">
          <div class="hard-to-choose">Hard to choose right products for your pets?</div>
          <div class="our-products">Our Products</div>
        </div>
        
        <div class="products-grid">
          <div v-for="n in 4" :key="n" class="product-card">
            <div class="product-image">
              <img :src="`/placeholder-product-${n}.jpg`" :alt="`Product ${n}`" class="placeholder-img">
            </div>
            <div class="product-info">
              <h4>Product Name {{ n }}</h4>
              <p>$29.99</p>
            </div>
          </div>
        </div>
  
        <!-- Adoption Banner -->
        <div class="banner">
          <div class="banner-content">
            <h2 class="adoption">Adoption</h2>
            <h3 class="we-need-help">We need help. So do they.</h3>
            <p class="banner-description">
              Adopt a pet and give it a home,<br>
              it will love you back unconditionally.
            </p>
            <div class="banner-buttons">
              <button class="btn-primary">
                Explore Now 
                <i class="bi bi-arrow-right-circle"></i>
              </button>
              <button class="btn-outline">
                View Intro 
                <i class="bi bi-play-circle"></i>
              </button>
            </div>
          </div>
        </div>
      </section>
  
      <!-- Blog Section -->
      <section class="blog-section">
        <div class="section-header">
          <div class="you-already-know">You already know?</div>
          <div class="useful-pet-knowledge">Useful pet knowledge</div>
        </div>
  
        <div class="blog-grid">
          <div v-for="(post, index) in blogPosts" :key="index" class="blog-card">
            <div class="blog-image">
              <img :src="`/placeholder-blog-${index + 1}.jpg`" :alt="post.title" class="placeholder-img">
            </div>
            <div class="blog-content">
              <span class="category">Pet knowledge</span>
              <h4>{{ post.title }}</h4>
              <p>{{ post.description }}</p>
            </div>
          </div>
        </div>
      </section>
    </div>
  </template>
  
  <script>
  export default {
    name: 'Homepage',
    
    data() {
      return {
        blogPosts: [
          {
            title: 'What is a Pomeranian? How to Identify Pomeranian Dogs',
            description: 'The Pomeranian, also known as the Pomeranian (Pom dog), is always in the top of the cutest pets. Not only that, the small, lovely, smart, friendly, and skillful circus dog breed.'
          },
          {
            title: 'Dog Diet You Need To Know',
            description: 'Dividing a dog\'s diet may seem simple at first, but there are some rules you should know so that your dog can easily absorb the nutrients in the diet.'
          },
          {
            title: 'Why Dogs Bite and Destroy Furniture and How to Prevent It Effectively',
            description: 'Dog bites are common during development. However, no one wants to see their furniture or important items being bitten by a dog.'
          }
        ]
      }
    }
  }
  </script>
  
  <style scoped>
  .homepage {
    background: #fdfdfd;
    width: 100%;
  }
  
  /* Hero Section */
  .hero-banner {
    background: linear-gradient(102.87deg, #FCEED5 6.17%, #FCEED5 75.14%, #FFE7BA 100%);
    border-radius: 0 0 40px 40px;
    padding: 80px 130px;
    position: relative;
    height: 695px;
  }
  
  .hero-content {
    position: relative;
    max-width: 480px;
    z-index: 1;
  }
  
  /* Featured Pets Section */
  .featured-section {
    padding: 60px 130px;
  }
  
  .section-header {
    margin-bottom: 40px;
  }
  
  .whats-new {
    font-size: 16px;
    color: #000;
    margin-bottom: 4px;
  }
  
  .div {
    font-size: 24px;
    color: #003459;
  }
  
  .pets-grid {
    display: flex;
    flex-direction: column;
    gap: 20px;
  }
  
  .pets-row {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    gap: 20px;
  }
  
  .product-card {
    background: #fff;
    border-radius: 12px;
    overflow: hidden;
    box-shadow: 0 4px 28px -2px rgba(0, 0, 0, 0.08);
  }
  
  .pet-image, .product-image, .blog-image {
    height: 240px;
    overflow: hidden;
  }
  
  .placeholder-img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    background: #f5f5f5;
  }
  
  .pet-info, .product-info, .blog-content {
    padding: 16px;
  }
  
  /* Products Section */
  .products-section {
    padding: 60px 130px;
  }
  
  .products-grid {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    gap: 20px;
    margin-bottom: 40px;
  }
  
  /* Banner */
  .banner {
    background: #003459;
    border-radius: 20px;
    padding: 60px;
    color: #fff;
    margin-top: 40px;
  }
  
  /* Blog Section */
  .blog-section {
    padding: 60px 130px;
  }
  
  .blog-grid {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 20px;
  }
  
  /* Buttons */
  .btn-primary, .btn-outline {
    display: flex;
    align-items: center;
    gap: 8px;
    padding: 14px 28px;
    border-radius: 57px;
    cursor: pointer;
  }
  
  .btn-primary {
    background: #003459;
    color: #fff;
    border: none;
  }
  
  .btn-outline {
    background: transparent;
    border: 1.5px solid #003459;
    color: #003459;
  }
  
  .view-more {
    display: flex;
    justify-content: flex-end;
    margin-top: 20px;
  }
  
  .category {
    background: #00A7E7;
    color: #fff;
    padding: 2px 10px;
    border-radius: 28px;
    font-size: 12px;
    display: inline-block;
    margin-bottom: 8px;
  }
  
  /* 반응형 스타일 */
  @media (max-width: 1200px) {
    .pets-row {
      grid-template-columns: repeat(2, 1fr);
    }
    
    .products-grid {
      grid-template-columns: repeat(2, 1fr);
    }
    
    .blog-grid {
      grid-template-columns: repeat(2, 1fr);
    }
    
    .hero-banner,
    .featured-section,
    .products-section,
    .blog-section {
      padding: 40px 20px;
    }
  }
  
  @media (max-width: 768px) {
    .pets-row,
    .products-grid,
    .blog-grid {
      grid-template-columns: 1fr;
    }
  }
  </style>