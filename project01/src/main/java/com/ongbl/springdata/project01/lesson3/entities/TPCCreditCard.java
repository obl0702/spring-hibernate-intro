package com.ongbl.springdata.project01.lesson3.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tpccard")
public class TPCCreditCard extends TPCPayment {

    private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
