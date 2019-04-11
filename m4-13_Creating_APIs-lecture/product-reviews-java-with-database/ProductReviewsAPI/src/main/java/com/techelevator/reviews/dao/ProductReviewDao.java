package com.techelevator.reviews.dao;

import java.util.List;

import com.techelevator.reviews.model.ProductReview;

public interface ProductReviewDao {

	List<ProductReview> list();
	ProductReview read(int id);
	ProductReview create(ProductReview review);
	ProductReview update(ProductReview review);
	void delete(int id);
}
