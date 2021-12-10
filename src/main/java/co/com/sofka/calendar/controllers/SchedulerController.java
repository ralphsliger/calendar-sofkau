package co.com.sofka.calendar.controllers;


import co.com.sofka.calendar.model.ProgramDate;
import co.com.sofka.calendar.services.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("api/v1/scheduler")
public class SchedulerController {

    @Autowired
    SchedulerService service;

    @GetMapping("/generateSchedule/{id}/{date}")
    private Flux<ProgramDate> generateSchedule(@PathVariable String id, @PathVariable String iDate ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate local = LocalDate.parse(iDate, formatter);
        return service.generateCalendar(id, local);
    }

}
