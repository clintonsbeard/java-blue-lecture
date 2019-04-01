<template>
  <div id="app">
    <product-review
      name="Cigar Parties for Dummies"
      description="Host and plan the perfect cigar party for all of your squirrelly friends."
       />
    <product-review
      name="Tech Elevator Bootcamp Extravaganza"
      description="14 crazy weeks of fun and coding with an emphasis on the coding"
       />
  </div>
</template>

<script>
import ProductReview from './components/ProductReview.vue';

export default {
  name: 'app',
  components: {
    ProductReview
  },
  data() {
    return {

    };
  },
  methods: {

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

#app div.main {
  display: inline-block;
  width: 45%;
  padding: 1em;
  border: 1px black solid;
  border-radius: 5px;
  margin: 0 1em;
  vertical-align: top;
}
</style>
