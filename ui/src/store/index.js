import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        users: '',
        tasks: '',
        taskTypes: '',
        voice: '',
        taskArr: ''
    },

    mutations: {
        GET_USERS(state, payload) {
            state.users = payload.data;
        },

        GET_TASKS(state, payload) {
            state.tasks = payload.data.content;
        },

        GET_TASKS_TYPE(state, payload) {
            state.taskTypes = payload.data.content;
        },

        TASK_ARR(state, payload) {
            state.taskArr = payload;
        }
    },

    actions: {
        GET_USERS: async ({commit}) => {
            await axios
                .get('http://localhost:9000/api/users')
                .then(response => {
                    commit('GET_USERS',response)
                })
        },

        GET_TASKS: async ({commit}) => {
            await axios
                .get('http://localhost:9000/api/tasks')
                .then(response => {
                    commit('GET_TASKS',response)
                })
        },

        GET_TASKS_TYPE: async ({commit}) => {
            await axios
                .get('http://localhost:9000/api/task/types')
                .then(response => {
                    commit('GET_TASKS_TYPE', response)
                })
        },

        TASK_ARR: function(store, payload) {
            store.commit('TASK_ARR', payload)
        },

        NEW_TASK: async ({commit}, payload) => {
            console.log(payload)
            await axios
                .post('http://localhost:9000/api/tasks', payload)
        }
    },

    getters: {

    }
})