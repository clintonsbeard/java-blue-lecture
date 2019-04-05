<template>
  <div class="save-review">
    <div class="header">
      <h2>{{pageTitle}}</h2>
      <a href="#" class="back" v-on:click="backToReviews()">
        <i class="fas fa-list-ul"></i> Return to Reviews
      </a>
    </div>
    <div class="form">
      <div class="form-input">
        <span class="label">Full Name:</span> <input type="text" v-model="review.name" placeholder="Enter Full Name">
      </div>
      <div class="form-input">
        <span class="label">Title:</span> <input type="text" v-model="review.title" placeholder="Enter Review Title">
      </div>
      <div class="form-input">
        <span class="label">Review:</span>
        <textarea name="review" id="review" cols="60" rows="10" v-model="review.review"></textarea>
      </div>
      <button :disabled="!isValidForm" v-on:click="saveReview">Save Review</button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    apiURL: String,
    reviewID: Number
  },
  data() {
    return {
      review: {
        name: '',
        title: '',
        review: ''
      }
    }
  },
  methods: {
    backToReviews() {
      this.$emit('showReviews');
    },
    saveReview() {
      this.reviewID === 0 ? this.createReview() : this.updateReview();
    },
    createReview() {
      fetch(this.apiURL,{
        method: 'POST',
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(this.review)
      })
      .then((response) => {
        if(response.ok) {
          this.$emit('showReviews');
        }
      })
      .catch((err) => console.error(err));
    },
    updateReview() {
      fetch(`${this.apiURL}/${this.reviewID}`,{
        method: 'PUT',
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(this.review)
      })
      .then((response) => {
        if( response.ok ) {
          this.$emit('showReviews');
        }
      })
      .catch((err) => console.error(err));
    }
  },
  computed: {
    isValidForm() {
      return this.review.name != '' && this.review.title != '' && this.review.review != '';
    },
    pageTitle() {
      return this.reviewID === 0 ? 'Add Review' : 'Edit Review - ' + this.review.title;
    }
  },
  created() {
    if( this.reviewID != 0 ) {
      fetch(this.apiURL + '/' + this.reviewID)
        .then((response) => {
          return response.json();
        })
        .then((review) => {
          this.review = review;
        })
        .catch((err) => console.error(err));
    }
  }
};
</script>

<style>
.save-review {
  grid-area: product-add;
  margin-top: 30px;
}
.header {
  display: flex;
  border-bottom: 1px solid #ccc;
}
h2 {
  border: none;
}
a.back {
  display: block;
  margin-top: 7px;
  margin-left: auto;
  text-decoration: none;
  border: none;
  color: #4eadea;
}
.form {
  margin-top:20px;
  width:510px;
}
.form-input {
  padding:10px;
}
.label {
  width:200px;
  display: block;
}
input {
  font-size:16px;
  width:480px;
  padding:6px;
}
textarea {
  font-size: 16px;
  line-height: 1.5;
}
button {
  background-color: #4eadea;
  padding:5px;
  border-radius: 10px;
  width:150px;
  color:#fff;
  text-transform: uppercase;
  font-size: 15px;
  float: right;
}
</style>
