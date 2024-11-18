     <template>
<<<<<<< HEAD
        <table>
            <thead>
                <tr>
                    <th><a>전체글</a></th>
                </tr>
                <hr>
                <tr>
                    <th>커뮤니티</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="category in categories">
                    <th>{{ category }}</th>
                </tr>
            </tbody>
            <hr>
            <thead>
                <tr>
                    <th>에디터 게시판</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="editorCategory in editorCategories">
                    <th>{{ editorCategory }}</th>
                </tr>
            </tbody>

        </table>
    </template>

<script setup>
const categories = [
    "Best 인기글(실시간)",
    "Best 인기글(명예의 전당)",
    "수구 talk",
    "발레 talk"
]
const editorCategories = [
    "에디터 Best",
    "에디터 뉴스",
    "에디터 talk",
    "에디터 talk"
]

</script>

<style scoped>
thead {
    font-size: larger;
    font-weight: bold;
}

table {
    text-align: left;
}

table:select {
    color: blue;
}

th {
    margin: 100px;
}
</style> 