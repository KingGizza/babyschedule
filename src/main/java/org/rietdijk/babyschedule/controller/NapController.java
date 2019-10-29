package org.rietdijk.babyschedule.controller;

import org.rietdijk.babyschedule.service.NapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
public class NapController {
    @Autowired
    NapService napService;

    @DeleteMapping("/nap/{id}")
    void deleteNap(@PathVariable int id) {
        napService.deleteById(id);
    }
}
