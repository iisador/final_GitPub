<template>
    <div>
        <a-tabs default-active-key="1">
            <a-tab-pane key="1" tab="Комментарии">
                <ModalTaskComment
                    v-for="comment in modalTaskComments"
                    :modalTaskCommentText="comment.content"
                    :modalTaskCommentAuthor="comment.author.name"
                />
            </a-tab-pane>
            <a-tab-pane key="2" tab="Вложенные задачи" force-render>
                <ModalNewTask
                    :getNewTask="getNewTask"
                    :subTaskList="subTaskList"
                />
            </a-tab-pane>
        </a-tabs>
    </div>
</template>

<script>
    import ModalTaskComment from './ModalTaskComment'
    import ModalNewTask from './ModalNewTask'

    export default {
        name: "ModalTabs",
        props: [
            'getNewTask',
            'subTaskList',
            'modalTaskComments'
        ],
        components: {
            ModalTaskComment,
            ModalNewTask
        }
    }
</script>

<style scoped>

</style>