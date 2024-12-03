package edu.miu.nomin.jpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Cacheable(true)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="course_type")
public class Course {
    @Id@GeneratedValue
    private Long id;
    private String title;
    private Date startDate;
    private String professorName;

    @OneToMany(mappedBy = "courseAttending", cascade = CascadeType.PERSIST)
    private List<Student> students;

    @ManyToMany(mappedBy = "coursesAttended")
    private List<Student> enrolledStudents = new ArrayList<>();

    public Course() {}
    public Course(String title, Date startDate, String professorName) {
        this.title = title;
        this.startDate = startDate;
        this.professorName = professorName;
    }
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudent(Student student) {
        if(students == null){
            students = new ArrayList<>();
        }
        this.students.add(student);
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public String getProfessorName() {
        return professorName;
    }
    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Student enrolledStudents) {
        this.enrolledStudents.add(enrolledStudents);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", professorName='" + professorName + '\'' +
                ", students=" + students +
                '}';
    }
}
