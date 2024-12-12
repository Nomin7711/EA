package edu.miu.nomin.jpa.hospitalappointment.appointment.dto;

import edu.miu.nomin.jpa.hospitalappointment.doctor.dto.Doctor;
import edu.miu.nomin.jpa.hospitalappointment.patient.dto.Patient;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    private LocalDateTime appointmentDateTime;
    private String status;  // Scheduled, Checked-in, Completed, Canceled

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
