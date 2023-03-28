package com.ongbl.springdata.project01.lesson9.services;


import com.ongbl.springdata.project01.lesson9.entities.BankAccount;
import com.ongbl.springdata.project01.lesson9.repos.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountServiceImpl implements BankAccountService{

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private BankAccountService2 service2;

    @Autowired
    private BankAccountService3 service3;

    @Autowired
    private BankAccountService4 service4;

    @Override
    @Transactional
    public void transfer(int amount) {
        service2.transfer1(amount);
        try{
            service3.transfer2(amount);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        service4.transfer3();
    }

}
