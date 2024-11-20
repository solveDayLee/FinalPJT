import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

const REST_API_URL = `http://localhost:9907/etco/board`

export const useBoardStore = defineStore('board', ()=>{
    const boardList = ref([])
    const getBoardList = function(){
        axios.get(REST_API_URL)
        .then((response)=>{
            boardList.value = response.data
        })
    }

    return {boardList, getBoardList}

})