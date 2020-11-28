<template>
    <div class="app-time">
        <span>{{ tstmpCreate }}</span>
    </div>
</template>

<script>
    export default {
        name: "CardTime",
        props: [ 'tstmpCreate' ]
    }
</script>

<style scoped>

</style>