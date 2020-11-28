<template>
    <div>
        <div style="margin-bottom: 10px" v-if="clickNewTask">
            <span
                    @click="clickNewTask = !clickNewTask"
                    class="app-modal-task-back"
            >
                Вернуться к основной задаче
            </span>
        </div>
        <ModalTaskTop
            :taskType="taskType"
        />
        <ModalTaskAddresse />
        <ModalTaskText />
        <ModalTaskPhoto />

        <div class="app-modal-task-buttons">
            <a-button type="primary" class="app-modal-task-buttons__edit">
                Редактировать
            </a-button>
            <a-button class="app-modal-task-buttons__cancel">Отменить задачу</a-button>
        </div>

        <ModalTabs
            :getNewTask="getNewTask"
            v-if="!clickNewTask"
        />
        <ModalNewTaskTab v-if="clickNewTask" />
    </div>
</template>

<script>
    import ModalTaskTop from './ModalTaskTop';
    import ModalTaskAddresse from './ModalTaskAddresse';
    import ModalTaskText from './ModalTaskText';
    import ModalTaskPhoto from './ModalTaskPhoto';
    import ModalTabs from './ModalTabs';
    import ModalNewTaskTab from './ModalNewTaskTab';

    export default {
        name: "ModalContentTask",
        components: {
            ModalTaskTop,
            ModalTaskAddresse,
            ModalTaskText,
            ModalTaskPhoto,
            ModalTabs,
            ModalNewTaskTab,
        },
        props: [ 'taskType' ],
        data() {
            return {
                clickNewTask: false
            }
        },
        methods: {
            getNewTask() {
                this.clickNewTask = true;
            }
        }
    }
</script>

<style scoped>

</style>