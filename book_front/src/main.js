import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import { loadFonts } from './plugins/webfontloader'
import router from './utils/router';

const pinia = createPinia()

createApp(App)
    .use(vuetify)
    .use(pinia)
    .use(loadFonts)
    .use(router)
    .mount('#app')
