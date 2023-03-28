package com.ongbl.springdata.project01.lesson4.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "joinbankcheck")
@PrimaryKeyJoinColumn(name = "id")
public class JOINCheck extends JOINPayment {

    private String checknumber;

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}
