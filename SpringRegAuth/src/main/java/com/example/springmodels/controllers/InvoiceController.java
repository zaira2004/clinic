package com.example.springmodels.controllers;

import com.example.springmodels.models.Invoice;
import com.example.springmodels.repos.InvoiceRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/invoices/")
public class InvoiceController {
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceController(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @GetMapping
    public String getInvoices(Model model) {
        List<Invoice> invoices = invoiceRepository.findAll();
        model.addAttribute("invoices", invoices);
        return "all-invoices";
    }

    @GetMapping("/create-invoice")
    public String createInvoiceForm(Model model) {
        model.addAttribute("invoice", new Invoice());
        return "create-invoice";
    }

    @PostMapping("/create-invoice")
    public String createInvoice(@Valid @ModelAttribute("invoice") Invoice invoice, BindingResult result) {
        if (result.hasErrors()) {
            return "create-invoice";
        }
        invoiceRepository.save(invoice);
        return "redirect:/invoices/";
    }

    @GetMapping("/{id}")
    public String viewInvoice(@PathVariable("id") int id, Model model) {
        Invoice invoice = invoiceRepository.findById(id).orElse(null);
        if (invoice == null) {
            return "error-page";
        }
        model.addAttribute("invoice", invoice);
        return "show-invoice";
    }

    @GetMapping("/{id}/edit")
    public String editInvoiceForm(@PathVariable("id") int id, Model model) {
        Invoice invoice = invoiceRepository.findById(id).orElse(null);
        if (invoice == null) {
            return "error-page";
        }
        model.addAttribute("invoice", invoice);
        return "edit-invoice";
    }

    @PostMapping("/{id}/edit")
    public String updateInvoice(@PathVariable("id") int id, @Valid @ModelAttribute("invoice") Invoice invoice, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-invoice";
        }
        invoice.setId(id);
        invoiceRepository.save(invoice);
        return "redirect:/invoices/";
    }

    @GetMapping("/{id}/delete")
    public String deleteInvoice(@PathVariable("id") int id) {
        invoiceRepository.deleteById(id);
        return "redirect:/invoices/";
    }
}
