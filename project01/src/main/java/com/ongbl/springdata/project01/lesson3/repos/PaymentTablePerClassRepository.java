package com.ongbl.springdata.project01.lesson3.repos;

import com.ongbl.springdata.project01.lesson3.entities.TPCPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTablePerClassRepository extends JpaRepository<TPCPayment, Integer> {
}
