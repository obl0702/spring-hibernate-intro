package com.ongbl.springdata.project01.lesson6onetomany.bootstrap;

import com.ongbl.springdata.project01.lesson6onetomany.entities.Customer;
import com.ongbl.springdata.project01.lesson6onetomany.entities.PhoneNumber;
import com.ongbl.springdata.project01.lesson6onetomany.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;

@Component
public class RunClass implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        execute();
    }

    public void execute(){

        Customer customer = customerRepository.findById(2l).get();
        Set<PhoneNumber> numbers = customer.getNumbers();
        numbers.forEach(number -> System.out.println(number));

        /*
        Customer customer = new Customer();
        customer.setName("John");
        HashSet<PhoneNumber> numbers = new HashSet<PhoneNumber>();
        PhoneNumber ph1 = new PhoneNumber();
        ph1.setNumber("1233343");
        ph1.setType("cell");
        ph1.setCustomer(customer);
        numbers.add(ph1);

        PhoneNumber ph2 = new PhoneNumber();
        ph2.setNumber("3456343434");
        ph2.setType("home");
        ph2.setCustomer(customer);
        numbers.add(ph2);

        customer.setNumbers(numbers);
        customerRepository.save(customer);
         */
    }
}
