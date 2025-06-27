
/*
* API 메소드 정리
* */

import axiosComm from '@/utils/axios.js'

const get = (url, params = {}) => axiosComm({ method: 'get', url, params })
const post = (url, data = {}) => axiosComm({ method: 'post', url, data });

export const apiMethods = {

    // 감정단어 GET
    emotionsAPI: () => get('emotions'),

    // 카드 답변들 저장하기
    cardSave: (answer) => post('card/save', answer)
}