package edu.instructor.review.serviceTest;

import edu.instructor.review.dao.ReviewDAO;
import edu.instructor.review.entity.Review;
import edu.instructor.review.service.ReviewService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ReviewServiceTest.class})
public class ReviewServiceTest {

    @Mock
    private ReviewDAO reviewDAO;

    @InjectMocks
    private ReviewService reviewService;

    private static List<Review> reviewList;

    private static Review newReview;


    @BeforeAll
    public static void init(){

        newReview = new Review();
        reviewList = new ArrayList<>();
        reviewList.add(new Review(1, "A great instructor"));
        reviewList.add(new Review(2, "Amazing instructor"));

    }


    @Test
    public void getAllReviewsTest(){

        when(reviewDAO.findAll()).thenReturn(reviewList);

        assertEquals(reviewList.size(), reviewService.getAllReviews().size());
    }


    @Test
    public void getReviewTest(){

        when(reviewDAO.findById(1L)).thenReturn(Optional.of( reviewList.get(1) ));

        assertEquals(reviewList.get(1), reviewService.getReview(1L));
    }


    @Test
    public void addReviewTest(){

        when(reviewDAO.save(newReview)).thenReturn(newReview);

        assertEquals(newReview, reviewService.addReview(newReview));

    }

    @Test
    public void updateReviewTest(){

        when(reviewDAO.save(newReview)).thenReturn(newReview);

        assertEquals(newReview, reviewService.updateReview(newReview));

    }


    @Test
    public void deleteReviewTest(){

        when(reviewDAO.findById(1L)).thenReturn(Optional.of(reviewList.get(1)));

        assertEquals(reviewList.get(1), reviewService.deleteReview(1));
    }




}
