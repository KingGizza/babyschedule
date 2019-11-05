package org.rietdijk.babyschedule.controller;

import org.rietdijk.babyschedule.SortByStart;
import org.rietdijk.babyschedule.SortByTime;
import org.rietdijk.babyschedule.domain.DayDescription;
import org.rietdijk.babyschedule.service.DayDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;

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
        Collections.sort(dayDescription.getFeedings(), new SortByTime());
        return dayDescription;
        }

    @PostMapping("/description")
    DayDescription postDaydescription(@Valid @RequestBody DayDescription dayDescription){
        dayDescription.setDate(dayDescription.getDate().substring(0,10));
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
