<template>
    

    <div v-if="board" class="board-detail">
        <div>
            <h2>{{ board.category }}</h2>
        </div>

        <hr>
        <div>
            <div>{{ board.title }}</div>
            <div>
                <span>{{ board.writer }}</span>
                <span>{{ formatDate(board.regDate) }}</span>
                <span>{{ board.viewCnt }}</span>

            </div>
        </div>

        <div>
            <div>{{ board.content }}</div>
            <div>
                <button @click="handleLike">❤️{{ board.likes }}</button>
            </div>
        </div>

        <hr>
        <div>
           <button @click="goToList">목록</button>
        </div>
        <div>
            <Comment />
        </div>
    </div>
</template>

<script setup>
import { useRouter } from 'vue-router'
import {ref} from 'vue'
import Comment from './Comment.vue';

const router = useRouter() //페이지 이동 라우터
const isLiked = ref(false)


//목록으로 이동
const goToList = () => {
    router.push('/board')
}

const handleLike = async () => {
    await toggleLike(board.id)
    isLiked.value = !isLiked.value
}

const formatDate = (date) => {
    return new Date(date).toLocaleDateString('ko-KR', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit',
        hour: '2-digit',
        minute: '2-digit'
    })
}

// 임시 데이터
const board = ref({
    id: 1,
    category: '자유게시판',
    title: '첫 번째 게시글입니다',
    writer: '홍길동',
    regDate: '2024-11-19T10:30:00',
    viewCnt: 42,
    content: '안녕하세요! 이것은 게시판의 첫 번째 게시글입니다. 긴 내용의 텍스트가 들어갈 수 있는 본문 영역입니다. 게시글에 대한 자세한 내용을 작성할 수 있습니다.',
    likes: 15
})



// onMounted(() => {
//     loadBoard()
// })

</script>

<style scoped>

</style>