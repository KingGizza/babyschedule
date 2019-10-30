package org.rietdijk.babyschedule.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Feeding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int feedingId;
    String time;
    int amount;
    @JsonBackReference
    @ManyToOne
    DayDescription day;
    public int getFeedingId() {
        return feedingId;
    }

    public void setFeedingId(int feedingId) {
        this.feedingId = feedingId;
    }

    public DayDescription getDay() {
        return day;
    }

    public void setDay(DayDescription day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
