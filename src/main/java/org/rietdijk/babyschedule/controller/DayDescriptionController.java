package org.rietdijk.babyschedule.controller;

import org.rietdijk.babyschedule.SortByStart;
import org.rietdijk.babyschedule.domain.DayDescription;
import org.rietdijk.babyschedule.domain.Nap;
import org.rietdijk.babyschedule.service.DayDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
public class DayDescriptionController {
    @Autowired
    DayDescriptionService dayDescriptionService;
    DayDescription dayDescription;

    @GetMapping("/description")
    Iterable<DayDescription> getDayDescription(){
        return dayDescriptionService.findAll();

    }
    @GetMapping("/description/{id}")
    DayDescription getDayDescriptionById(@PathVariable int id){
        dayDescriptionService.findById(id).ifPresent((day) -> this.dayDescription = day);
        Collections.sort(dayDescription.getNaps(), new SortByStart());
        return dayDescription;
        }

    @PostMapping("/description")
    DayDescription postDaydescription(@RequestBody DayDescription dayDescription){
        return dayDescriptionService.save(dayDescription);
    }

    @PutMapping("/description")
    DayDescription updateDaydescription(@RequestBody DayDescription dayDescription){
        return dayDescriptionService.save(dayDescription);
    }

    @DeleteMapping("/description/{id}")
    void deleteDescription(@PathVariable int id){
        dayDescriptionService.deleteById(id);
    }
}
