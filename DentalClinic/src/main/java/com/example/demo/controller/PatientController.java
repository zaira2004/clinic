package com.example.demo.controller;

import com.example.demo.dao.PatientDAO;
import com.example.demo.model.Appointment;
import com.example.demo.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/people")
public class PatientController {

    private PatientDAO _personDAO;

    @Autowired
    public PatientController(PatientDAO personDAO){
        _personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", _personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,Model model){
        // Вывод определенного пользователя
        model.addAttribute("person", _personDAO.show(id));
        return "people/show";
    }
    @GetMapping("/add")
    public String addForm(Model model){
        return
                "people/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Patient patient){
        _personDAO.addPatient(patient);
        return "redirect:/people";
    }
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") int id, Model model) {
        Patient appointment = _personDAO.show(id);
        model.addAttribute("people", appointment);
        return "people/edit";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("id") int id, @ModelAttribute Patient updatedAppointment){
        updatedAppointment.setId(id);
        _personDAO.update(updatedAppointment);
        return "redirect:/people"; // обратно к peoples
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        Patient appointment = _personDAO.show(id);
        _personDAO.delete(appointment);
        return "redirect:/people"; // назад
    }
}
