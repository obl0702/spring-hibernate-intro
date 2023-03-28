package com.ongbl.springdata.project01.lesson9.services;

import com.ongbl.springdata.project01.lesson9.entities.BankAccount;
import com.ongbl.springdata.project01.lesson9.repos.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService2Impl implements  BankAccountService2{

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public void transfer1(int amount) {
        System.out.println("transfer 1 started");

        BankAccount trumpAccount = bankAccountRepository.findById(2).get();
        System.out.println(trumpAccount);
        BankAccount obamaAccount = bankAccountRepository.findById(1).get();
        System.out.println(obamaAccount);

        obamaAccount.setBal(obamaAccount.getBal()-amount);
        bankAccountRepository.save(obamaAccount);
        System.out.println("transfer 1 end");
    }
}
