package com.pie_shop.reviews.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pie_shop.reviews.entity.Review;
import com.pie_shop.reviews.repository.ReviewRepository;
import com.pie_shop.exceptions.ConstraintViolationException;
import com.pie_shop.exceptions.ResourceNotFoundException;

@Service
public class ReviewServiceImp implements ReviewService{
	private ReviewRepository reviewRepository;

	@Autowired
	public ReviewServiceImp(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}

	@Override
	public List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}

	@Override // throws a 400 error if there is an existing record with same id

	public Review createReview(Review review) {
		int id = review.getReviewId();
		if (reviewRepository.existsById(id)) {
			throw new ConstraintViolationException("Review", "Id", id);
		}

		return reviewRepository.save(review);

	}

	@Override
	public Review editReview(Review review, int id) {
		Review existingReview = reviewRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Review", "Id", id));

		existingReview.setCustomerId(review.getCustomerId());
		existingReview.setTextBody(review.getTextBody());

		reviewRepository.save(existingReview);
		return existingReview;

	}

}
