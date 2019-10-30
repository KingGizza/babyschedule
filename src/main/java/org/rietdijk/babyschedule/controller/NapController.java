package org.rietdijk.babyschedule.controller;

import org.rietdijk.babyschedule.domain.DayDescription;
import org.rietdijk.babyschedule.domain.Nap;
import org.rietdijk.babyschedule.service.DayDescriptionService;
import org.rietdijk.babyschedule.service.NapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
public class NapController {
    @Autowired
    NapService napService;

    @Autowired
    DayDescriptionService dayDescriptionService;


    @DeleteMapping("/nap/{id}")
    HttpStatus deleteNap(@PathVariable int id) {
        napService.deleteById(id);
        return HttpStatus.OK;
    }

    @PostMapping("/{id}/nap")
    Nap postNap(@PathVariable int id, @RequestBody Nap nap) {
        dayDescriptionService.findById(id).ifPresent(day -> nap.setDay(day));
        return napService.save(nap);
    }

    @PutMapping("/{id}/nap")
    Nap putNap(@PathVariable int id, @RequestBody Nap nap) {
        dayDescriptionService.findById(id).ifPresent(day -> nap.setDay(day));
        return napService.save(nap);
    }
}
