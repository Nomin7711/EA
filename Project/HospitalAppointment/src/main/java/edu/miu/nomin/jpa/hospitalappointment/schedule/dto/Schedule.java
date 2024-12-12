package edu.miu.nomin.jpa.hospitalappointment.schedule.dto;

import edu.miu.nomin.jpa.hospitalappointment.doctor.dto.Doctor;
import jakarta.persistence.*;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    private String workingDays;
    private String availableSlots;  // E.g., ["9:00 AM - 10:00 AM", "2:00 PM - 3:00 PM"]

    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
