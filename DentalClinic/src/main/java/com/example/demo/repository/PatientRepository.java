package com.example.demo.repository;

import com.example.demo.model.Patient;
import org.springframework.data.repository.ListCrudRepository;

public interface PatientRepository extends ListCrudRepository<Patient, Long> {
}