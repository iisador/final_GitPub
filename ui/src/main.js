import Vue from 'vue'
import App from './App.vue'
import store from './store'
import './assets/scss/main.scss'
import 'ant-design-vue/dist/antd.css';

import { Card, Tag, Input, Button, Modal, Icon, Tabs } from 'ant-design-vue';
Vue.use(Card);
Vue.use(Tag);
Vue.use(Input);
Vue.use(Button);
Vue.use(Modal);
Vue.use(Icon);
Vue.use(Tabs);

window._ = require('lodash');
window.axios = require('axios')

Vue.config.productionTip = false;

let recognition = new window.webkitSpeechRecognition;

new Vue({
  store,
  render: h => h(App)
}).$mount('#app')
