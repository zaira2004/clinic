package com.example.demo.dao;

import com.example.demo.model.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class PatientDAO {
    private static int PEOPLE_COUNT = 0;
    private List<Patient> people;

    {
        people = new ArrayList<>();

        addPatient(new Patient(1, "Артемов Иван Кириллович", 25, "Муж", "ул. Домодедовская, д.23"));
        addPatient(new Patient(2, "Завьялова Валерия Анатольевна", 30, "Жен", "ул. Петровского, д.32"));
        addPatient(new Patient(3, "Тарасенко Виктор Львовович", 40, "Муж", "проспект вернадского, д.5"));
        addPatient(new Patient(4, "Шубова Анна Федеоровна", 35, "Жен", "ул. малышева, д.19"));
    }

    public void addPatient(Patient patient) {
        patient.setId(++PEOPLE_COUNT);
        people.add(patient);
    }

    public List<Patient> index() {
        return people;
    }

    public Patient show(int id) {
        return people.stream()
                .filter(personModel -> personModel.getId() == id)
                .findAny()
                .orElse(null);
    }

    public List<Patient> getPatients() {
        return people;
    }

    public int getKeyList(Patient el) {
        int key = -1;
        List<Patient> collection = this.index();
        for (int i = 0; i < collection.size(); i++) {
            if (el.getId() == collection.get(i).getId()) {
                key = i;
                break;
            }
        }
        return key;
    }

    public void update(Patient patient) {
        int key = getKeyList(patient);
        if (key != -1) {
            people.set(key, patient);
        }
    }

    public void delete(Patient patient) {
        people.remove(patient);
    }
}
