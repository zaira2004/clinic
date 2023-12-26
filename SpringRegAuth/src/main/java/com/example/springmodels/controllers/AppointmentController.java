package com.example.springmodels.controllers;

import com.example.springmodels.models.Appointment;
import com.example.springmodels.repos.AppointmentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/appointments/")
public class AppointmentController {
    private final AppointmentRepository repositoryClass;

    @Autowired
    public AppointmentController(AppointmentRepository repositoryClass) {
        this.repositoryClass = repositoryClass;
    }

    @GetMapping
    public String getAppointments(@RequestParam(name = "description", defaultValue = "") String description, Model model) {
        List<Appointment> appointments;

        if (description.isEmpty()) {
            appointments = repositoryClass.findAll();
        } else {
            appointments = repositoryClass.findByDescription(description);
        }

        model.addAttribute("appointments", appointments);
        return "all-appointments";
    }

    @PostMapping
    public String postAppointment(@RequestParam(name = "description", defaultValue = "") String description, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("description", description);
        return "redirect:/appointments/";
    }

    @GetMapping("/create-appointment")
    public String createAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "create-appointment";
    }

    @PostMapping("/create-appointment")
    public String createAppointment(@Valid @ModelAttribute("appointment") Appointment appointment, BindingResult result) {
        if (result.hasErrors()) {
            return "create-appointment";
        }
        repositoryClass.save(appointment);
        return "redirect:/appointments/"; // Добавьте слеш после "appointments"
    }

    @GetMapping("/{id}")
    public String viewAppointment(@PathVariable("id") int id, Model model) {
        Appointment appointment = repositoryClass.findById(id).orElse(null);
        if (appointment == null) {
            // Вернуть страницу с сообщением об ошибке
            return "error-page";
        }
        model.addAttribute("appointment", appointment);
        return "show-appointment";
    }

    @PostMapping("/{id}")
    public String updateAppointment(@PathVariable("id") int id, @Valid @ModelAttribute("appointment") Appointment appointment, BindingResult result) {
        if (result.hasErrors()) {
            return "show-appointment";
        }
        appointment.setId(id); // Установка ID для обновления
        repositoryClass.save(appointment);
        return "redirect:/appointments/";
    }

    @GetMapping("/{id}/edit")
    public String editAppointmentForm(@PathVariable("id") int id, Model model) {
        Appointment appointment = repositoryClass.findById(id).orElse(null);
        if (appointment == null) {
            // Вернуть страницу с сообщением об ошибке
            return "error-page";
        }
        model.addAttribute("appointment", appointment);
        return "edit-appointment";
    }

    @GetMapping("/{id}/delete")
    public String deleteAppointment(@PathVariable("id") int id) {
        repositoryClass.deleteById(id);
        return "redirect:/appointments/";
    }
}
