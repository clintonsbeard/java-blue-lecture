<template>
    <form v-on:submit.prevent="handleFilter">
        <input type="text" placeholder="Filter on..." v-model="searchText"><button>Filter</button>
    </form>
</template>

<script>
export default {
    name: 'search-bar',
    data() {
        return {
            searchText: ''
        };
    },
    methods: {
        handleFilter() {
            
        }
    }
}
</script>

<style scoped>

form {
    display: flex;
    justify-content: flex-end;
    padding: 0.5em;
}

form * {
    padding: 0.5em;
    margin: 1em;
}

form input {
    flex: 2;
    font-size: 1em;
}

form button {
    width: 20%;
}

</style>
