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
                Ожидание
            </a-tag>
        </div>
        <a-card>
            <span>Исполнитель</span>
            <span class="app-modal-task__info-title">Иванов Петр Иванович</span>
        </a-card>
        <CardTime />
    </div>
</template>

<script>
    import CardTime from './CardTime'
    export default {
        name: "NewTask",
        props: [ 'cardTitle', 'getNewTask'],
        components: {
            CardTime
        }
    }
</script>

<style scoped>

</style>