package org.rietdijk.babyschedule.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String start;
    String amount;
    String soort="Eten";
    @JsonBackReference
    @ManyToOne
    DayDescription day;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public DayDescription getDay() {
        return day;
    }

    public void setDay(DayDescription day) {
        this.day = day;
    }
}
