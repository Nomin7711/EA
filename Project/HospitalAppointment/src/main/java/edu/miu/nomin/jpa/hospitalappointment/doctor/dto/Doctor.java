package edu.miu.nomin.jpa.hospitalappointment.doctor.dto;

import edu.miu.nomin.jpa.hospitalappointment.appointment.dto.Appointment;
import edu.miu.nomin.jpa.hospitalappointment.prescription.dto.Prescription;
import edu.miu.nomin.jpa.hospitalappointment.schedule.dto.Schedule;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    private String name;
    private String specialty;
    private String availability;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "doctor")
    private List<Prescription> prescriptions;

    @OneToOne(mappedBy = "doctor")
    private Schedule schedule;
}
