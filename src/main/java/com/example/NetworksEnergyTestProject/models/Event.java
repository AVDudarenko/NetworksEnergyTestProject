package com.example.NetworksEnergyTestProject.models;

import java.util.UUID;

public class Event {

    private final String id;

    private String event;

    public Event(String id, String event) {
        this.id = id;
        this.event = event;
    }

    public Event(String event) {
        this(UUID.randomUUID().toString(), event);
    }

    public String getId() {
        return id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
