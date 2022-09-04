package edu.instructor.review.dao;

import edu.instructor.review.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDAO extends JpaRepository<Instructor, Long> {




}
