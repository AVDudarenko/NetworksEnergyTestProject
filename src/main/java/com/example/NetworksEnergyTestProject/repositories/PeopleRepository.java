package com.example.NetworksEnergyTestProject.repositories;

import com.example.NetworksEnergyTestProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
