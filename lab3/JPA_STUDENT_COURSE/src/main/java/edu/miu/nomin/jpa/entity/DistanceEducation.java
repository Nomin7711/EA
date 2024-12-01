package edu.miu.nomin.jpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("DE")
public class DistanceEducation extends Course {
    @Id@GeneratedValue
    private Long id;
    private String examProfessor;
    @ElementCollection
    private List<Date> webinarSessionDates;

    public DistanceEducation() {}
    public DistanceEducation(String title, Date startDate, String professorName, String examProfessor) {
        super(title, startDate, professorName);
        this.examProfessor = examProfessor;
    }
    public DistanceEducation(String title, Date startDate, String professorName, String examProfessor, List<Date> webinarSessionDates) {
        super(title, startDate, professorName);
        this.examProfessor = examProfessor;
        this.webinarSessionDates = webinarSessionDates;
    }
    public String getExamProfessor() {
        return examProfessor;
    }
    public void setExamProfessor(String examProfessor) {
        this.examProfessor = examProfessor;
    }
    public List<Date> getWebinarSessionDates() {
        return webinarSessionDates;
    }
    public void setWebinarSessionDates(Date webinarSessionDate) {
        if (webinarSessionDates == null) {
            webinarSessionDates = new ArrayList<>();
        }
        webinarSessionDates.add(webinarSessionDate);
    }

    public Long getId() {
        return id;
    }
}
