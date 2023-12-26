package com.example.demo.repository;

import com.example.demo.model.Invoice;
import org.springframework.data.repository.ListCrudRepository;

public interface InvoiceRepository extends ListCrudRepository<Invoice, Long> {
}

