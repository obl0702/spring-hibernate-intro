package com.ongbl.springdata.project01.lesson6onetomany.repos;

import com.ongbl.springdata.project01.lesson6onetomany.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
