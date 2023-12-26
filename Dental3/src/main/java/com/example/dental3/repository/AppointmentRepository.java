package com.example.dental3.repository;

import com.example.dental3.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository   extends JpaRepository<Appointment, Integer> {
        List<Appointment> findByDescription(String descripton);
}