package com.ongbl.springdata.project01.lesson3.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tpcbankcheck")
public class TPCCheck extends TPCPayment {

    private String checknumber;

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}
