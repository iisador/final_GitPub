<template>
    <div class="app-block-cards">
        <Card
            v-for="(task, index) in getTasks"
            :cardTitle="task.header"
            :tstmpCreate="task.tstmpCreate"
            :tstmpModalCreate="task.tstmpCreate"
            :taskType="task.type.code"
            :taskPriority="task.priority.code"
            :taskStatus="task.status.code"
            :taskModalStatus="task.status.code"
            :taskModalPriority="task.priority.code"
            :taskAssignee="task.assignee.name"
            :taskAssigneePosition="task.assignee.position.code"
            :taskDateTo="task.dateTo"
            :modalTaskText="task.info"
            :subTaskList="task.subTaskList"
            :modalTaskComments="task.comments"
            :key="task.id"
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