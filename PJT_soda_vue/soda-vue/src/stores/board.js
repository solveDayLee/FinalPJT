import { defineStore } from "pinia";
import axios from "axios";
import router from '@/router'
import {ref} from 'vue'

const REST_API_URL = `http://localhost:8080/etco/board`

export const useBoardStore= defineStore('board', () => {
    const boardList = ref([])

    const getBoardList = function() {
        axios.get(REST_API_URL)
        .then((response) => {
            boardList.value = response.data
        })
    }

    const board = ref({})
    const getBoard = function(no) {
        axios.get(`${REST_API_URL}/${no}`)
        .then((response)=> {
            board.value=response.data

        })
    }


    return { boardList, getBoardList, getBoard, board }
})