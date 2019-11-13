package org.rietdijk.babyschedule.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Feeding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String start;
    int amount;
    String soort="Drinken";
    @JsonBackReference
    @ManyToOne
    DayDescription day;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DayDescription getDay() {
        return day;
    }

    public void setDay(DayDescription day) {
        this.day = day;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }
}
