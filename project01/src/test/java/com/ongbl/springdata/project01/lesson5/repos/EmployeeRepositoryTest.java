package com.ongbl.springdata.project01.lesson5.repos;

import com.ongbl.springdata.project01.lesson5.entities.Address;
import com.ongbl.springdata.project01.lesson5.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
    }

    @Transactional
    @Test
    @Rollback(false)
    public void testCreate(){

        Address address = new Address();
        address.setCity("Austin");
        address.setStreetaddress("Spicewood Spings");
        address.setCountry("USA");
        address.setState("Texas");
        address.setZipcode("46344");

        Employee employee = new Employee();
        employee.setId(123);
        employee.setName("Bhhh");
        employee.setAddress(address);

        employeeRepository.save(employee);
    }
}