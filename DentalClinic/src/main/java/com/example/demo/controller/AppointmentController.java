package com.example.demo.controller;

import com.example.demo.dao.AppointmentDAO;
import com.example.demo.dao.DentistDAO;
import com.example.demo.model.Appointment;
import com.example.demo.model.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentDAO appointmentDAO;

    @Autowired
    public AppointmentController(AppointmentDAO appointmentDAO){
        this.appointmentDAO = appointmentDAO;
    }

    @GetMapping
    public String index(Model model){
        List<Appointment> appointments = appointmentDAO.index();
        model.addAttribute("appointments", appointments);
        return "people/appointment/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        Appointment appointment = appointmentDAO.show(id);
        model.addAttribute("appointment", appointment);
        return "people/appointment/show";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        return "people/appointment/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Appointment appointment){
        appointmentDAO.addAppointment(appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") int id, Model model) {
        Appointment appointment = appointmentDAO.show(id);
        model.addAttribute("appointment", appointment);
        return "people/appointment/edit";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("id") int id, @ModelAttribute Appointment updatedAppointment){
        updatedAppointment.setId(id);
        appointmentDAO.update(updatedAppointment);
        return "redirect:/appointments"; // обратно к списку записей
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        Appointment appointment = appointmentDAO.show(id);
        appointmentDAO.delete(appointment);
        return "redirect:/appointments"; // назад
    }
}
