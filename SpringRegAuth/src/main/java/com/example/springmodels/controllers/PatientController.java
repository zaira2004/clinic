package com.example.springmodels.controllers;

import com.example.springmodels.models.Patient;
import com.example.springmodels.repos.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patients/")
public class PatientController {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping
    public String getPatients(Model model) {
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients", patients);
        return "all-patients";
    }

    @GetMapping("/create-patient")
    public String createPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "create-patient";
    }

    @PostMapping("/create-patient")
    public String createPatient(@Valid @ModelAttribute("patient") Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return "create-patient";
        }
        patientRepository.save(patient);
        return "redirect:/patients/";
    }

    @GetMapping("/{id}")
    public String viewPatient(@PathVariable("id") int id, Model model) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient == null) {
            return "error-page";
        }
        model.addAttribute("patient", patient);
        return "show-patient";
    }

    @PostMapping("/{id}/edit")
    public String updatePatient(@PathVariable("id") int id, @Valid @ModelAttribute("patient") Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-patient";
        }
        patient.setId(id);
        patientRepository.save(patient);
        return "redirect:/patients/";
    }

    @GetMapping("/{id}/edit")
    public String editPatientForm(@PathVariable("id") int id, Model model) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient == null) {
            return "error-page";
        }
        model.addAttribute("patient", patient);
        return "edit-patient";
    }

    @GetMapping("/{id}/delete")
    public String deletePatient(@PathVariable("id") int id) {
        patientRepository.deleteById(id);
        return "redirect:/patients/";
    }
}
