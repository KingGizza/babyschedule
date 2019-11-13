package org.rietdijk.babyschedule.controller;

import org.rietdijk.babyschedule.domain.Meal;
import org.rietdijk.babyschedule.service.DayDescriptionService;
import org.rietdijk.babyschedule.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
public class MealController {
    @Autowired
    MealService mealService;

    @Autowired
    DayDescriptionService dayDescriptionService;


    @DeleteMapping("/meal/{id}")
    HttpStatus deleteMeal(@PathVariable int id) {
        mealService.deleteById(id);
        return HttpStatus.OK;
    }

    @PostMapping("/{id}/meal")
    Meal postMeal(@PathVariable int id, @RequestBody Meal meal) {
        dayDescriptionService.findById(id).ifPresent(day -> meal.setDay(day));
        return mealService.save(meal);
    }

    @PutMapping("/{id}/meal")
    Meal putMeal(@PathVariable int id, @RequestBody Meal meal) {
        dayDescriptionService.findById(id).ifPresent(day -> meal.setDay(day));
        return mealService.save(meal);
    }
}