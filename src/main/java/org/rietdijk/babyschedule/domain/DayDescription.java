package org.rietdijk.babyschedule.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Day")
public class DayDescription implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String date;
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @OrderColumn(name="start")
    private Nap [] naps;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @OrderColumn(name="time")
    private Feeding[] feedings;

    public Nap[] getNaps() {
        return naps;
    }

    public void setNaps(Nap[] naps) {
        this.naps = naps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Feeding[] getFeedings() {
        return feedings;
    }

    public void setFeedings(Feeding[] feedings) {
        this.feedings = feedings;
    }
}
