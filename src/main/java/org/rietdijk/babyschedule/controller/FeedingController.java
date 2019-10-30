package org.rietdijk.babyschedule.controller;

import org.rietdijk.babyschedule.domain.Feeding;
import org.rietdijk.babyschedule.service.DayDescriptionService;
import org.rietdijk.babyschedule.service.FeedingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
public class FeedingController {
    @Autowired
    FeedingService feedingService;

    @Autowired
    DayDescriptionService dayDescriptionService;

    @DeleteMapping("/feeding/{id}")
    HttpStatus deleteFeeding(@PathVariable int id) {
        feedingService.deleteById(id);
        return HttpStatus.OK;
    }

    @PostMapping("/{id}/feeding")
    Feeding postFeeding(@PathVariable int id, @RequestBody Feeding feeding) {
        dayDescriptionService.findById(id).ifPresent(day -> feeding.setDay(day));
        return feedingService.save(feeding);
    }

    @PutMapping("/{id}/feeding")
    Feeding putFeeding(@PathVariable int id, @RequestBody Feeding feeding) {
        dayDescriptionService.findById(id).ifPresent(day -> feeding.setDay(day));
        return feedingService.save(feeding);
    }
}
