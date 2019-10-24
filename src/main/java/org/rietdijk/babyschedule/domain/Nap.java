package org.rietdijk.babyschedule.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="nap")
public class Nap implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int napId;
    private String start;
    private String end;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dayId", insertable=false, updatable=false)
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
