package co.com.sofka.calendar.controllers;


import co.com.sofka.calendar.model.ProgramDate;
import co.com.sofka.calendar.repositories.ProgramDateRepository;
import co.com.sofka.calendar.services.ProgramDateService;
import co.com.sofka.calendar.services.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin("*")
@RequestMapping("/scheduler")
public class SchedulerController {

    @Autowired
    SchedulerService service;

    @Autowired
    ProgramDateService serviceDate;


    @GetMapping("/generate/{date}/{id}")
    private Flux<ProgramDate> generateSchedule(@PathVariable String date, @PathVariable String id ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate local = LocalDate.parse(date, formatter);
        return service.generateCalendar(id, local);
    }

    @GetMapping("/getAll")
    private Flux<ProgramDate> getAll() {
        return serviceDate.getAll();
    }

}
