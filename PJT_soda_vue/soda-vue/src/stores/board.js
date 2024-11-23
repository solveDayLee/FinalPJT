// import { ref, computed } from 'vue'
// import { defineStore } from 'pinia'
// import axios from 'axios'
// import router from '@/router'

// const REST_API_URL = `http://localhost:8080/etco/board`

// export const useBoardStore = defineStore('board', ()=>{

//     const selectedCategory = ref('WATERPOLO')
//     const boardList = ref([])
//     const getBoardList = function(){
//         axios.get(REST_API_URL)
//         .then((response)=>{
//             boardList.value = response.data
//         })
//     }

//     const board = ref({})
//     const getBoardByNo = function(no){
//         axios.get(`${REST_API_URL}/${no}`)
//         .then((response) =>{
//             board.value = response.data
//         })
//     }
//     const createBoard = function(board){
//         axios({
//             url: REST_API_URL,
//             method: 'POST',
//             data: board
//         })
//             .then(()=>{
//                 router.push({name: 'Board'})
//             })
//             .catch(()=>{
//                 console.log("보드 등록 실패..")
//             })

//     }

    
//     //수정
//     const updateBoard = function() {
//         axios.put(REST_API_URL, board.value)
//         .then(()=> {
//             router.push({name:'UpdateBoard'})
//         })
//     }

//     const getBoardListByCategory = function(category, detailCategory = null){
//         console.log(detailCategory);
//         axios.get(`${REST_API_URL}/category/${category}`, {
//             params: { detailCategory: detailCategory }
//         })
//         .then((response) =>{
//             boardList.value = response.data
//         })
//         .catch(()=>{
//             console.log("카테고리별로 보드 가져오기 실패...")
//         })
//     }
//     const setSelectedCategory = function(category) {
//         selectedCategory.value = category
//     }


//     return {boardList, getBoardList, getBoardByNo, board, createBoard, getBoardListByCategory, updateBoard, setSelectedCategory}


// })

import { ref, watch } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_API_URL = `http://localhost:8080/etco/board`
//const REST_API_URL = `http://192.168.210.73:8080/etco/board`

export const useBoardStore = defineStore('board', () => {
    const selectedCategory = ref('WATERPOLO')
    const boardList = ref([])
    const board = ref({})
    const isLoading = ref(false)

    // 라우트 파라미터 변경 감지를 위한 watcher 설정
    watch(() => router.currentRoute.value.params, (newParams) => {
        if (newParams.category) {
            setSelectedCategory(newParams.category)
            if (newParams.detailCategory) {
                getBoardListByCategory(newParams.category, newParams.detailCategory)
            } else {
                getBoardListByCategory(newParams.category)
            }
        }
    }, { immediate: true })

    const getBoardList = async function() {
        try {
            isLoading.value = true
            const response = await axios.get(REST_API_URL)
            boardList.value = response.data
        } catch (error) {
            console.error("게시글 목록 조회 실패:", error)
        } finally {
            isLoading.value = false
        }
    }

    const getBoardByNo = async function(no) {
        try {
            isLoading.value = true
            const response = await axios.get(`${REST_API_URL}/${no}`)
            board.value = response.data
        } catch (error) {
            console.error("게시글 상세 조회 실패:", error)
        } finally {
            isLoading.value = false
        }
    }

    const createBoard = async function(boardData) {
        try {
            isLoading.value = true
            await axios.post(REST_API_URL, boardData)
            await router.push({ name: 'Board' })
        } catch (error) {
            console.error("게시글 등록 실패:", error)
            throw error
        } finally {
            isLoading.value = false
        }
    }

    const updateBoard = async function() {
        try {
            isLoading.value = true
            await axios.put(REST_API_URL, board.value)
            await router.push({ name: 'UpdateBoard' })
        } catch (error) {
            console.error("게시글 수정 실패:", error)
            throw error
        } finally {
            isLoading.value = false
        }
    }

    const getBoardListByCategory = async function(category, detailCategory = null) {
        try {
            isLoading.value = true
            const response = await axios.get(`${REST_API_URL}/category/${category}`, {
                params: { detailCategory }
            })
            boardList.value = response.data
        } catch (error) {
            console.error("카테고리별 게시글 조회 실패:", error)
        } finally {
            isLoading.value = false
        }
    }

    const setSelectedCategory = function(category) {
        selectedCategory.value = category
    }

    return {
        boardList,
        board,
        isLoading,
        selectedCategory,
        getBoardList,
        getBoardByNo,
        createBoard,
        updateBoard,
        getBoardListByCategory,
        setSelectedCategory
    }
})