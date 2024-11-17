<template>
  <header>
    <div class="header-container">
      <img :src="logo" alt="엣코 로고" class="logo-container">

      <nav class="nav-menu">
        <div>Home</div>
        <div>Category</div>
        <div>About</div>
        <div>Contact</div>

      </nav>
      <div class="search-container">
        <input type="text">

      </div>



    </div>

  </header>
</template>

<script setup>
import logo from '@/assets/엣코 로고.gif'
</script>

<style scoped>
header {
  padding: 1rem;
  background-color: rgb(178, 242, 165);
  height: auto;
}

.header-container {
  display: flex;
  justify-content: space-between;
}

.nav-menu {
  display: flex;
  justify-content: space-between;
  align-items: center;
  gap: 4rem;
}



.logo-container {
  max-width: 80px;
  height: auto;
  background-color: black;
}
</style>