import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from 'components/login.vue'
import WelcomePage from 'components/welcomepage.vue'


Vue.use(VueRouter);

const routes = [
    { path: "/", component: WelcomePage},
    { path: "*", component: WelcomePage},
    { path:"/auth",component:Login},

]

export default new VueRouter({
    mode: 'history',
    routes
})