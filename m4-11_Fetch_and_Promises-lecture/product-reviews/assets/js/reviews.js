let reviews = [];

const button = document.querySelector("button");
button.addEventListener("click", () => {
    loadReviews();
    button.disabled = true;
})

function loadReviews() {
    console.log("Load Reviews...");

    fetch('data.json')
        .then( (response) => {
            return response.json();
        })
        .then( (data) => {
            reviews = data;
            console.table(reviews);
            displayReviews();
        })
        .catch( err => console.error(err));
}

function displayReviews() {
    console.log("Display Reviews...");
    // check if browser can use a template
    if ('content' in document.createElement('template')) {
        // query the document for .reviews and assign to a variable named container
        const reviewsDiv = document.querySelector('.reviews');
        // loop over the array of reviews
        reviews.forEach( (review) => {
            // get the template using id review-template
            // clone the template and store it in a variable
            const tmpl = document.getElementById('review-template').content.cloneNode(true);
            // find all the elements in the template
            tmpl.querySelector('img').setAttribute('src', review.avatar);
            tmpl.querySelector('.username').innerText = review.username;
            tmpl.querySelector('h2').innerText = review.title;
            tmpl.querySelector('.published-date').innerText = review.publishedOn;
            tmpl.querySelector('.user-review').innerText = review.review;
            // append the template to the DOM
            reviewsDiv.appendChild(tmpl);
        });
    }
    else {
        // log an error if the browser cannot use a template
        console.error('Your browser does not support templates');
    }
}