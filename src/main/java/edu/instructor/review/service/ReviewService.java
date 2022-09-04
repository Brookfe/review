package edu.instructor.review.service;


import edu.instructor.review.dao.ReviewDAO;
import edu.instructor.review.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewDAO reviewDAO;


    public List<Review> getAllReviews(){

        return reviewDAO.findAll();
    }


    public Review getReview(long id) {

        return reviewDAO.findById(id).get();
    }



    public Review addReview(Review newReview) {

        return  reviewDAO.save(newReview);
    }




    public Review updateReview(Review review) {

        return  reviewDAO.save(review);
    }



    public Review deleteReview( long id) {

        Review tempReview = reviewDAO.findById(id).get();

        reviewDAO.deleteById(id);

        return  tempReview;
    }

}
