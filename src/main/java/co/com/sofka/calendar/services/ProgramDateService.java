package co.com.sofka.calendar.services;

import co.com.sofka.calendar.model.ProgramDate;
import co.com.sofka.calendar.repositories.ProgramDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProgramDateService {

    @Autowired
    ProgramDateRepository repository;

    public Flux<ProgramDate> saveAll(Flux<ProgramDate> program){
        return repository.saveAll(program);
    }

    public Flux<ProgramDate> getAll(){
        return repository.findAll();
    }
}
