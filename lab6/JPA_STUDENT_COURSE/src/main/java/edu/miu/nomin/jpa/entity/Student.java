package edu.miu.nomin.jpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Cacheable(true)
@NamedQuery(
        name = "Student.CanGraduate",
        query = "SELECT s FROM Student s " +
                "WHERE s.gpa >= 3.0 " +
                "AND size(s.coursesAttended) >= 9 " +
                "AND s.courseAttending IS NULL",
        lockMode = LockModeType.PESSIMISTIC_READ
)
public class Student {
    @Id @GeneratedValue
    private Long id;
    @Version private int version;
    private String name;
    private float gpa;
    @ManyToOne(fetch = FetchType.EAGER)
    private Course courseAttending;

    @ManyToMany
    private List<Course> coursesAttended = new ArrayList<>();

    public Student() {}
    public Student(String name, float gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getGpa() {
        return gpa;
    }
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public Course getCourseAttending() {
        return courseAttending;
    }
    public void setCourseAttending(Course courseAttending) {
        this.courseAttending = courseAttending;
    }

    public void setCoursesAttended(Course coursesAttended) {
        this.coursesAttended.add(coursesAttended);
    }

    public List<Course> getCoursesAttended() {
        return coursesAttended;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
