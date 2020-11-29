<template>
    <div>
        <div class="app-modal-content">
            <a-select
                placeholder="Тип задачи"
                class="app-filter__input app-modal-content__input"
                v-model="type"
                style="width: 100%"
            >
                <a-select-option v-for="(item, i) in types" :key="item.id" :value="item.code || type" @click="getTypes(item.id)">
                    {{ item.code }}
                </a-select-option>
            </a-select>
            <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro app-modal-content__micro-select" @click="getTaskType">
        </div>
        <div class="app-modal-content">
            <a-input
                placeholder="Заголовок"
                class="app-filter__input app-modal-content__input"
                :value="header"
                v-model="header"
                @change="getTitle(header)"
            />
            <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro" @click="getTaskTitle">
        </div>
        <div class="app-modal-content">
            <a-textarea
                placeholder="Описание"
                class="app-filter__input"
                :value="info"
                v-model="info"
                @onchange="getDescr(info)"
            />
            <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro" @click="getTaskDescr">
        </div>
        <div style="display: flex; flex-direction: row; justify-content: space-between">
            <div class="app-modal-content" style="width: 200px">
                <a-select
                    placeholder="Исполнитель"
                    class="app-filter__input app-modal-content__input"
                    :value="assignee"
                    v-model="assignee"
                    style="width: 100%"
                >
                    <a-select-option v-for="(item, i) in assignees" :key="item.id" :value="item.name || assignee" @click="getAssignees(item.id)">
                        {{ item.name }}
                    </a-select-option>
                </a-select>
                <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro app-modal-content__micro-select" @click="getTaskAssignee">
            </div>
            <div class="app-modal-content" style="width: 200px">
                <a-select
                        placeholder="Важность"
                        class="app-filter__input app-modal-content__input"
                        :value="priority"
                        v-model="priority"
                        style="width: 100%"
                >
                    <a-select-option v-for="(item, i) in priorities" :key="item.id" :value="item.code || priority" @click="getAssignees(item.id)">
                        {{ item.code }}
                    </a-select-option>
                </a-select>
                <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro app-modal-content__micro-select" @click="getTaskPriority">
            </div>
        </div>
        <div style="display: flex; flex-direction: row; justify-content: space-between">
            <div class="app-modal-content" style="width: 100%">
                <a-select
                        placeholder="Вид деятельности"
                        class="app-filter__input app-modal-content__input"
                        :value="position"
                        v-model="position"
                        style="width: 100%"
                >
                    <a-select-option v-for="(item, i) in positions" :key="item.id" :value="item.code || position" @click="getPositions(item.id)">
                        {{ item.code }}
                    </a-select-option>
                </a-select>
                <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro app-modal-content__micro-select" @click="getTaskPosition">
            </div>
            <div class="app-modal-content" style="display: none">
                <a-input
                        format="YYYY-MM-DD HH:mm"
                        placeholder="Срок выполнения"
                        class="app-filter__input app-modal-content__input"
                        :value="dateTo"
                        v-model="dateTo"
                        @change="getData(dateTo)"
                />
                <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro" @click="getTaskDate">
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
        created() {
            this.taskTypes.map(type => {
                this.types.push(type);
            });

            this.taskUsers.map(assignee => {
                this.assignees.push(assignee);
            });

            this.taskPriorities.map(priority => {
                this.priorities.push(priority);
            });

            this.taskPositions.map(position => {
                this.positions.push(position);
            })
        },
        data() {
            return {
                taskArr: {
                    author: null,
                    dateFact: null,
                    dateTo: null,
                    parent: null
                },
                type: null,
                header: null,
                info: null,
                assignee: null,
                dateTo: null,
                dateFact: null,
                priority: null,
                position: null,
                author: null,
                taskTypes: this.$store.state.taskTypes,
                taskUsers: this.$store.state.users,
                taskPriorities: this.$store.state.taskPriority,
                taskPositions: this.$store.state.positions,
                priorities: [],
                positions: [],
                types: [],
                assignees: []
            }
        },
        methods: {
            getTypes(item) {
                this.taskArr.type = item;
            },
            getTitle(item) {
                this.taskArr.header = item;
            },
            getDescr(item) {
                this.taskArr.info = item;
            },
            getAssignees(item) {
                this.taskArr.assignee = item;
            },
            getData(item) {
                this.taskArr.dateTo = item;
            },
            getPositions(item) {
                this.taskArr.position = item;
            },
            getTaskType() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.type = result[0].transcript;
                    }
                };
                recognizer.start();
            },
            getTaskTitle() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.header = result[0].transcript;
                        this.$store.dispatch('TASK_ARR', this.taskArr)
                    }
                };
                recognizer.start();
            },
            getTaskDescr() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.info = result[0].transcript;
                    }
                };
                recognizer.start();
            },
            getTaskAssignee() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.assignee = result[0].transcript;
                    }
                };
                recognizer.start();
            },
            getTaskDate() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.dateTo = result[0].transcript;
                    }
                };
                recognizer.start();
            },
            getTaskPriority() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.priority = result[0].transcript;
                    }
                };
                recognizer.start();
            },
            getTaskPosition() {
                recognizer.onresult = (event) => {
                    let result = event.results[event.resultIndex];
                    if (result.isFinal) {
                        this.position = result[0].transcript;
                    }
                };
                recognizer.start();
            },
        },
    }
</script>

<style scoped>

</style>