<template>
    <div>
        <div class="app-modal-content">
            <a-input
                placeholder="Тип задачи"
                class="app-filter__input app-modal-content__input"
                :value="taskType"
            />
            <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro" @click="getTaskType">
        </div>
        <div class="app-modal-content">
            <a-input
                placeholder="Заголовок"
                class="app-filter__input app-modal-content__input"
                :value="taskTitle"
            />
            <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro" @click="getTaskTitle">
        </div>
        <div class="app-modal-content">
            <a-textarea
                placeholder="Описание"
                class="app-filter__input"
                :value="taskDescr"
            />
            <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro" @click="getTaskDescr">
        </div>
        <div style="display: flex; flex-direction: row; justify-content: space-between">
            <div class="app-modal-content">
                <a-input
                    placeholder="Исполнитель"
                    class="app-filter__input app-modal-content__input"
                    :value="taskAssignee"
                />
                <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro" @click="getTaskAssignee">
            </div>
            <div class="app-modal-content">
                <a-input
                    placeholder="Срок выполнения"
                    class="app-filter__input app-modal-content__input"
                    :value="taskDate"
                />
                <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro" @click="getTaskDate">
            </div>
        </div>
        <div style="display: flex; flex-direction: row; justify-content: space-between">
            <div class="app-modal-content">
                <a-input
                    placeholder="Важность"
                    class="app-filter__input app-modal-content__input"
                    :value="taskPriority"
                />
                <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro" @click="getTaskPriority">
            </div>
            <div class="app-modal-content">
                <a-input
                    placeholder="Вид деятельности"
                    class="app-filter__input app-modal-content__input"
                    :value="taskPosition"
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
        data() {
            return {
                taskType: '',
                taskTitle: '',
                taskDescr: '',
                taskAssignee: '',
                taskDate: '',
                taskPriority: '',
                taskPosition: ''
            }
        },
        methods: {
            getTaskType() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.taskType = result[0].transcript;
                    }
                };
                recognizer.start();
            },
            getTaskTitle() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.taskTitle = result[0].transcript;
                    }
                };
                recognizer.start();
            },
            getTaskDescr() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.taskDescr = result[0].transcript;
                    }
                };
                recognizer.start();
            },
            getTaskAssignee() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.taskAssignee = result[0].transcript;
                    }
                };
                recognizer.start();
            },
            getTaskDate() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.taskDate = result[0].transcript;
                    }
                };
                recognizer.start();
            },
            getTaskPriority() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.taskPriority = result[0].transcript;
                    }
                };
                recognizer.start();
            },
            getTaskPosition() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.taskPosition = result[0].transcript;
                    }
                };
                recognizer.start();
            }
        }
    }
</script>

<style scoped>

</style>