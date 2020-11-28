<template>
    <div>
        <a-tabs default-active-key="1">
            <a-tab-pane key="1" tab="Комментарии">
                <ModalNewTaskComment />
            </a-tab-pane>
        </a-tabs>
    </div>
</template>

<script>
    import ModalNewTaskComment from './ModalNewTaskComment'
    export default {
        name: "ModalNewTaskTab",
        components: {
            ModalNewTaskComment
        }
    }
</script>

<style scoped>

</style>