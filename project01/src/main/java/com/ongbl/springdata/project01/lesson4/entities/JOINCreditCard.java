package com.ongbl.springdata.project01.lesson4.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "joincard")
@PrimaryKeyJoinColumn(name = "id")
public class JOINCreditCard extends JOINPayment {

    private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
