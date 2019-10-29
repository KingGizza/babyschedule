package org.rietdijk.babyschedule.domain;

import javax.persistence.*;

@Entity
public class Feeding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int feedingId;
    String time;
    int amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dayId", insertable=false, updatable=false)
    public int getFeedingId() {
        return feedingId;
    }

    public void setFeedingId(int feedingId) {
        this.feedingId = feedingId;
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
