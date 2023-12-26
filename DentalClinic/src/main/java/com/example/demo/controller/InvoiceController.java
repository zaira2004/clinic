package com.example.demo.controller;

import com.example.demo.dao.DentistDAO;
import com.example.demo.dao.InvoiceDAO;
import com.example.demo.model.Dentist;
import com.example.demo.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {
    private final InvoiceDAO invoiceDAO;

    @Autowired
    public InvoiceController(InvoiceDAO invoiceDAO) {
        this.invoiceDAO = invoiceDAO;
    }

    @GetMapping
    public String index(Model model) {
        List<Invoice> invoices = invoiceDAO.getInvoices();
        model.addAttribute("invoices", invoices);
        return "people/invoice/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Invoice invoice = invoiceDAO.show(id);
        model.addAttribute("invoice", invoice);
        return "people/invoice/show";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        return "people/invoice/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Invoice invoice){
        invoiceDAO.addInvoice(invoice);
        return "redirect:/invoices";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") int id, Model model) {
        Invoice invoice = invoiceDAO.show(id);
        model.addAttribute("invoice", invoice);
        return "people/invoice/edit";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("id") int id, @ModelAttribute
    Invoice updatedInvoice){
        updatedInvoice.setId(id);
        invoiceDAO.update(updatedInvoice);
        return "redirect:/invoices";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        Invoice invoice = invoiceDAO.show(id);
        invoiceDAO.delete(invoice);
        return "redirect:/invoices";
    }
}
