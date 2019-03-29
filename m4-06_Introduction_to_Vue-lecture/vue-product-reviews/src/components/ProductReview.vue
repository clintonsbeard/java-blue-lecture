<template>
    <div class="main">
        <h2>Product Review {{ productName }}</h2>
        <p class="description">{{ description }}</p>
    </div>
</template>

<style scoped>
<<<<<<< HEAD
    div.main {
        margin: 1rem 0;
    }
=======
div.main {
    margin: 1rem 0;
}
>>>>>>> 8b78e057775d418691169d51503e72c097c95e20
</style>

<script>
export default {
    name: 'product-review',
<<<<<<< HEAD
    data () {
        return {
            productName: 'Cigar Parties for Dummies',
            description: 'Host and plan the perfect cigar party for all your squirrelly friends.'
        }
    }
=======
    data() {
        return {
            productName: "Cigar Parties for Dummies",
            description: "Host and plan the perfect cigar party for all your squirrelly friends."
        }
    }

>>>>>>> 8b78e057775d418691169d51503e72c097c95e20
}
</script>