<template>
    <div>
        <div class="app-modal-content">
            <a-input
                placeholder="Тип задачи"
                class="app-filter__input app-modal-content__input"
                :value="taskArr.type"
                v-model="taskArr.type"
            />
            <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro" @click="getTaskType">
        </div>
        <div class="app-modal-content">
            <a-input
                placeholder="Заголовок"
                class="app-filter__input app-modal-content__input"
                :value="taskArr.header"
                v-model="taskArr.header"
            />
            <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro" @click="getTaskTitle">
        </div>
        <div class="app-modal-content">
            <a-textarea
                placeholder="Описание"
                class="app-filter__input"
                :value="taskArr.info"
                v-model="taskArr.info"
            />
            <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro" @click="getTaskDescr">
        </div>
        <div style="display: flex; flex-direction: row; justify-content: space-between">
            <div class="app-modal-content">
                <a-input
                    placeholder="Исполнитель"
                    class="app-filter__input app-modal-content__input"
                    :value="taskArr.assignee"
                    v-model="taskArr.assignee"
                />
                <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro" @click="getTaskAssignee">
            </div>
            <div class="app-modal-content">
                <a-input
                    placeholder="Срок выполнения"
                    class="app-filter__input app-modal-content__input"
                    :value="taskArr.dateTo"
                    v-model="taskArr.dateTo"
                />
                <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro" @click="getTaskDate">
            </div>
        </div>
        <div style="display: flex; flex-direction: row; justify-content: space-between">
            <div class="app-modal-content">
                <a-input
                    placeholder="Важность"
                    class="app-filter__input app-modal-content__input"
                    :value="taskArr.priority"
                    v-model="taskArr.priority"
                />
                <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro" @click="getTaskPriority">
            </div>
            <div class="app-modal-content">
                <a-input
                    placeholder="Вид деятельности"
                    class="app-filter__input app-modal-content__input"
                    :value="taskArr.taskPosition"
                    v-model="taskArr.taskPosition"
                />
                <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro" @click="getTaskPosition">
            </div>
        </div>
        <div class="app-modal-content">
            <a-input placeholder="Вложить файл" class="app-filter__input app-modal-content__input"></a-input>
        </div>
    </div>
</template>

<script>
    // Создаем распознаватель
    const recognizer = new webkitSpeechRecognition();
    recognizer.interimResults = true;
    recognizer.lang = 'ru-Ru';

    export default {
        name: "ModalContent",
        props: [ 'getTaskArr' ],
        mounted() {
            this.$store.dispatch('TASK_ARR', this.taskArr)
        },
        data() {
            return {
                taskArr: {
                    type: null,
                    header: null,
                    info: null,
                    assignee: null,
                    dateTo: null,
                    dateFact: null,
                    priority: null,
                    taskPosition: null,
                    author: null
                }
            }
        },
        methods: {
            getTaskType() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.taskArr.type = result[0].transcript;
                    }
                };
                recognizer.start();
            },
            getTaskTitle() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.taskArr.header = result[0].transcript;
                        this.$store.dispatch('TASK_ARR', this.taskArr)
                    }
                };
                recognizer.start();
            },
            getTaskDescr() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.taskArr.info = result[0].transcript;
                    }
                };
                recognizer.start();
            },
            getTaskAssignee() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.taskArr.assignee = result[0].transcript;
                    }
                };
                recognizer.start();
            },
            getTaskDate() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.taskArr.dateTo = result[0].transcript;
                    }
                };
                recognizer.start();
            },
            getTaskPriority() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.taskArr.priority = result[0].transcript;
                    }
                };
                recognizer.start();
            },
            getTaskPosition() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.taskArr.taskPosition = result[0].transcript;
                        this.getTask({
                            data: this.taskArr
                        })
                    }
                };
                recognizer.start();
            },
        },
    }
</script>

<style scoped>

</style>