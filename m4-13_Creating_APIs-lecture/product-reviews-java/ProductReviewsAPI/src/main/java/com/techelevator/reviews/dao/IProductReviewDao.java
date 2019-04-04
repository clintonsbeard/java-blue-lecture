package com.techelevator.reviews.dao;

import java.util.List;

import com.techelevator.reviews.model.ProductReview;

public interface IProductReviewDao {
	
	public List<ProductReview> list();
	
	public ProductReview create(ProductReview review);
	
	public ProductReview read(int id);

	public ProductReview update(ProductReview review);
	
	public void delete(int id);
}
