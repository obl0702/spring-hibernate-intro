package com.ongbl.springdata.project01.lesson8.repos;

import com.ongbl.springdata.project01.lesson8.entities.License;
import org.springframework.data.repository.CrudRepository;

public interface LicenseRepository extends CrudRepository<License, Long> {
}
