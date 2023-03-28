package com.ongbl.springdata.project01.lesson7.repos;

import com.ongbl.springdata.project01.lesson7.entities.Programmer;
import com.ongbl.springdata.project01.lesson7.entities.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProgrammerRepositoryTest {

    @Autowired
    private ProgrammerRepository programmerRepository;

    @BeforeEach
    void setUp() {
    }

    @Transactional
    @Test
    @Rollback(false)
    public void testCreateProgrammer(){
        Programmer programmer = new Programmer();
        programmer.setName("John");
        programmer.setSal(11000);

        HashSet<Project> projects = new HashSet<>();
        Project project = new Project();
        project.setName("Hibernate Project");
        projects.add(project);
        programmer.setProjects(projects);

        programmerRepository.save(programmer);
    }

    @Transactional
    @Test
    @Rollback(false)
    public void testmtomFindProgrammer(){
        Programmer programmer = programmerRepository.findById(2).get();
        System.out.println(programmer.getProjects());
    }
}