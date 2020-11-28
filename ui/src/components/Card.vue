<template xmlns:style="" xmlns:display="">
    <div class="app-card app-widgets">
        <a-card style="display: flex">
            <div>
                <span class="app-block__title-descr">{{ taskType }}</span>
                <h1
                    class="app-block__title"
                    @click="getTask"
                >
                    {{ cardTitle }}
                </h1>
                <a-tag class="app-tag" color="pink">
                    {{ taskStatus }}
                </a-tag>
                <a-tag class="app-tag" color="white" style="color: #EB5757; font-weight: 600;">
                    {{ taskPriority }}
                </a-tag>
            </div>
            <CardTime
                    :tstmpCreate="tstmpCreate"
            />
            <a-modal
                    :title="cardTitle"
                    :visible="visible"
                    @ok="handleOk"
                    @cancel="handleCancel"
                    okText="Комментировать"
                    cancelText="Закрыть"
                    class="app-modal-create app-modal-task"
            >
                <ModalContentTask
                    :taskType="taskType"
                    :taskModalStatus="taskModalStatus"
                    :tstmpModalCreate="tstmpModalCreate"
                    :taskAssignee="taskAssignee"
                    :taskModalPriority="taskModalPriority"
                    :taskAssigneePosition="taskAssigneePosition"
                    :taskDateTo="taskDateTo"
                    :modalTaskText="modalTaskText"
                    :subTaskList="subTaskList"
                    :modalTaskComments="modalTaskComments"
                />
            </a-modal>
        </a-card>
    </div>
</template>

<script>
    import CardTime from './CardTime'
    import ModalContentTask from './ModalContentTask'

    export default {
        name: "Card",
        components: {
            CardTime,
            ModalContentTask
        },
        props: [
            'tagTitle',
            'cardTitle',
            'taskType',
            'tstmpCreate',
            'taskPriority',
            'taskStatus',
            'taskModalStatus',
            'tstmpModalCreate',
            'taskAssignee',
            'taskModalPriority',
            'taskAssigneePosition',
            'taskDateTo',
            'modalTaskText',
            'subTaskList',
            'modalTaskComments'
        ],
        data() {
            return {
                visible: false
            };
        },
        methods: {
            getTask() {
                this.visible = true;
            },
            handleOk(e) {
                setTimeout(() => {
                    this.visible = false;
                    this.confirmLoading = false;
                }, 2000);
            },
            handleCancel(e) {
                this.visible = false;
            },
        }
    }
</script>

<style scoped>

</style>