<template>
    <div>
        <div class="app-modal-content">
            <a-input placeholder="Тип задачи" class="app-filter__input app-modal-content__input"></a-input>
            <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro">
        </div>
        <div class="app-modal-content">
            <a-input placeholder="Заголовок" class="app-filter__input app-modal-content__input"></a-input>
            <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro">
        </div>
        <div class="app-modal-content">
            <a-textarea placeholder="Описание" class="app-filter__input"></a-textarea>
            <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro">
        </div>
        <div style="display: flex; flex-direction: row; justify-content: space-between">
            <div class="app-modal-content">
                <a-input placeholder="Исполнитель" class="app-filter__input app-modal-content__input"></a-input>
                <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro">
            </div>
            <div class="app-modal-content">
                <a-input placeholder="Срок выполнения" class="app-filter__input app-modal-content__input"></a-input>
                <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro">
            </div>
        </div>
        <div style="display: flex; flex-direction: row; justify-content: space-between">
            <div class="app-modal-content">
                <a-input placeholder="Важность" class="app-filter__input app-modal-content__input"></a-input>
                <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro">
            </div>
            <div class="app-modal-content">
                <a-input placeholder="Вид деятельности" class="app-filter__input app-modal-content__input"></a-input>
                <img src="../assets/images/micro.svg" alt="" class="app-modal-content__micro">
            </div>
        </div>
        <div class="app-modal-content">
            <a-input placeholder="Вложить файл" class="app-filter__input app-modal-content__input"></a-input>
        </div>
    </div>
</template>

<script>
    export default {
        name: "ModalContent",
    }
</script>

<style scoped>

</style>