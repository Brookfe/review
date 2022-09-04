package edu.instructor.review.dao;

import edu.instructor.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDAO extends JpaRepository<Review, Long> {


}
