<template>
    <div class="app-block">
        <div class="app-block-left">
            <UserBlock
                :userName="getUsers[0].name"
                :userId="getUsers[0].id"
            />
            <Menu />
        </div>
        <div class="app-block-right">
            <FilterBlock />
            <CardBlock />
        </div>
    </div>
</template>

<script>
    import UserBlock from './UserBlock'
    import Menu from './Menu'
    import FilterBlock from './FilterBlock'
    import CardBlock from './CardBlock'
    import {mapState} from "vuex";

    export default {
        name: "Board",
        components: {
            UserBlock,
            Menu,
            FilterBlock,
            CardBlock
        },
        mounted() {
            this.$store.dispatch('GET_USERS');
            this.$store.dispatch('GET_TASKS_PRIORITY')
        },
        computed: {
            ...mapState(['users']),
            getUsers() {
                return this.users;
            },
        },
    }
</script>

<style scoped>

</style>