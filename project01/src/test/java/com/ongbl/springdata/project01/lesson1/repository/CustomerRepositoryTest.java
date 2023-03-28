package com.ongbl.springdata.project01.lesson1.repository;

import com.ongbl.springdata.project01.lession1.entities.Lesson1Customer;
import com.ongbl.springdata.project01.lession1.repository.Lesson1CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerRepositoryTest {

    @Autowired
    private Lesson1CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testInsert(){
        Lesson1Customer customer = new Lesson1Customer();
        customer.setId(1);
        customer.setName("Boon Loong");
        customer.setEmail("obl0702@gmail.com");

        customerRepository.save(customer);

        Lesson1Customer findedCustomer = customerRepository.findById(1).get();
        System.out.println(findedCustomer);

        boolean result = customerRepository.existsById(1);
        System.out.println(result);

        System.out.println("Total Records: " + customerRepository.count());
    }
}