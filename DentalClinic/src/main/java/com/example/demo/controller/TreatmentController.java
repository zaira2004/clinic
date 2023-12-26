package com.example.demo.controller;

import com.example.demo.dao.TreatmentDAO;
import com.example.demo.model.Dentist;
import com.example.demo.model.Treatment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/treatments")
public class TreatmentController {
    private final TreatmentDAO treatmentDAO;

    @Autowired
    public TreatmentController(TreatmentDAO treatmentDAO){
        this.treatmentDAO = treatmentDAO;
    }

    @GetMapping
    public String index(Model model){
        List<Treatment> treatments = treatmentDAO.index();
        model.addAttribute("treatments", treatments);
        return "people/treatment/index"; //
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        Treatment treatment = treatmentDAO.show(id);
        model.addAttribute("treatment", treatment);
        return "people/treatment/show"; //

    }
    @GetMapping("/add")
    public String addForm(Model model){
        return "people/treatment/add";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute Treatment treatment){
        treatmentDAO.addTreatment(treatment);
        return "redirect:/treatments";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") int id, Model model) {
        Treatment treatment = treatmentDAO.show(id);
        model.addAttribute("treatment", treatment);
        return "people/treatment/edit";
    }
    @PostMapping("/edit")
    public String edit(@RequestParam("id") int id, @ModelAttribute
    Treatment updatedDentist){
        updatedDentist.setId(id);
        treatmentDAO.update(updatedDentist);
        return "redirect:/treatments";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        Treatment treatment = treatmentDAO.show(id);
        treatmentDAO.delete(treatment);
        return "redirect:/treatments";
    }

}
