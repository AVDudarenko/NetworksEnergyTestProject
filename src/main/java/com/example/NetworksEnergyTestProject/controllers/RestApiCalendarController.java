package com.example.NetworksEnergyTestProject.controllers;

import com.example.NetworksEnergyTestProject.models.Event;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/events")
public class RestApiCalendarController {
    private List<Event> events = new ArrayList<>();

    public RestApiCalendarController() {
        events.addAll(List.of(
                new Event("23.05 Sleep", "Sasha"),
                new Event("23.05 Eat", "Sasha"),
                new Event("23.05 Drink", "Masha"),
                new Event("23.05 Dance", "Vasya")
        ));
    }


    @GetMapping
    Iterable<Event> getEvents() {
        return events;
    }

    @PostMapping
    Event postEvent(@RequestBody Event event) {
        events.add(event);
        return event;
    }

    @PutMapping("/{id}")
    ResponseEntity<Event> putEvent(@PathVariable String id,
                                   @RequestBody Event event) {
        int eventIndex = -1;
        for (Event c : events) {
            if (c.getId() == Integer.parseInt(id)) {
                eventIndex = events.indexOf(c);
                events.set(eventIndex, event);
            }
        }
        return (eventIndex == -1) ?
                new ResponseEntity<>(postEvent(event), HttpStatus.CREATED) :
                new ResponseEntity<>(event, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteEvent(@PathVariable String id) {
        events.removeIf(c -> c.getId() == Integer.parseInt(id));
    }
}
