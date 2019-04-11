package com.techelevator.reviews.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.reviews.model.ProductReview;

@Component
public class JdbcProductReviewDao implements ProductReviewDao {

	private final static String SELECT_PRODUCT_REVIEW_SQL = "SELECT id, name, title, avatar, review, created FROM product_reviews";
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcProductReviewDao(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<ProductReview> list() {
		
		List<ProductReview> reviews = new ArrayList<ProductReview>();
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(SELECT_PRODUCT_REVIEW_SQL + " ORDER BY id");
		while (rows.next()) {
			reviews.add(mapRowToProductReview(rows));
		}
		
		return reviews;
	}
	
	@Override
	public ProductReview read(int id) {
		
		String sql = SELECT_PRODUCT_REVIEW_SQL + " WHERE id=?";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, id);
		rows.next();
		return mapRowToProductReview(rows);
	}
	
	@Override
	public ProductReview create(ProductReview review) {

		String insertSql ="INSERT INTO product_reviews (id, name, title, review, avatar, created) "
				+ " VALUES (DEFAULT, ?, ?, ?, ?, current_timestamp) RETURNING id, created";
		
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(insertSql, review.getName(), review.getTitle(), review.getReview(), review.getAvatar());
		results.next();
		review.setId(results.getInt("id"));
		review.setCreatedAt(results.getDate("created"));
		
		return review;
	}
	
	@Override
	public ProductReview update(ProductReview review) {

		String updateSql = "UPDATE product_reviews SET name = ?, title=?, avatar=?, review=? WHERE id = ?";
		jdbcTemplate.update(updateSql, review.getName(),
				review.getTitle(), review.getAvatar(), review.getReview(), review.getId());
		return review;
	}
	
	@Override
	public void delete(int id) {
		String deleteSql = "DELETE FROM product_reviews WHERE id = ?";
		jdbcTemplate.update(deleteSql, id);
		
	}
	
	private ProductReview mapRowToProductReview(SqlRowSet row) {
		ProductReview review = new ProductReview();
		
		review.setId(row.getInt("id"));
		review.setName(row.getString("name"));
		review.setTitle(row.getString("title"));
		
		/*
		 * If not Avatar image URL exists, default it.   This is because the UI does
		 * not upload an Avatar for added reviews.   This should not be in the DAO, but
		 * the UI should also provide an Avatar. 
		 */
		if (row.getString("avatar") == null) {
			review.setAvatar("https://randomuser.me/api/portraits/lego/1.jpg");
		} else {
			review.setAvatar(row.getString("avatar"));
		}
		
		review.setReview(row.getString("review"));
		review.setCreatedAt(row.getDate("created"));

		return review;
	}



}
