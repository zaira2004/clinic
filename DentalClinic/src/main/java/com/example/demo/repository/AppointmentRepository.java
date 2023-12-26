package com.example.demo.repository;

import com.example.demo.model.Appointment;
import org.springframework.data.repository.ListCrudRepository;

public interface AppointmentRepository extends ListCrudRepository<Appointment, Long> {
}
