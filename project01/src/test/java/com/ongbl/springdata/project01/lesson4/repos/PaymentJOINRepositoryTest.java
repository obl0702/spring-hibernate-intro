package com.ongbl.springdata.project01.lesson4.repos;

import com.ongbl.springdata.project01.lesson4.entities.JOINCheck;
import com.ongbl.springdata.project01.lesson4.entities.JOINCreditCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PaymentJOINRepositoryTest {

    @Autowired
    private PaymentJOINRepository paymentRepository;

    @BeforeEach
    void setUp() {
    }

    @Transactional
    @Test
    @Rollback(false)
    public void createPayment(){
        JOINCreditCard cc = new JOINCreditCard();
        cc.setId(567);
        cc.setAmount(1000);
        cc.setCardnumber("123 456");
        paymentRepository.save(cc);

        //List<CreditCard> ccs = (CreditCard) paymentRepository.findAll();
    }

    @Transactional
    @Test
    @Rollback(false)
    public void createCheckPayment(){
        JOINCheck ch = new JOINCheck();
        ch.setId(234);
        ch.setAmount(2000);
        ch.setChecknumber("4575455");
        paymentRepository.save(ch);

        //List<CreditCard> ccs = (CreditCard) paymentRepository.findAll();
    }
}