import 'bootstrap-icons/font/bootstrap-icons.css'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap.js'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
import 'bootstrap-icons/font/bootstrap-icons.css'
// import "bootstrap-icons/font/bootstrap-icons.css"


const app = createApp(App)
const pinia = createPinia

app.use(createPinia())
app.use(router)

app.use(pinia)
app.mount('#app')
