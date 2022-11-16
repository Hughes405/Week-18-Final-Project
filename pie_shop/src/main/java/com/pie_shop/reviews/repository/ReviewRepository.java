package com.pie_shop.reviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pie_shop.reviews.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
