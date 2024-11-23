<template>
    <div class="page-layout">
        <div v-if="isReady && boardList.length > 0" class="board-container">
            <div class="list-header">
                <div class="header-left">
                    <h2 class="title">{{boardList[0].category}}</h2>
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
                            @click="$router.push({ name: 'DetailBoard', params: { no: board.boardNo } })"
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
                                <span class="likes-count">{{ board.likesCnt }}</span>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div v-else class="loading-container">
            <div class="empty-container">
            <div class="empty-circle">
            <span class="empty-text">텅</span>
            </div>
            <p class="empty-description">아직 작성된 글이 없습니다</p>
            </div>
        </div>
    </div>
</template>

<script setup>
import { RouterLink, useRoute } from "vue-router";
import { useBoardStore } from "@/stores/board";
import { ref, onBeforeMount, watch, onMounted } from "vue";
import { storeToRefs } from "pinia";

const store = useBoardStore();
const route = useRoute();
const { boardList } = storeToRefs(store); //바로 boardList 를 추출해서 씀! 그래서 store.boardList 라고 안 써도 됨. 
const isReady = ref(false);


const loadBoardData = async () => {
    isReady.value = false;
    try{
        const category = route.params.category
        const detailCategory = route.params.detailCategory

        if(category){
            await store.getBoardListByCategory(category, detailCategory)
            isReady.value = true
        }else{
            await store.getBoardList()
            isReady.value = true
        }

    }catch(error){
        console.error('데이터 로딩 장렬히 실패:', error)
    }
} 


watch(
    () => route.params,
    async () =>{
        await loadBoardData()
    },
    {immediate: true}
)

onBeforeMount(async () => {
    await loadBoardData()
})


// onMounted(() => {
//     if (route.params.category) {
//         console.log("카테고리 메서드 실행한다!")
//         store.getBoardListByCategory(route.params.category, route.query.detailCategory || null);  ///바로 받지 말고 받은 값을 잠시 저장한 다음에 promise 이용하기. 렌더링 전에 화면에서 쓰도록 하기 
//     } else {
//         store.getBoardList();
//     }
// });





</script>

<style scoped>
.page-layout {
    display: flex;
    justify-content: center;
    min-height: calc(100vh - 120px);
    padding: 2rem;
    background-color: #fbf8ef;
    position: relative;
    border-radius: 10px;
}

.board-container {
    flex: 1;
    padding: 2rem;
    max-width: 100%;
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
.empty-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 4rem 2rem;
}

.empty-circle {
  width: 120px;
  height: 120px;
  background: linear-gradient(135deg, #e6f3ff 0%, #ffffff 100%);
  border: 2px solid #e1f0ff;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 1.5rem;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05);
}

.empty-text {
  font-size: 2.5rem;
  color: #4a90e2;
  font-weight: bold;
}

.empty-description {
  color: #78909c;
  font-size: 1rem;
  margin: 0;
}
</style>
