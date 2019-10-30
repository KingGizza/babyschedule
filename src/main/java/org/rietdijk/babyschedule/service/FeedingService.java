package org.rietdijk.babyschedule.service;

import org.rietdijk.babyschedule.domain.Feeding;
import org.springframework.data.repository.CrudRepository;

public interface FeedingService extends CrudRepository<Feeding, Integer> {
}
