<template>
    <div class="app-card app-modal-task-comment">
        <a-card>
            <span class="app-modal-task__info-title">Иванов Петр Иванович</span>
            <span>10:43   27 Ноя 2020</span>
        </a-card>
        <div class="app-modal-task-comment__text">{{ ModalTaskCommentText }}</div>
        <a href="#">Смотреть фото</a>
        <a href="#">Ответить</a>

        <div class="app-modal-content" style="margin-top: 10px">
            <a-textarea placeholder="Комментарий" class="app-filter__input"></a-textarea>
            <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro">
        </div>
    </div>
</template>

<script>
    export default {
        name: "ModalTaskComment",
        data() {
            return {
                ModalTaskCommentText: 'Таким образом постоянный количественный рост и сфера нашей активности позволяет выполнять важные задания по разработке соответствующий условий активизации.'
            }
        }
    }
</script>

<style scoped>

</style>