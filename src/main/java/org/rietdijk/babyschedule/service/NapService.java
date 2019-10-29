package org.rietdijk.babyschedule.service;

import org.rietdijk.babyschedule.domain.Nap;
import org.springframework.data.repository.CrudRepository;

public interface NapService extends CrudRepository<Nap, Integer> {
}
