package org.rietdijk.babyschedule.controller;

import org.rietdijk.babyschedule.domain.DayDescription;
import org.rietdijk.babyschedule.service.DayDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
public class DayDescriptionController {
    @Autowired
    DayDescriptionService dayDescriptionService;
    @GetMapping("/description")
    Iterable<DayDescription> getDayDescription(){
        return dayDescriptionService.findAll();

    }
    @GetMapping("/description/{id}")
    Optional<DayDescription> getDayDescriptionById(@PathVariable int id){
        return dayDescriptionService.findById(id);
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
