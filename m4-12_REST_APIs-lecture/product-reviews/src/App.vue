<template>
  <div id="app">
    <product-page></product-page>
  </div>
</template>

<script>
import ProductPage from '@/components/ProductPage'

export default {
  name: 'app',
  components: {
    ProductPage
  }
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
}
body {
  background-color: #4EADEA;
  font-family: 'Roboto Condensed', sans-serif;
}
#app {
  width: 50%;
  min-height: 100vh;
  height: 100%;
  background-color: #fff;
  margin: 10px auto;
  padding: 20px;
  box-shadow: 4px 4px rgb(0, 0, 0, 40%);
}
</style>
