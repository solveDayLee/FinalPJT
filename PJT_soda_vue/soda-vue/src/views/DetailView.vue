<template>
    <Banner />
    <div>
        <div class="flex">
            <Sidebar />
            <DetailBoard />
        </div>

    </div>

</template>

<script setup>
import DetailBoard from '@/components/DetailBoard.vue';
import Sidebar from '@/components/Layouts/Sidebar.vue';
import Banner from '@/components/Layouts/Banner.vue';

</script>

<style scoped>
.flex {
    display: flex;
}
</style>