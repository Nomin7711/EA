package edu.miu.nomin.jpa.hospitalappointment.patient.dto;

import edu.miu.nomin.jpa.hospitalappointment.appointment.dto.Appointment;
import edu.miu.nomin.jpa.hospitalappointment.prescription.dto.Prescription;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String name;
    private String contactInfo;
    private String medicalHistory;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "patient")
    private List<Prescription> prescriptions;
}
