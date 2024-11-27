package edu.miu.nomin.jpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//The course has a title, capacity, room, number
@Entity
@SecondaryTable(name="ROOM")
public class Course {
    @Id@GeneratedValue
    private Long id;
    private String title;
    private String capacity;
    @Column(table = "ROOM")
    private int room;
    @Column(name="CODE")
    private int number;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Student> students;

    public Course() {}
    public Course(String title, String capacity, int room, int number) {
        this.title = title;
        this.capacity = capacity;
        this.room = room;
        this.number = number;
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
    public String getCapacity() {
        return capacity;
    }
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
    public int getRoom() {
        return room;
    }
    public void setRoom(int room) {
        this.room = room;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", capacity='" + capacity + '\'' +
                ", room=" + room +
                ", number=" + number +
                '}';
    }

}
