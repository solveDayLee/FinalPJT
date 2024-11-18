<template>
    <div>
    <div class="listHeader">
        <h2>전체 글</h2>
        <button>글쓰기</button>
    </div>
    <table class="table table-hover text-center">
        <thead>
            <tr>
                <th>번호</th>
                <th>게시판명</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>등록일</th>
                <th>조회수</th>
                <th>좋아요</th>
            </tr>
        </thead>
        <tbody>
            <!--임시 라우터 링크 줌-->
            <tr v-for="board in boardList" :key="board.boardNo" 
            @click="$router.push({name:'Main'})"
            class="cursor-pointer">
                <td>{{ board.boardNo }}</td>
                <td>{{ board.category }}</td>
                <td>{{ board.title }}</td>
                <td>{{ board.userId }}</td>
                <td>{{ board.regDate }}</td>
                <td>{{ board.viewCnt }}</td>
                <td>{{ board.likes }}</td>
            </tr>
        </tbody>
    </table>
</div>
</template>

<script setup>

import { RouterLink } from 'vue-router';

//임시 자료
    const boardList=[
    {
        boardNo: 3, category: "발레", title: "제목", userId: "콩순이", regDate: "2024.09.39", viewCnt: 3, likes:4
    },
    {
        boardNo: 3, category: "발레", title: "제목", userId: "콩순이", regDate: "2024.09.39", viewCnt: 3, likes:4
    },
    {
        boardNo: 3, category: "발레", title: "제목", userId: "콩순이", regDate: "2024.09.39", viewCnt: 3, likes:4
    },
    {
        boardNo: 3, category: "발레", title: "제목", userId: "콩순이", regDate: "2024.09.39", viewCnt: 3, likes:4
    },
    ]
</script>

<style scoped>
.listHeader{
    display: flex;
    justify-content: space-between;
}
table{
    /* width: 100%; */
}
</style>