<template>
    <div class="page-layout">
        <div class="board-container">
            <div class="list-header">
                <div class="header-left">
                    <h2 class="title">전체 글</h2>
                    <span class="post-count">총 {{ boardList.length }}개의 글</span>
                </div>
                <RouterLink :to="{ name: 'Write' }">
                    <button class="write-button">
                        <span class="icon">✏️</span>
                        글쓰기
                    </button>
                </RouterLink>
            </div>
            <div class="table-container">
                <table class="board-table">
                    <thead>
                        <tr>
                            <th width="8%">번호</th>
                            <th width="12%">게시판명</th>
                            <th width="40%">제목</th>
                            <th width="12%">글쓴이</th>
                            <th width="12%">등록일</th>
                            <th width="8%">조회수</th>
                            <th width="8%">좋아요</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr
                            v-for="board in boardList"
                            :key="board.boardNo"
                            @click="$router.push({ name: 'DetailBoard', params: { id: board.boardNo } })"
                            class="table-row"
                        >
                            <td class="board-no">{{ board.boardNo }}</td>
                            <td>
                                <span class="category-tag">{{ board.category }}</span>
                            </td>
                            <td class="title-cell">
                                <span class="post-title">{{ board.title }}</span>
                            </td>
                            <td class="user-cell">
                                <span class="user-id">{{ board.userId }}</span>
                            </td>
                            <td class="date-cell">{{ board.regDate }}</td>
                            <td class="count-cell">
                                <span class="view-count">{{ board.viewCnt }}</span>
                            </td>
                            <td class="likes-cell">
                                <span class="likes-count">{{ board.likes }}</span>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script setup>
import { RouterLink } from "vue-router";

const boardList = [
    {
        boardNo: 1,
        category: "발레",
        title: "첫 번째 게시글",
        userId: "콩순이",
        regDate: "2024.11.01",
        viewCnt: 12,
        likes: 3,
    },
    {
        boardNo: 2,
        category: "음악",
        title: "두 번째 게시글",
        userId: "보리",
        regDate: "2024.11.02",
        viewCnt: 30,
        likes: 10,
    },
    {
        boardNo: 3,
        category: "여행",
        title: "세 번째 게시글",
        userId: "빵이",
        regDate: "2024.11.03",
        viewCnt: 45,
        likes: 8,
    },
];
</script>

<style scoped>
.page-layout {
    display: flex;
    justify-content: center;
    min-height: calc(100vh - 120px);
    padding: 0 2rem;
    background-color: #fbf8ef;
    position: relative;
}

.board-container {
    flex: 1;
    padding: 2rem;
    max-width: 1200px;
    background-color: white;
    border-radius: 16px;
    box-shadow: 0 4px 16px rgba(0, 0, 0, 0.08);
}

.list-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 0 1.5rem 0;
    margin-bottom: 1.5rem;
    border-bottom: 2px solid #e5eef9;
}

.header-left {
    display: flex;
    align-items: baseline;
    gap: 1rem;
}

.title {
    font-size: 1.75rem;
    font-weight: 700;
    color: #2e64a0;
    margin: 0;
}

.post-count {
    color: #4a7aab;
    font-size: 0.95rem;
}

.write-button {
    background-color: #cee3f6;
    color: #2e64a0;
    border: none;
    padding: 0.75rem 1.5rem;
    border-radius: 8px;
    font-weight: 600;
    cursor: pointer;
    display: flex;
    align-items: center;
    gap: 0.5rem;
    transition: all 0.2s ease;
}

.write-button:hover {
    background-color: #b4d3f1;
    transform: translateY(-1px);
    box-shadow: 0 2px 8px rgba(46, 100, 160, 0.2);
}

.table-container {
    overflow-x: auto;
    border-radius: 12px;
    background-color: #ffffff;
}

.board-table {
    width: 100%;
    border-collapse: separate;
    border-spacing: 0;
    white-space: nowrap;
}

.board-table th {
    background-color: #cee3f6;
    padding: 1.2rem 1rem;
    font-weight: 600;
    color: #2e64a0;
    text-align: center;
}

.table-row {
    cursor: pointer;
    transition: all 0.2s ease;
}

.table-row:hover {
    background-color: #f7f9fc;
    transform: translateX(4px);
}

.table-row td {
    padding: 1.2rem 1rem;
    border-bottom: 1px solid #e5eef9;
    text-align: center;
    color: #4a7aab;
}

.board-no {
    font-weight: 600;
}

.title-cell {
    text-align: left;
    white-space: normal;
    min-width: 200px;
}

.category-tag {
    background-color: #cee3f6;
    color: #2e64a0;
    padding: 0.4rem 1rem;
    border-radius: 20px;
    font-size: 0.875rem;
    font-weight: 500;
    display: inline-block;
    transition: all 0.2s ease;
}

.table-row:hover .category-tag {
    background-color: #b4d3f1;
}
</style>
