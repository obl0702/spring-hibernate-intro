package com.ongbl.springdata.project01.lesson6onetomany.repos;

import com.ongbl.springdata.project01.lesson6onetomany.entities.Customer;
import com.ongbl.springdata.project01.lesson6onetomany.entities.PhoneNumber;
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
import java.util.List;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
    }

    @Transactional
    @Test
    @Rollback(false)
    public void testCreateCustomer(){
        Customer customer = new Customer();
        customer.setName("John");
        HashSet<PhoneNumber> numbers = new HashSet<PhoneNumber>();

        PhoneNumber ph1 = new PhoneNumber();
        ph1.setNumber("1233343");
        ph1.setType("cell");
        numbers.add(ph1);

        PhoneNumber ph2 = new PhoneNumber();
        ph2.setNumber("3456343434");
        ph2.setType("home");
        numbers.add(ph2);

        customer.addPhoneNumber(ph1);
        customer.addPhoneNumber(ph2);

        customerRepository.save(customer);
    }

    @Test
    @Transactional
    public void testLoadCustomer(){
        long id = 2l;
        Customer customer = customerRepository.findById(id).get();
        Set<PhoneNumber> numbers = customer.getNumbers();
        numbers.forEach(number -> System.out.println(number));

    }

    @Test
    @Transactional
    public void testUpdateCustomer(){
        Customer customer = customerRepository.findById(2l).get();
        customer.setName("Ali");

        customerRepository.save(customer);

        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        customers.forEach(System.out::println);
    }

    @Test
    public void testDelete(){
        customerRepository.deleteById(1l);
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        customers.forEach(System.out::println);
    }
}