package com.example.dental3.repository;

import com.example.dental3.models.Appointment;
import com.example.dental3.models.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {
}
