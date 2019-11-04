package org.rietdijk.babyschedule.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "nap")
public class Nap implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int napId;
    private String start;
    private String end;

    @JsonBackReference
    @ManyToOne
    DayDescription day;

    public DayDescription getDay() {
        return day;
    }

    public void setDay(DayDescription day) {
        this.day = day;
    }

    public int getNapId() {
        return napId;
    }

    public void setNapId(int napId) {
        this.napId = napId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

}
