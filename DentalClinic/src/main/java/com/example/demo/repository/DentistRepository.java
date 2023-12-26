package com.example.demo.repository;

import com.example.demo.model.Dentist;
import org.springframework.data.repository.ListCrudRepository;

public interface DentistRepository extends ListCrudRepository<Dentist, Long> {
}
