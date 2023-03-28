package com.ongbl.springdata.project01.lesson1.repository;

import com.ongbl.springdata.project01.lession1.entities.Student;
import com.ongbl.springdata.project01.lession1.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {

    /*
    insert into student (fname, lname, score) values ('John', 'Ferguson', 88);
    insert into student (fname, lname, score) values ('Bill', 'Gate', 75);
     */

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void findAllStudents(){
        Sort.Order or1 = new Sort.Order(Sort.Direction.DESC, "fname");
        Sort.Order or2 = new Sort.Order(Sort.Direction.ASC, "id");
        List<Sort.Order> orders = new ArrayList<>(Arrays.asList(or1,or2));

        Pageable paging = PageRequest.of(0,4, Sort.by(orders));

        List<Student> students = studentRepository.findAllStudents(paging);
        students.forEach(System.out::println);
    }

    @Test
    public void findAllStudentsFNameLName(){
        List<Object[]> students = studentRepository.findAllStudentsFNameLName();
        students.forEach(x -> System.out.println("FName: " + x[0] + " LName: " + x[1]));
    }

    @Test
    public void findAllStudentsByFirstName(){
        List<Student> students = studentRepository.findAllStudentsByFirstName("John");
        students.forEach(x -> System.out.println(x));
    }

    @Test
    public void findAllStudentsByScore(){
        Sort.Order or1 = new Sort.Order(Sort.Direction.DESC, "fname");
        Sort.Order or2 = new Sort.Order(Sort.Direction.ASC, "id");
        List<Sort.Order> orders = new ArrayList<>(Arrays.asList(or1,or2));
        Pageable paging = PageRequest.of(0,2, Sort.by(orders));

        List<Student> students = studentRepository.findAllStudentsByScore(75,90,paging);
        students.forEach(x -> System.out.println(x));
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testDeleteStudentsByFirstName(){
        studentRepository.deleteStudentsByFirstName("Bill");


        Sort.Order or1 = new Sort.Order(Sort.Direction.DESC, "fname");
        Sort.Order or2 = new Sort.Order(Sort.Direction.ASC, "id");
        List<Sort.Order> orders = new ArrayList<>(Arrays.asList(or1,or2));

        Pageable paging = PageRequest.of(0,2, Sort.by(orders));

        List<Student> students = studentRepository.findAllStudents(paging);
        students.forEach(System.out::println);
    }

    @Test
    public void testFindAllStudentNQ(){
        studentRepository.findAllStudentNQ().forEach(System.out::println);
    }

    @Test
    public void findAllStudentsByFirstNameNQ(){
        List<Student> students = studentRepository.findAllStudentsByFirstNameNQ("John");
        students.forEach(x -> System.out.println(x));
    }

    @Test
    public void findAllStudentsFNameLNameByFisrtNameNQ(){
        List<Object[]> students = studentRepository.findAllStudentsFNameLNameByFisrtNameNQ("John");
        students.forEach(x -> System.out.println("FName: " + x[0] + " LName: " + x[1]));
    }

}