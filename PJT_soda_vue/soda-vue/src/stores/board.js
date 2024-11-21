import { defineStore } from "pinia";
import axios from "axios";
import router from '@/router'
import {ref} from 'vue'

const REST_API_URL = `http://localhost:8080/etco/board`

export const useBoardStore= defineStore('board', () => {
    const boardList = ref([])

    //전체조회
    const getBoardList = function() {
        axios.get(REST_API_URL)
        .then((response) => {
            boardList.value = response.data
        })
    }

    //상세조회
    const board = ref({})
    const getBoard = function(no) {
        axios.get(`${REST_API_URL}/${no}`)
        .then((response)=> {
            board.value=response.data

        })
    }

    //등록
    const createBoard = function(board) {
        axios({
            url: REST_API_URL,
            method: 'POST',
            data:board
        })
        .then(() => {
            console.log("등록성공")
            router.push({name: 'Board'})
        })
        .catch(()=> {
            console.log("등록실패")
        });

    }

    //수정
    const updateBoard = function() {
        axios.put(REST_API_URL, board.value)
        .then(()=> {
            router.push({name:'UpdateBoard'})
        })
    }


    // 삭제


    return { boardList, getBoardList, getBoard, board, createBoard }
})