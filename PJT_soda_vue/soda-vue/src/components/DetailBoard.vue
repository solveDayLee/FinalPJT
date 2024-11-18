<template>
    <div>
        <h2>{{ board.category }}</h2>
    </div>
    <hr>
    <div>
        <div>{{ board.title }}</div>
        <div>{{ board.writer }}</div>
        <div>{{ board.regDate }}</div>
        <div>{{ board.viewCnt }}</div>
    </div>

    <div>
        <div>{{ board.content }}</div>
        <div>{{ board.likes }}</div>
    </div>

    <hr>
    <div>
        <button>목록</button>
    </div>



</template>

<script setup>

</script>

<style scoped></style>