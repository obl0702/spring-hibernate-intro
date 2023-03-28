package com.ongbl.springdata.project01.lession1.repository;

import com.ongbl.springdata.project01.lession1.entities.Lesson1Customer;
import org.springframework.data.repository.CrudRepository;

public interface Lesson1CustomerRepository extends CrudRepository<Lesson1Customer, Integer> {
}
