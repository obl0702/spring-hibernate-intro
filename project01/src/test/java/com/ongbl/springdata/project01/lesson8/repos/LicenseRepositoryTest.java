package com.ongbl.springdata.project01.lesson8.repos;

import com.ongbl.springdata.project01.lesson8.entities.License;
import com.ongbl.springdata.project01.lesson8.entities.Person;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class LicenseRepositoryTest {

    @Autowired
    private LicenseRepository licenseRepository;

    @Autowired
    EntityManager entityManager;


    @BeforeEach
    void setUp() {
    }

    @Transactional
    @Test
    @Rollback(false)
    public void testOneToOneCreateLicense(){
        License license = new License();
        license.setType("CAR");
        license.setValidFrom(new Date());
        license.setValidTo(new Date());

        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Clinton");
        person.setAge(32);
        license.setPerson(person);

        licenseRepository.save(license);
    }

    @Test
    public void testCacheLvl1(){
        Session session = entityManager.unwrap(Session.class);

        License license = new License();

        //1st
        license = licenseRepository.findById(2l).get();

        //2nd
        license = licenseRepository.findById(2l).get();

        //clear session Level01
        session.evict(license);
        System.out.println("Session clear");

        //3rd
        license = licenseRepository.findById(2l).get();

        /*
        Conclusion:
        1st and 2nd only call once because it is cached at level1.
        3rd will still call because the session has been clear/evict for level1

         */

        //Only exclude once....
    }

}