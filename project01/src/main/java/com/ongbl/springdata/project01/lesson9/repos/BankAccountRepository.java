package com.ongbl.springdata.project01.lesson9.repos;

import com.ongbl.springdata.project01.lesson9.entities.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {
}
