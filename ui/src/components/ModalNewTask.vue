<template>
    <div class="app-modal-new">
        <a-button
            type="primary"
            icon="plus"
            class="app-filter__button"
            size="small"
            @click="showModal"
            style="margin-bottom: 5px"
        >
            Создать вложенную задачу
        </a-button>
        <a-modal
            title="Создание задачи"
            :visible="visible"
            @ok="handleOk"
            @cancel="handleCancel"
            okText="Создать"
            cancelText="Отменить"
            class="app-modal-create"
        >
            <ModalContent />
        </a-modal>
        <NewTask
            v-for="task in this.subTaskList"
            :cardTitle="task.header"
            :newAssignee="task.assignee.name"
            :tstmpCreate="task.tstmpCreate"
            :newTaskStatus="task.status.code"
            :key="task.id"
            :getNewTask="getNewTask"
            :subTaskList="subTaskList"
        />
    </div>
</template>

<script>
    import ModalContent from "./ModalContent";
    import NewTask from "./NewTask";

    export default {
        name: "ModalNewTask",
        props: [
            'getNewTask',
            'subTaskList'
        ],
        components: {
            ModalContent,
            NewTask
        },
        data() {
            return {
                visible: false,
            };
        },
        methods: {
            showModal() {
                this.visible = true;
            },
            handleOk(e) {
                this.ModalText = 'The modal will be closed after two seconds';
                this.confirmLoading = true;
                setTimeout(() => {
                    this.visible = false;
                    this.confirmLoading = false;
                }, 2000);
            },
            handleCancel(e) {
                console.log('Clicked cancel button');
                this.visible = false;
            },
        }
    }
</script>

<style scoped>

</style>