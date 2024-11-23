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

import { onMounted } from 'vue';
import Footer from './components/Layouts/Footer.vue';
import Header from './components/Layouts/Header.vue';
import { useUserStore } from './stores/user';

const userStore = useUserStore()
onMounted(()=> {
      userStore.initializeUser()
})

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