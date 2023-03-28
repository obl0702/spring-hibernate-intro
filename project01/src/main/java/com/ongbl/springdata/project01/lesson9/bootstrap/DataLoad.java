package com.ongbl.springdata.project01.lesson9.bootstrap;

import com.ongbl.springdata.project01.lesson9.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component("DataLoad2")
public class DataLoad implements CommandLineRunner {

    @Autowired
    BankAccountService service;

    @Override
    public void run(String... args) throws Exception {
        execute();
    }

    public void execute(){
        service.transfer(500);
    }
}
