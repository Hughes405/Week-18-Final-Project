package com.pie_shop.reviews.services;

import java.util.List;

import com.pie_shop.reviews.entity.Review;

public interface ReviewService {

	public List<Review> getAllReviews();

	public Review createReview(Review review);

	public Review editReview(Review review, int id);

}
