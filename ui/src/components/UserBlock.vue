<template>
    <div class="app-user app-widgets">
        <a-card>
            <p class="app-block__title">{{ userName }}</p>
            <p class="app-block__title-descr">ID - {{ userId }}</p>
        </a-card>
    </div>
</template>

<script>
    export default {
        name: "UserBlock",
        props: [ 'userName', 'userId' ],
    }
</script>

<style scoped>

</style>