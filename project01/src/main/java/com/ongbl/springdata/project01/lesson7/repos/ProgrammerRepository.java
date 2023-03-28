package com.ongbl.springdata.project01.lesson7.repos;

import com.ongbl.springdata.project01.lesson7.entities.Programmer;
import org.springframework.data.repository.CrudRepository;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {
}
