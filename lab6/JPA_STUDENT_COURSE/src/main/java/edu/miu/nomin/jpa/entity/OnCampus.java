package edu.miu.nomin.jpa.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Cacheable(true)
@DiscriminatorValue("Campus")
public class OnCampus extends Course {
    private String room;
    private int capacity;

    public OnCampus() {}
    public OnCampus(String title, Date startDate, String professorName, String room, int capacity) {
        super(title, startDate, professorName);
        this.room = room;
        this.capacity = capacity;
    }
    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "OnCampus{" +
                "room='" + room + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
