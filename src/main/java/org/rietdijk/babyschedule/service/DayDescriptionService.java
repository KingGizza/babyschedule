package org.rietdijk.babyschedule.service;

import org.rietdijk.babyschedule.domain.DayDescription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DayDescriptionService extends CrudRepository<DayDescription, Integer> {
    @Query("from DayDescription where date = ?1")
    DayDescription findByDate(String date);
}
