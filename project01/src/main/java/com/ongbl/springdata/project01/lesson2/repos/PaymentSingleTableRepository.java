package com.ongbl.springdata.project01.lesson2.repos;

import com.ongbl.springdata.project01.lesson2.entities.STPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentSingleTableRepository extends JpaRepository<STPayment, Integer> {
}
