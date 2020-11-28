<template>
    <div class="app-modal-task__top">
        <a-tag class="app-tag" color="pink">
            Ожидание
        </a-tag>
        <span class="app-modal-task__time">10:43 27 Ноя 2020</span>
        <span class="app-block__title-descr">{{ taskType }}</span>
    </div>
</template>

<script>
    export default {
        name: "ModalTaskTop",
        props: [ 'taskType' ],
    }
</script>

<style scoped>

</style>