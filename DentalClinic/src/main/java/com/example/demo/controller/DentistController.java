package com.example.demo.controller;

import com.example.demo.dao.DentistDAO;
import com.example.demo.model.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dentists")
public class DentistController {
    private final DentistDAO dentistDAO;

    @Autowired
    public DentistController(DentistDAO dentistDAO){
        this.dentistDAO = dentistDAO;
    }

    @GetMapping
    public String index(Model model){
        List<Dentist> dentists = dentistDAO.index();
        model.addAttribute("dentists", dentists);
        return "people/dentist/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        Dentist dentist = dentistDAO.show(id);
        model.addAttribute("dentist", dentist);
        return "people/dentist/show";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        return "people/dentist/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Dentist dentist){
        dentistDAO.addDentist(dentist);
        return "redirect:/dentists";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") int id, Model model) {
        Dentist dentist = dentistDAO.show(id);
        model.addAttribute("dentist", dentist);
        return "people/dentist/edit";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("id") int id, @ModelAttribute
    Dentist updatedDentist){
        updatedDentist.setId(id);
        dentistDAO.update(updatedDentist);
        return "redirect:/dentists";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        Dentist dentist = dentistDAO.show(id);
        dentistDAO.delete(dentist);
        return "redirect:/dentists";
    }
}
