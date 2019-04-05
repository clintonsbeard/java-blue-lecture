<template>
  <div class="product" >
    <div class="product-image">
      <img src="../assets/img/teyeti.jpg" alt="Tech Elevator Yeti" class="product-image">
    </div>
    <div class="product-info">
      <h1>TECH ELEVATOR YETI</h1>
      <p class="description">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
    </div>
    <save-review v-if="showAddProductForm" v-on:showReviews="showReviews" :apiURL="API_URL" :reviewID="reviewID"/>
    <product-reviews 
      v-if="!showAddProductForm" 
      :apiURL="API_URL"
      v-on:addReview="addReview" 
      v-on:editReview="editReview($event)"/>
  </div>
</template>

<script>
import SaveReview from "@/components/SaveReview"
import ProductReviews from "@/components/ProductReviews";

export default {
  components: {
    SaveReview,
    ProductReviews
  },
  data() {
    return {
      API_URL: "YOUR_API_URL_HERE",
      showAddProductForm: false,
      reviewID: 0
    }
  },
  methods: {
    addReview() {
      this.showAddProductForm = true;
    },
    editReview(id) {
      this.reviewID = id;
      this.showAddProductForm = true;
    },
    showReviews() {
      this.showAddProductForm = false;
      this.reviewID = 0;
    }
  }
};
</script>

<style>
.product {
  display: grid;
  grid-template-areas:
    "product-image product-info"
    "product-reviews product-reviews"
    "product-add product-add";
  grid-template-columns: 300px auto;
}
.product-image {
  grid-area: product-image;
}
.product-image img {
  max-width: 280px;
  box-shadow: 2px 2px rgb(0, 0, 0, 60%);
  border: 1px solid rgba(0, 0, 0, 0.6);
}
.product-info {
  grid-area: product-info;
}
.description {
  margin-top: 10px;
  line-height: 1.5;
}
</style>
