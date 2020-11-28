import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        users: '',
        tasks: '',
        taskTypes: '',
        voice: ''
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
                    commit('GET_TASKS_TYPE',response)
                })
        },
    },

    getters: {
        // GET_USERS(state) {
        //     return state.geoZones;
        // },
    }
})