import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from 'components/login.vue'
import App from 'components/app.vue'


Vue.use(VueRouter);
const routes = [
    { path:"/golog",component:App},
    {path:"/",component:Login},

]

export default new VueRouter({
    routes
})