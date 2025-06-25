
/*
* API 메소드 정리
* */

import axiosComm from '@/utils/axios.js'

const get = (url, params = {}) => axiosComm({ method: 'get', url, params })

export const apiMethods = {
    // 감정단어 GET
    emotionsAPI: () => get('emotions'),
}