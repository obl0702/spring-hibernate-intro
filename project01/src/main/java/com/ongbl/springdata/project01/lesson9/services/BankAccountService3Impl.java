package com.ongbl.springdata.project01.lesson9.services;

import com.ongbl.springdata.project01.lesson9.entities.BankAccount;
import com.ongbl.springdata.project01.lesson9.repos.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountService3Impl implements BankAccountService3{

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT)
    public void transfer2(int amount) {
        System.out.println("transfer 2 started");

        BankAccount trumpAccount = bankAccountRepository.findById(2).get();
        System.out.println(trumpAccount);
        BankAccount obamaAccount = bankAccountRepository.findById(1).get();
        System.out.println(obamaAccount);


        trumpAccount.setBal(trumpAccount.getBal()+amount);
        bankAccountRepository.save(trumpAccount);
        System.out.println("transfer 2 end");

        if(true){
            throw new RuntimeException();
        }
    }
}
