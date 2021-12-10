package co.com.sofka.calendar.controllers;


import co.com.sofka.calendar.model.ProgramDate;
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

    @GetMapping("/generate/{date}/{id}")
    private Flux<ProgramDate> generateSchedule(@PathVariable String date, @PathVariable String id ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate local = LocalDate.parse(date, formatter);
        return service.generateCalendar(id, local);
    }

    @GetMapping("/test")
    private Flux<ProgramDate> test() {
        return service.generateCalendar("61b3d0e477be7ce9d742674e", LocalDate.of(2021,11,12));
    }

}
