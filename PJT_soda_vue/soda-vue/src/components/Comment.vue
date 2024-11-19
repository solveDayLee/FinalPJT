<template>
    <div>
       <div>
        <input type="text" placeholder="댓글을 입력하세요" v-model="comment">

        <button @click="submitComment">등록</button>
       </div>

    </div>
</template>

<script setup>
import {ref} from 'vue'

const comment = ref('')

const submitComment = () => {
    if(!comment.value.trim) {
        alert('댓글을 입력해주세요.')
        return 
    }
    alert('댓글이 등록되었습니다.')
    comment.value = ''
}


</script>

<style scoped>

</style>