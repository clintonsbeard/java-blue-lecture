<template>
  <div class="main">
    <h2>Product Reviews for {{ name }}</h2>

    <p class="description">{{ description }}</p>

    <div class="well-display">
      <div class="well">
        <span class="amount" v-on:click="filter = 0">{{ averageRating }}</span>
        Average Rating
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter = 1">{{ numberOfOneStarReviews }}</span>
        1 Star Review{{ numberOfOneStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter = 2">{{ numberOfTwoStarReviews }}</span>
        2 Star Review{{ numberOfTwoStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter = 3">{{ numberOfThreeStarReviews }}</span>
        3 Star Review{{ numberOfThreeStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter = 4">{{ numberOfFourStarReviews }}</span>
        4 Star Review{{ numberOfFourStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter = 5">{{ numberOfFiveStarReviews }}</span>
        5 Star Review{{ numberOfFiveStarReviews === 1 ? '' : 's' }}
      </div>
    </div>

    <a
      href="#"
      data-test="show-form-anchor"
      v-on:click.prevent="showForm = true"
      v-if="showForm === false"
    >Show Form</a>

    <form v-if="showForm === true" v-on:submit.prevent="addNewReview">
      <div class="form-element">
        <label for="reviewer">Name:</label>
        <input id="reviewer" type="text" v-model="newReview.reviewer">
      </div>
      <div class="form-element">
        <label for="title">Title:</label>
        <input id="title" type="text" v-model="newReview.title">
      </div>
      <div class="form-element">
        <label for="rating">Rating:</label>
        <select id="rating" v-model.number="newReview.rating">
          <option value="1">1 Star</option>
          <option value="2">2 Stars</option>
          <option value="3">3 Stars</option>
          <option value="4">4 Stars</option>
          <option value="5">5 Stars</option>
        </select>
      </div>
      <div class="form-element">
        <label for="review">Review</label>
        <textarea id="review" v-model="newReview.review"></textarea>
      </div>
      <button>Submit</button>
      <button v-on:click.prevent="resetForm" type="cancel">Cancel</button>
    </form>

    <div class="review" v-for="review in filteredReviews" v-bind:key="review.id">
      <h4>{{ review.reviewer }}</h4>
      <div class="rating">
        <img
          src="../assets/star.png"
          v-bind:title="review.rating + ' Star Review'"
          class="ratingStar"
          v-for="(n, i) in review.rating"
          v-bind:key="i"
        >
      </div>
      <h3>{{ review.title }}</h3>

      <p>{{ review.review }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "product-review",
  props: {
    name: String,
    description: String
  },
  data() {
    return {
      showForm: false,
      filter: 0,
      newReview: {},
      reviews: []
    };
  },
  computed: {
    averageRating(vm) {
      if (vm.reviews.length === 0) {
        return 0;
      }
      let sum = vm.reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return sum / vm.reviews.length;
    },
    filteredReviews(vm) {
      return vm.reviews.filter(review => {
        return vm.filter === 0 ? true : vm.filter === review.rating;
      });
    },
    numberOfOneStarReviews(vm) {
      return vm.numberOfReviews(vm.reviews, 1);
    },
    numberOfTwoStarReviews(vm) {
      return vm.numberOfReviews(vm.reviews, 2);
    },
    numberOfThreeStarReviews(vm) {
      return vm.numberOfReviews(vm.reviews, 3);
    },
    numberOfFourStarReviews(vm) {
      return vm.numberOfReviews(vm.reviews, 4);
    },
    numberOfFiveStarReviews(vm) {
      return vm.numberOfReviews(vm.reviews, 5);
    }
  },
  methods: {
    numberOfReviews(reviews, starType) {
      return reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === starType ? 1 : 0);
      }, 0);
    },
    addNewReview() {
      this.reviews.unshift(this.newReview);
      this.resetForm();
    },
    resetForm() {
      this.showForm = false;
      this.newReview = {};
    }
  }
};
</script>

<style scoped>
div.main {
  margin: 1rem 0;
}

div.main div.well-display {
  display: flex;
  justify-content: space-around;
}

div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
  cursor: pointer;
}

div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

div.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}
div.main div.review div.rating img {
  height: 100%;
}

div.main div.review p {
  margin: 20px;
}

div.main h3 {
  display: inline-block;
}

div.main h4 {
  font-size: 1rem;
}

div.main .form-element {
  display: flex;
  justify-content: flex-end;
  padding: 0.5em;
}
div.main .form-element label {
  padding: 0.5em 1em 0.5em 0;
  flex: 1;
}

div.main .form-element input,
div.main .form-element select,
div.main .form-element textarea {
  flex: 2;
}

div.main .form-element textarea {
  height: 10rem;
}

div.main .form-element input,
div.main button {
  padding: 0.5em;
}

div.main button {
  background: gray;
  color: white;
  border: 0;
}
</style>

