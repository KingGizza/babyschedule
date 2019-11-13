package org.rietdijk.babyschedule.service;

import org.rietdijk.babyschedule.domain.Meal;
import org.springframework.data.repository.CrudRepository;

public interface MealService extends CrudRepository<Meal, Integer> {
}
