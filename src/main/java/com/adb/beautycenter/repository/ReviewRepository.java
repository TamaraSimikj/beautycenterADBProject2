package com.adb.beautycenter.repository;

import com.adb.beautycenter.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
