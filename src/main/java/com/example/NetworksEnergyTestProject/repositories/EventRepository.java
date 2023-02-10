package com.example.NetworksEnergyTestProject.repositories;


import com.example.NetworksEnergyTestProject.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
