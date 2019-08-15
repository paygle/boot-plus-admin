import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import ElementUI from 'element-ui'
import {getValueByPath} from './utils/util'
import 'element-ui/lib/theme-chalk/index.css'
import { DateLessYearFilter } from './utils/filters'

Vue.filter('dateLessYear', DateLessYearFilter)
Vue.use(ElementUI)
Vue.config.productionTip = false
/* axios 请求封装 */
const instAxios = axios.create({ headers: {'content-type': 'application/json;charset=UTF-8'}})
Vue.prototype.$axios = axios
Vue.prototype.$POST = function(url, data = {}, config = {}) {
  return new Promise((resolve, reject) => {
    instAxios.post(url, JSON.stringify(data), config)
    .then((res) => {
      if (res.status === 200 && res.data.code === 200 && getValueByPath(res, 'data.data')) {
        resolve(res.data.data)
      } else {
        reject(res.data)
      }
    }).catch((e) => {
      console.error("Request error ", url)
      reject(e)
    })
  })
}
Vue.prototype.$GET = function(url, config) { return instAxios.get(url, config) }

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
