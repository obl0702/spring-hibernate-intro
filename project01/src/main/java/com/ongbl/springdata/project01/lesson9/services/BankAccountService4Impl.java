package com.ongbl.springdata.project01.lesson9.services;

import com.ongbl.springdata.project01.lesson9.entities.BankAccount;
import com.ongbl.springdata.project01.lesson9.repos.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService4Impl implements BankAccountService4{

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public void transfer3() {
        System.out.println("transfer 3 started");
        BankAccount obamaAccount = bankAccountRepository.findById(1).get();
        System.out.println(obamaAccount);
        obamaAccount.setBal(obamaAccount.getBal()+10);
        bankAccountRepository.save(obamaAccount);

        BankAccount trumpAccount = bankAccountRepository.findById(2).get();
        System.out.println(trumpAccount);
        trumpAccount.setBal(trumpAccount.getBal()+10);
        bankAccountRepository.save(trumpAccount);
        System.out.println("transfer 3 end");
    }
}
