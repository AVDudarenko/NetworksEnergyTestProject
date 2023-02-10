package com.example.NetworksEnergyTestProject.controllers;

import com.example.NetworksEnergyTestProject.models.Event;
import com.example.NetworksEnergyTestProject.repositories.EventRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class RestApiCalendarController {

    private final EventRepository eventRepository;

    public RestApiCalendarController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;

        this.eventRepository.saveAll(List.of(new Event("23.05 Sleep", "Sasha"),
                new Event("23.05 Eat", "Sasha"),
                new Event("23.05 Drink", "Masha"),
                new Event("23.05 Dance", "Vasya")));
    }

    @GetMapping
    Iterable<Event> getEvents() {
        return eventRepository.findAll();
    }

    @PostMapping
    Event postEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @PutMapping("/{id}")
    ResponseEntity<Event> putEvent(@PathVariable Long id,
                                   @RequestBody Event event) {
        return (!eventRepository.existsById(id))
                ? new ResponseEntity<>(eventRepository.save(event),
                HttpStatus.CREATED)
                : new ResponseEntity<>(eventRepository.save(event), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteEvent(@PathVariable Long id) {
        eventRepository.deleteById(id);
    }
}
