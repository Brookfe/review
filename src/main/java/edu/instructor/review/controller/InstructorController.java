package edu.instructor.review.controller;

import edu.instructor.review.entity.Instructor;
import edu.instructor.review.entity.Review;
import edu.instructor.review.service.InstructorService;
import edu.instructor.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private ReviewService reviewService;


    @GetMapping("/instructors")
    public List<Instructor> getInstructors(){

        return instructorService.getAllInstructors();
    }


    /*
    getReviews: returns reviews of an instructor
     */
    @GetMapping("/instructor/{id}/reviews")
    public List<Review> getReviews(@PathVariable(value="id") long id) {

        return instructorService.getInstructor(id).getReviewList();
    }



    /*
    addReview: adds a review to the instructor
     */
    @PostMapping("/instructor/{id}")
    public List<Review> addReview(@RequestBody Review newReview, @PathVariable(value="id") long id ) {

        Instructor tempInstructor = instructorService.getInstructor(id);

        tempInstructor.addComment(newReview);

        instructorService.addInstructor(tempInstructor);

        return tempInstructor.getReviewList();
    }


    /*
    addInstructor: adds a new instructor
     */
    @PostMapping("/instructors")
    public List<Instructor> addInstructor(@RequestBody Instructor newInstructor){

        instructorService.addInstructor(newInstructor);

        return instructorService.getAllInstructors();
    }


    /*
    editReview: edits the review
     */
    @PutMapping("instructor/{id}/updateReview")
    public List<Review> editReview(@RequestBody Review review, @PathVariable(value="id") long id ){

        Instructor tempInstructor = instructorService.getInstructor(id);

        reviewService.updateReview(review);

        return tempInstructor.getReviewList();
    }



    /*
    removeReview: removes a review
     */
    @DeleteMapping("/instructor/{id}/deleteReviews/{rId}")
    public List<Review> removeReview(@PathVariable(value = "id") long id, @PathVariable(value = "rId") long rId ) {

        reviewService.deleteReview(rId);
        Instructor tempInstructor = instructorService.getInstructor(id);


        return tempInstructor.getReviewList();
    }


    @DeleteMapping("/instructor/{id}")
    public List<Instructor> removeInstructore(@PathVariable(value = "id") long id) {

        instructorService.deleteInstructor(id);


        return instructorService.getAllInstructors();
    }



}
