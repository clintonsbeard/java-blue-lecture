const name = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerHTML = name;
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerHTML = description;
}

/**
 * I will use a template to display all of the reviews on our web page
 */
function displayReviews() {
  if ('content' in document.createElement('template')) {
    const main = document.getElementById('main');
    reviews.forEach((review) => {
      const tmpl = document.getElementById('review-template').content.cloneNode(true);
      tmpl.querySelector('h4').innerHTML = review.reviewer;
      tmpl.querySelector('h3').innerHTML = review.title;
      tmpl.querySelector('p').innerHTML = review.review;
      // there will always be 1 star because it is a part of the template
      for (let i = 1; i < review.rating; ++i) {
        const img = tmpl.querySelector('img').cloneNode();
        tmpl.querySelector('.rating').appendChild(img);
      }
      main.appendChild(tmpl);
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews();
