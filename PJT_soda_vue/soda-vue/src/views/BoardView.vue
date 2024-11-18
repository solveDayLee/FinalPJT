<template>
     <Banner/>
     <div class="content">
        <Sidebar/>
        <div class="BoardListDiv">
            <BoardList/>
        </div>
     </div>
  </template>
  
<script setup>

import BoardList from '@/components/BoardList.vue';
import Banner from '@/components/Layouts/Banner.vue';
import Footer from '@/components/Layouts/Footer.vue';
import Header from '@/components/Layouts/Header.vue';
import Sidebar from '@/components/Layouts/Sidebar.vue';

</script>

<style scoped>
.content{
  display: flex;
  /* justify-content: ; */
}
.BoardListDiv{
    display: flex;
    justify-content: center;
}
</style>