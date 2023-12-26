package com.example.dental3.repository;

import com.example.dental3.models.Patient;
import com.example.dental3.models.PatientTreatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientTreatmentRepository extends JpaRepository<PatientTreatment, Integer> {
}

