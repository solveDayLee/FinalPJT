<template>
  <Banner/>
  <div class="layout-container">
    <div class="sidebar-area">
      <Sidebar/>
    </div>
    <div class="main-content">
      <BoardList/>
    </div>
  </div>
</template>

<script setup>
import BoardList from '@/components/BoardList.vue';
import Banner from '@/components/Layouts/Banner.vue';
import Sidebar from '@/components/Layouts/Sidebar.vue';
</script>

<style scoped>
.layout-container {
  display: flex;
  background-color: #FBF8EF;
  min-height: calc(100vh - 120px);
  width: 100%;
  position: relative;
}

.sidebar-area {
  width: 250px;
  position: fixed;
  left: 0;
  top: 120px; /* Banner 높이만큼 조정 */
  bottom: 0;
  overflow-y: auto;
  padding: 2rem 0;
  background-color: #FBF8EF;
  z-index: 10;
}

.main-content {
  flex: 1;
  margin-left: 250px; /* sidebar 너비만큼 */
  padding: 2rem;
  width: calc(100% - 250px);
  max-width: 1200px;
  margin-right: auto;
  position: relative;
}

@media (max-width: 768px) {
  .layout-container {
    flex-direction: column;
  }

  .sidebar-area {
    position: static;
    width: 100%;
    padding: 1rem;
  }

  .main-content {
    margin-left: 0;
    width: 100%;
    padding: 1rem;
  }
}
</style>R