package org.rietdijk.babyschedule;

import org.rietdijk.babyschedule.domain.Feeding;

import java.time.LocalTime;
import java.util.Comparator;

public class SortByTime implements Comparator<Feeding> {
    public int compare(Feeding a, Feeding b){
        LocalTime timeA = LocalTime.parse(a.getTime());
        LocalTime timeB = LocalTime.parse(b.getTime());
        if (timeA.isBefore(timeB)) {
            return -1;
        } else {
            return 1;
        }
    }
}
