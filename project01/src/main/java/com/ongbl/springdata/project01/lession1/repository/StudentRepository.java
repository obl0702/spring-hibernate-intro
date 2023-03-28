package com.ongbl.springdata.project01.lession1.repository;

import com.ongbl.springdata.project01.lession1.entities.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("from Student")
    List<Student> findAllStudents(Pageable pageable);

    @Query("select st.firstName, st.lastName from Student st")
    List<Object[]> findAllStudentsFNameLName();

    @Query("from Student where firstName=:fName")
    List<Student> findAllStudentsByFirstName(@Param("fName") String firstName);

    @Query("from Student where score > :min and score < :max")
    List<Student> findAllStudentsByScore(
            @Param("min") int min
            , @Param("max") int max
            ,Pageable pageable);

    @Modifying
    @Query("delete from Student where firstName = :fName")
    void deleteStudentsByFirstName(@Param("fName") String firstName);

    //This is native query not JPQL!!
    @Query(value = "select * from student", nativeQuery = true)
    List<Student> findAllStudentNQ();

    @Query(value = "select * from student where fname = :fn", nativeQuery = true)
    List<Student> findAllStudentsByFirstNameNQ(@Param("fn") String firstName);

    @Query(value = "select fname, lname from student where fname = :fn", nativeQuery = true)
    List<Object[]> findAllStudentsFNameLNameByFisrtNameNQ(@Param("fn") String firstName);
}
