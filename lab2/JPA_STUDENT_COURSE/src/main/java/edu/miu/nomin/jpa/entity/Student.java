package edu.miu.nomin.jpa.entity;

import jakarta.persistence.*;

//The student has a name and GPA
@Entity
public class Student {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private float gpa;

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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
