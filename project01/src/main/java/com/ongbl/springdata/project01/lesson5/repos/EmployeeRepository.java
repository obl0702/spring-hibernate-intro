package com.ongbl.springdata.project01.lesson5.repos;

import com.ongbl.springdata.project01.lesson5.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
