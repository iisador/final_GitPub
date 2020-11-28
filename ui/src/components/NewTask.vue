<template>
    <div class="app-modal-new-task">
        <div>
            <h1
                class="app-block__title"
                @click="getNewTask"
            >
                {{ cardTitle }}
            </h1>
            <a-tag class="app-tag" color="pink">
                {{ newTaskStatus }}
            </a-tag>
        </div>
        <a-card>
            <span>Исполнитель</span>
            <span class="app-modal-task__info-title">{{ newAssignee }}</span>
        </a-card>
        <CardTime
            :tstmpCreate="tstmpCreate"
        />
    </div>
</template>

<script>
    import CardTime from './CardTime'
    export default {
        name: "NewTask",
        props: [
            'cardTitle',
            'getNewTask',
            'subTaskList',
            'newAssignee',
            'tstmpCreate',
            'newTaskStatus'
        ],
        components: {
            CardTime
        }
    }
</script>

<style scoped>

</style>