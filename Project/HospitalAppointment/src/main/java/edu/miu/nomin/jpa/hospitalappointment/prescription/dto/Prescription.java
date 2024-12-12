package edu.miu.nomin.jpa.hospitalappointment.prescription.dto;

import edu.miu.nomin.jpa.hospitalappointment.doctor.dto.Doctor;
import edu.miu.nomin.jpa.hospitalappointment.patient.dto.Patient;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;
    private String medication;
    private String dosage;
    private String instructions;
    private LocalDate dateIssued;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
