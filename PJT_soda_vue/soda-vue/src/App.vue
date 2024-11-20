<template>
      <div class="all-container">
            <Header/>
            <main class="main-content">
                  <RouterView/>
            </main>

           <Footer/>
      </div>
</template>

<script setup>

import Footer from './components/Layouts/Footer.vue';
import Header from './components/Layouts/Header.vue';


</script>

<style scoped>
.all-container{
display: flex;
  flex-direction: column;
  min-height: 100vh;
}
.main-content{
      flex: 1;
}
Footer{
      margin-top: auto;
}
</style>