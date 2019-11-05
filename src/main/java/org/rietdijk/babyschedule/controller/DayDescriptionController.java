package org.rietdijk.babyschedule.controller;

import org.rietdijk.babyschedule.SortByStart;
import org.rietdijk.babyschedule.SortByTime;
import org.rietdijk.babyschedule.domain.DayDescription;
import org.rietdijk.babyschedule.service.DayDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
public class DayDescriptionController {
    @Autowired
    DayDescriptionService dayDescriptionService;
    DayDescription dayDescription;

    @GetMapping("/description")
    Iterable<DayDescription> getDayDescription() {
        return dayDescriptionService.findAll();
    }

    @GetMapping("/day/{date}")
    DayDescription getDayDescriptionByDate(@PathVariable String date) {
        DayDescription day = dayDescriptionService.findByDate(date);
        if (day != null) {
            return day;
        } else {
            DayDescription newDate = new DayDescription(date);
            return postDaydescription(newDate);
        }
    }

    @GetMapping("/detail/{id}")
    DayDescription getDayDescriptionById(@PathVariable int id) {
        dayDescriptionService.findById(id).ifPresent((day) -> this.dayDescription = day);
        dayDescription.getNaps().sort(new SortByStart());
        dayDescription.getFeedings().sort(new SortByTime());
        return dayDescription;
    }

    @PostMapping("/description")
    DayDescription postDaydescription(@Valid @RequestBody DayDescription dayDescription) {
        Iterable<DayDescription> descriptionList = getDayDescription();
        for (DayDescription description : descriptionList) {
            if (description.getDate().equals(dayDescription.getDate())) {
                dayDescription.setId(description.getId());
            }
        }
        return dayDescriptionService.save(dayDescription);
    }

    @PutMapping("/description")
    DayDescription updateDaydescription(@RequestBody DayDescription dayDescription) {
        return dayDescriptionService.save(dayDescription);
    }

    @DeleteMapping("/description/{id}")
    void deleteDescription(@PathVariable int id) {
        dayDescriptionService.deleteById(id);
    }
}
