<template>
    <div class="app-filter">
        <a-input placeholder="Поиск по задачам" class="app-filter__input" />
        <a-button
            type="primary"
            icon="plus"
            class="app-filter__button"
            size="small"
            @click="showModal"
        >
            Создать задачу
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
    </div>
</template>

<script>
    import ModalContent from './ModalContent'
    export default {
        name: "FilterBlock",
        components: {
            ModalContent
        },
        data() {
            return {
                visible: false
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