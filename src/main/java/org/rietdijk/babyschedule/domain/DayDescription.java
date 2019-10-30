package org.rietdijk.babyschedule.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Day")
public class DayDescription implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String date;
    @OneToMany(mappedBy ="day")
    @JsonManagedReference
    private List<Nap> naps;

    @OneToMany(mappedBy ="day")
    @JsonManagedReference
    private List<Feeding> feedings;

    public List<Nap> getNaps() {
        return naps;
    }

    public void setNaps(List<Nap> naps) {
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

    public List<Feeding> getFeedings() {
        return feedings;
    }

    public void setFeedings(List<Feeding> feedings) {
        this.feedings = feedings;
    }
}
