<template>
  <div id="app">
    <product-review></product-review>
  </div>
</template>

<script>
import ProductReview from './components/ProductReview.vue'

export default {
  name: 'app',
  components: {
    ProductReview
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>