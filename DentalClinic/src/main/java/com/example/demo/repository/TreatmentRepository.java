package com.example.demo.repository;

import com.example.demo.model.Treatment;
import org.springframework.data.repository.ListCrudRepository;

public interface TreatmentRepository extends ListCrudRepository<Treatment, Long> {
}