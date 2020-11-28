<template>
    <div class="app-modal-task__top">
        <a-tag class="app-tag" color="pink">
            {{ taskModalStatus }}
        </a-tag>
        <span class="app-modal-task__time">{{ tstmpModalCreate }}</span>
        <span class="app-block__title-descr">{{ taskType }}</span>
    </div>
</template>

<script>
    export default {
        name: "ModalTaskTop",
        props: [ 'taskType', 'taskModalStatus', 'tstmpModalCreate' ],
    }
</script>

<style scoped>

</style>