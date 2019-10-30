package org.rietdijk.babyschedule;

import org.rietdijk.babyschedule.domain.Nap;

import java.time.LocalTime;
import java.util.Comparator;

public class SortByStart implements Comparator<Nap> {
    public int compare(Nap a, Nap b) {
        LocalTime timeA = LocalTime.parse(a.getStart());
        LocalTime timeB = LocalTime.parse(b.getStart());
        if (timeA.isBefore(timeB)) {
            return -1;
        } else {
            return 1;
        }
    }
}
