package com.example.demo.dao;

import com.example.demo.model.Appointment;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class AppointmentDAO {
    private static int appointmentCount = 0;
    private List<Appointment> appointments;

    {
        appointments = new ArrayList<>();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date1 = dateFormat.parse("01/10/2023");
            Date date2 = dateFormat.parse("11/10/2023");
            Date date3 = dateFormat.parse("19/02/2023");
            Date date4 = dateFormat.parse("20/02/2023");

            addAppointment(new Appointment(1, date1, "Артемов Иван Кириллович", "Иванов Олег Петрович"));
            addAppointment(new Appointment(2, date2, "Завьялова Валерия Анатольевна", "Сащенко Максим Валерьевич"));
            addAppointment(new Appointment(3, date3, "Тарасенко Виктор Львовович", "Дуброва Анна Витальевна"));
            addAppointment(new Appointment(4, date4, "Шубова Анна Федеоровна", "Васильева Наталия Павловна"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Appointment> index() {
        return appointments;
    }

    public Appointment show(int id) {
        return appointments.stream()
                .filter(appointment -> appointment.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addAppointment(Appointment appointment) {
        appointment.setId(++appointmentCount);
        appointments.add(appointment);
    }

    public int getKeyList(Appointment appointment) {
        int key = -1;
        List<Appointment> appointmentList = this.index();
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointment.getId() == appointmentList.get(i).getId()) {
                key = i;
                break;
            }
        }
        return key;
    }

    public void update(Appointment appointment) {
        int key = getKeyList(appointment);
        if (key != -1) {
            appointments.set(key, appointment);
        }
    }

    public void delete(Appointment appointment) {
        appointments.remove(appointment);
    }
}
