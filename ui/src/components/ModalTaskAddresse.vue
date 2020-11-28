<template>
    <div style="display: flex; justify-content: space-between; margin-top: 5px">
        <a-card>
            <span>Исполнитель</span>
            <span class="app-modal-task__info-title">{{ taskAssignee }}</span>
        </a-card>
        <a-card>
            <span>Важность</span>
            <span class="app-modal-task__info-title">{{ taskModalPriority }}</span>
        </a-card>
        <a-card>
            <span>Вид деятельности</span>
            <span class="app-modal-task__info-title">{{ taskAssigneePosition }}</span>
        </a-card>
        <a-card>
            <span>Срок выполнения</span>
            <span class="app-modal-task__info-title">{{ taskDateTo }}</span>
        </a-card>
        <a-card>
            <span>Реакция</span>
            <span class="app-modal-task__info-title">Нет</span>
        </a-card>
    </div>
</template>

<script>
    export default {
        name: "ModalTaskAddresse",
        props: [
            'taskAssignee',
            'taskModalPriority',
            'taskAssigneePosition',
            'taskDateTo'
        ]
    }
</script>

<style scoped>

</style>