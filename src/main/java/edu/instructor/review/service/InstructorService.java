package edu.instructor.review.service;

import edu.instructor.review.dao.InstructorDAO;
import edu.instructor.review.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    @Autowired
    private InstructorDAO instructorDAO;


    public List<Instructor> getAllInstructors() {

        return instructorDAO.findAll();
    }




    public Instructor getInstructor(long id) {

        
        return instructorDAO.findById(id).get();
    }




    public Instructor addInstructor(Instructor newInstructor) {

        return instructorDAO.save(newInstructor);
    }





    public Instructor updateInstructor(Instructor instructor) {

        return instructorDAO.save(instructor);
    }



    public Instructor deleteInstructor(long id) {

        Instructor tempInstructor = instructorDAO.findById(id).get();

        instructorDAO.deleteById(id);

        return tempInstructor;
    }




}
