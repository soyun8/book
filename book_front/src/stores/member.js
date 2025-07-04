import {defineStore} from 'pinia'
import {ref} from "vue";
import { apiMethods } from "@/utils/api";


export const memberStore = defineStore('member', () => {

    const isLogin = ref(false)

    // 로그인 버튼 클릭하면 css 변경
    const loginBtn = () => {
        isLogin.value = !isLogin.value
    }

    // 로그인하기 버튼 누르면
    const login = async (loginData) => {
        // id, pw 확인하고 응답받기
        const data = await apiMethods.login(loginData)
        console.log(data)


    }

    return {
        isLogin, loginBtn, login
    }
})