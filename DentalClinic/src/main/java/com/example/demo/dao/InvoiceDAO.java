package com.example.demo.dao;
import com.example.demo.model.Dentist;
import com.example.demo.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class InvoiceDAO {
    private static int invoiceCount = 0;
    private List<Invoice> invoices;

    {
        invoices = new ArrayList<>();

        addInvoice(new Invoice(1, "Артемов Иван Кириллович", 25000, true));
        addInvoice(new Invoice(2, "Завьялова Валерия Анатольевна", 3000, false));
        addInvoice(new Invoice(3, "Тарасенко Виктор Львовович", 4500, false));
        addInvoice(new Invoice(4, "Шубова Анна Федеоровна", 3800, true));
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void addInvoice(Invoice invoice) {
        invoice.setId(++invoiceCount);
        invoices.add(invoice);
    }

    public int getKeyList(Invoice el) {
        int key = -1;
        for (int i = 0; i < invoices.size(); i++) {
            if (el.getId() == invoices.get(i).getId()) {
                key = i;
                break;
            }
        }
        return key;
    }

    public Invoice show(int id) {
        return invoices.stream()
                .filter(invoice -> invoice.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void update(Invoice updatedInvoice) {
        int key = getKeyList(updatedInvoice);
        if (key != -1) {
            invoices.set(key, updatedInvoice);
        }
    }

    public void delete(Invoice invoice) {
        invoices.remove(invoice);
    }
}
