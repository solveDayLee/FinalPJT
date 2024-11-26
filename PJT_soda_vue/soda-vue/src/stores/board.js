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

import { ref, watch } from "vue" 
import { defineStore } from "pinia" 
import axios from "axios" 
import router from "@/router"

// const REST_API_URL = `http://192.168.210.73:8080/etco/board`
const REST_API_URL = `http://localhost:8080/etco/board`

export const useBoardStore = defineStore('board', () => {
    const selectedCategory = ref('WATERPOLO')
    const boardList = ref([])
    const board = ref({})
    const isLoading = ref(false)


    const getBoardList = async function() {
        try {
            isLoading.value = true
            const response = await axios.get(REST_API_URL)
            console.log('서버 응답:', response.data)  // 응답 데이터 확인용 로그
            boardList.value = response.data
        } catch (error) {
            console.error("상세 에러 정보:", error.response?.data)
            boardList.value = []  // 에러 시 빈 배열 설정
        } finally {
            isLoading.value = false
        }
    }

    const getBoardByNo = async function(no) {
        try {
            isLoading.value = true
            // 토큰을 헤더에 추가
            const token = localStorage.getItem('access-token')
            const response = await axios.get(`${REST_API_URL}/${no}`, {
                headers: {
                    Authorization: token
                }
            })
            console.log('게시글 상세 데이터:', response.data)
          
            // 서버에서 받은 게시글 데이터를 저장
            board.value = response.data

            // 디버깅을 위한 로그 추가
        console.log('게시글 작성자 번호:', board.value.userNo)
        console.log('현재 로그인한 사용자 번호:', localStorage.getItem('userId'))

            return response.data

        } catch (error) {
            alert("게시글을 보기 위해 로그인해 주세요.")
            console.error("게시글 상세 조회 실패:", error)
            throw error  // 에러를 상위로 전파
        } finally {
            isLoading.value = false
        }
    }

    const createBoard = async function(boardData) {
        try {
            isLoading.value = true

            //localStorage에서 현재 로그인한 사용자의 Id와 user_no를 가져온다.
            const userId = localStorage.getItem('userId')
            const userNo = localStorage.getItem('userNo')

            if(!userId || !userNo) {
                alert('로그인이 필요한 서비스입니다.')
                throw new Error('로그인이 필요합니다.')
            }

            const boardWithUser = {
                ...boardData,
                userNo: parseInt(userNo), // 숫자로 변환하여 저장
                writer: userId  // 작성자 정보도 추가
            }


            await axios.post(REST_API_URL, boardWithUser)
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
            console.log('요청 URL:', `${REST_API_URL}/category/${category}`)
            console.log('카테고리:', category)
            console.log('상세카테고리:', detailCategory)
             // 현재 URL 구조: http://localhost:8080/etco/board/category/카테고리명?detailCategory=상세카테고리
            const response = await axios.get(`${REST_API_URL}/category/${category}`, {
                params: { detailCategory }
            })
            boardList.value = response.data || [] //데이터가 없을 경우를 대비해 빈 배열 할당
        } catch (error) {
            console.error("상세 에러 정보:", error.response?.data)
            // console.error("카테고리별 게시글 조회 실패:", error)
            boardList.value = [] //에러 발생 시 빈 배열로 초기화
        } finally {
            isLoading.value = false
        }
    }

    const setSelectedCategory = function(category) {
        selectedCategory.value = category
    }

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