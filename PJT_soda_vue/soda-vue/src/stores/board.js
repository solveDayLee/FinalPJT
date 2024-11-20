import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_API_URL = `http://localhost:8080/etco/board`

export const useBoardStore = defineStore('board', ()=>{
    const boardList = ref([])
    const getBoardList = function(){
        axios.get(REST_API_URL)
        .then((response)=>{
            boardList.value = response.data
        })
    }

    const board = ref({})
    const getBoardByNo = function(no){
        axios.get(`${REST_API_URL}/${no}`)
        .then((response) =>{
            board.value = response.data
        })
    }
    const writeBoard = function(board){
        axios({
            url: REST_API_URL,
            method: 'POST',
            data: board
        })
            .then(()=>{
                router.push({name: 'Board'})
            })
            .catch(()=>{
                console.log("보드 등록 실패..")
            })

    }


    return {boardList, getBoardList, getBoardByNo, board, writeBoard}

})