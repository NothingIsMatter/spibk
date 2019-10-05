import Vue from 'vue'
import VueResource from 'vue-resource'
import App from 'components/app.vue'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import router from 'router/router'

Vue.use(Vuetify)
Vue.use(VueResource)



new Vue({
    el:"#app",
    router,
    render: a => a(App)
})


