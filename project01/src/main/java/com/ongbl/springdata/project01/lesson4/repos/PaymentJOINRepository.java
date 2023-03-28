package com.ongbl.springdata.project01.lesson4.repos;

import com.ongbl.springdata.project01.lesson4.entities.JOINPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJOINRepository extends JpaRepository<JOINPayment, Integer> {
}
