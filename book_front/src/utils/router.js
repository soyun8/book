import { createMemoryHistory, createRouter } from 'vue-router'
import MainBoard from '../components/common/MainBoard.vue';

//우리가 사용할 route 생성 및 설정
const routes = [
    {
        path: '/',
        name: 'MainBoard',
        component: MainBoard,
    },
];

const router = createRouter({
    history: createMemoryHistory(),
    routes,
})

//설정한 VueRouter 내보낸다.
export default router;