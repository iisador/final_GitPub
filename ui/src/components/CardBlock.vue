<template>
    <div class="app-block-cards">
        <Card
            v-for="(task, index) in getTasks"
            :cardTitle="task.header"
            :tstmpCreate="task.tstmpCreate"
            :taskPriority="task.priority.code"
            :taskStatus="task.status.code"
        />
    </div>
</template>

<script>
    import Card from './Card'
    import { mapState } from "vuex";

    export default {
        name: "CardBlock",
        components: {
            Card
        },
        mounted() {
            this.$store.dispatch('GET_TASKS');
            this.$store.dispatch('GET_TASKS_TYPE');
            console.log(this.getTasks)
        },
        computed: {
            ...mapState(['tasks', 'taskTypes']),
            getTasks() {
                return this.tasks;
            },
            getTasksType() {
                return this.taskTypes;
            },
        },
    }
</script>

<style scoped>

</style>