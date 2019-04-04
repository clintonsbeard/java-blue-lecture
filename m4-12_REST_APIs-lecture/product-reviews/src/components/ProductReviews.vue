<template>
  <div class="product-reviews">
    <div class="header">
      <h2>Reviews <span>({{reviews.length}})</span></h2>
      <a href="#" class="add-review" v-on:click="$emit('addReview')">
        <i class="far fa-address-card"></i> Add Review
      </a>
    </div>
    <div class="review" v-for="review in reviews" :key="review.id">
      <div class="review-left">
        <img :src="review.avatar" class="avatar"/>
        <div class="review-actions">
          <a href="#" class="edit-review" v-on:click="editReview(parseInt(review.id))">
            <i class="far fa-edit"></i> Edit 
          </a>
          <a href="#" class="delete-review" v-on:click="deleteReview(review.id)">
            <i class="far fa-trash-alt"></i> Delete 
          </a>
        </div>
      </div>
      <div class="review-info">
        <h2>{{review.title}}</h2>
        <span>{{review.name}} | {{formatDate(review.createdAt)}}</span>
        <p class="feedback">{{review.review}}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ProductReviews",
  props: {
    apiURL: String
  },
  data() {
    return {
      reviews: []
    };
  },
  methods: {
    editReview(id) {
      this.$emit('editReview',id)
    },
    deleteReview(id) {

    },
    formatDate(d) {
      let current_datetime = new Date(d)
      return (current_datetime.getMonth() + 1) + "/" + current_datetime.getDate() + "/" + current_datetime.getFullYear() + " " + current_datetime.getHours() + ":" + current_datetime.getMinutes();
    }
  },
  created() {

  }
};
</script>

<style>
.product-reviews {
  grid-area: product-reviews;
  margin-top: 30px;
}
.header {
  display: flex;
  border-bottom: 1px solid #ccc;
}
h2 {
  border:none;
}
h2 span {
  font-size:14px;
}
a.add-review {
  display: block;
  margin-top:7px;
  margin-left:auto;
  text-decoration: none;
  border:none;
  color:#4EADEA;
}
.review {
  display: flex;
  margin: 20px;
  border-bottom: 1px solid #ccc;
}
.review-left {
  margin-right: 20px;
}
.avatar {
    display: block;
    width: 100px;
    border-radius: 50%;
    box-shadow: 0px 3px 10px rgb(0, 0, 0, 40%);
    margin: auto auto;
}
.feedback {
  margin-top: 10px;
  line-height: 1.7;
  padding-bottom: 15px;
}
.review-actions {
  margin-top: 20px;
  margin-left: 10px;
  text-align: center;
}
.review-actions a, .review-actions a:visited {
  display: block;
  color:black;
  margin-top:10px;
  text-decoration: none;
  color:#4EADEA;
}
.review-actions a:hover {
  color:rgb(0, 116, 189);
}
</style>
