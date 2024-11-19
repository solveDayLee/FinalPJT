<template>
    <Banner/>
    <div class="body">
        <Sidebar/>
        <div class="writeArea">
            <WriteArea/>
        </div>
    </div>

</template>

<script setup>
    import Banner from '@/components/Layouts/Banner.vue';
    import Sidebar from '@/components/Layouts/Sidebar.vue';
    import WriteArea from '@/components/WriteArea.vue';


</script>

<style scoped>
.body{
    display: flex;
    margin-left: 30px;
    margin-bottom: 30px;

}
.writeArea{
    margin-left: 30px;
}
</style>