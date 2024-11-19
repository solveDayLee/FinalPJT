<template>
    <div class="settings">
        <div class="category-section"> 
            <p>게시판</p>
                <select>
                    <option v-for="category in categories" value="category">{{category}}</option>
                </select>
        </div>
        <div class="title-section">
            <p>제목</p>
            <input placeholder="제목을 입력해주셔요">     
        </div>
    </div>
    <div class="write">
        <textarea rows="10" cols="50" placeholder="여기에 글을 입력하셔요..."></textarea>
    </div>

    <hr>
    <div class="attach">
        <p>첨부파일</p>
        <p>{{ `${attachBytes}/10.00MB` }}</p>
        <button>파일 첨부</button>
    </div>
    <hr>
    <form action="submit">
        <button>취소</button>
        <button>완료</button>
    </form>
</template>

<script setup>
    import { ref } from 'vue';
    const categories = [
        "자유이야기방",
        "수구",
        "발레",
        "정보공유방",
        "홍보방"
    ]

    // 파일의 크기를 여기에 나타내줘야 함. 
    const attachBytes = ref(0);
    const bytes = attachBytes + '/10.00 MB';

</script>


<style scoped>
/* .settings{
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
} */
 .settings > *{
    margin: 10px;
 }
.category-section {
    display: flex;
    flex-wrap: wrap;
}
.title-section {
    display: flex;
    flex-wrap: wrap;
}
p{
    width: 80px;
    margin: 0;
}
.attach{
    display: flex;
    align-items: center;
    width: 100%;
    justify-content: space-between;
}
form{
    display: flex;
    justify-content: right;
}
form > *{
    margin-left: 10px;
}
</style>