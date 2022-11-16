package com.pie_shop.reviews.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pie_shop.reviews.entity.Review;
import com.pie_shop.reviews.services.ReviewService;

@RestController
@RequestMapping("/pie_shop/reviews")
public class ReviewController {

	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}

	@GetMapping
	public List<Review> getAllReviews() {
		return reviewService.getAllReviews();
	}

	@PostMapping // TODO how to not overwite current reviews.
	public ResponseEntity<Review> createReview(@RequestBody Review review) {
		return new ResponseEntity<Review>(reviewService.createReview(review), HttpStatus.CREATED);

	}

	@PutMapping("{review_id}")
	public ResponseEntity<Review> editReview(@PathVariable("review_id") int id, @RequestBody Review review) {
		return new ResponseEntity<Review>(reviewService.editReview(review, id), HttpStatus.OK);
	}

}
