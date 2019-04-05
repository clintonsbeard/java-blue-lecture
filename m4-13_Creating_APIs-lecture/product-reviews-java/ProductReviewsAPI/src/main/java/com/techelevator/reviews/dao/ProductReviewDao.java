package com.techelevator.reviews.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bouncycastle.util.test.Test;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.reviews.model.ProductReview;

@Component
public class ProductReviewDao implements IProductReviewDao {
	
	private Map<Integer,ProductReview> reviews = new HashMap<>();
	private final String DEFAULT_AVATAR = "https://s3.amazonaws.com/uifaces/faces/twitter/osmanince/128.jpg";
	
	public ProductReviewDao() throws JsonParseException, JsonMappingException, IOException {
		loadJSON();
	}

	@Override
	public List<ProductReview> list() {
		List<ProductReview> allReviews = new ArrayList<>();
		reviews.forEach((k,v) -> allReviews.add(v));
		return allReviews;
	}
	
	@Override
	public ProductReview create(ProductReview review) {
		int max = reviews.entrySet().stream().max((reviewA,reviewB) -> reviewA.getKey() > reviewB.getKey() ? 1 : -1).get().getKey();
		review.setId(max+1);
		review.setAvatar(this.DEFAULT_AVATAR);
		review.setCreatedAt(new Date());
		reviews.put(review.getId(), review);
		return review;
	}
	
	@Override
	public ProductReview read(int id) {
		return reviews.get(id);
	}
	
	@Override
	public ProductReview update(ProductReview review) {
		reviews.put(review.getId(), review);
		return review;
	}
	
	@Override
	public void delete(int id) {
		reviews.remove(id);
	}

	private void loadJSON() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		InputStream inputStream = Test.class.getResourceAsStream("/data.json");
		ProductReview[] jsondata = mapper.readValue(inputStream, ProductReview[].class);
		for(ProductReview review : jsondata) {
			reviews.put(review.getId(),review);
		}
	}

	
}
