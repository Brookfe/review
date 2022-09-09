package edu.instructor.review.serviceTest;

import edu.instructor.review.dao.InstructorDAO;
import edu.instructor.review.entity.Instructor;
import edu.instructor.review.service.InstructorService;
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

@SpringBootTest(classes = {InstructorServiceTest.class})
public class InstructorServiceTest {

    @Mock
    private InstructorDAO instructorDAO;

    @InjectMocks
    InstructorService instructorService;

    static List<Instructor> instructorList;
    static Instructor newInstructor;

    @BeforeAll
    public static void init(){
        newInstructor = new Instructor();
        instructorList = new ArrayList<>();

        instructorList.add(new Instructor(1, "OneFirstName", "OneLastName"));
        instructorList.add(new Instructor(2, "TwoFirstName", "TwoLastName" ));

    }

    @Test
    public void getAllInstructorsTest(){

        when(instructorDAO.findAll()).thenReturn(instructorList);

        assertEquals(2, instructorService.getAllInstructors().size());
    }

    @Test
    public void getInstructorTest(){

        when(instructorDAO.findById(1L)).thenReturn(Optional.of(instructorList.get(1)));

        assertEquals(instructorList.get(1), instructorService.getInstructor(1L));
    }


    @Test
    public void addInstructorTest(){

        when(instructorDAO.save(newInstructor)).thenReturn(newInstructor);

        assertEquals(newInstructor, instructorService.addInstructor(newInstructor) );

    }


    @Test
    public void updateInstructorTest(){

        when(instructorDAO.save(newInstructor)).thenReturn(newInstructor);

        assertEquals(newInstructor, instructorService.updateInstructor(newInstructor));

    }



    @Test
    public void deleteInstructorTest(){

        when(instructorDAO.findById(1L)).thenReturn(Optional.of(instructorList.get(1)));

        assertEquals(instructorList.get(1), instructorService.deleteInstructor(1L));
    }






}
