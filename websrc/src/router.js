import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/login',
      name: 'login',
      component: () => import(/* webpackChunkName: "task" */ './views/Login.vue')
    },
    {
      path: '/task',
      name: 'task',
      component: () => import(/* webpackChunkName: "task" */ './views/Task.vue')
    },
    {
      path: '/yidao',
      name: 'yidao',
      component: () => import(/* webpackChunkName: "yidao" */ './views/YiDao.vue')
    },
    {
      path: '/about',
      name: 'about',
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    }
  ]
})
