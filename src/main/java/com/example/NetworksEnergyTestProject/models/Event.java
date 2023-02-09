package com.example.NetworksEnergyTestProject.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Events")
public class Event {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "author")
    private String authorOfEvent;
    @Column(name = "event")
    private String event;

    public Event(String event, String authorOfEvent) {
        this.event = event;
        this.authorOfEvent = authorOfEvent;
    }

    public Event() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getAuthorOfEvent() {
        return authorOfEvent;
    }

    public void setAuthorOfEvent(String authorOfEvent) {
        this.authorOfEvent = authorOfEvent;
    }
}
