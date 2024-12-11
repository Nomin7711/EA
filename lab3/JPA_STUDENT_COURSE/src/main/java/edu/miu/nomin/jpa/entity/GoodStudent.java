package edu.miu.nomin.jpa.entity;

public class GoodStudent {
    public String text;
    public GoodStudent() {}
    public GoodStudent(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "GoodStudent{" +
                "text='" + text + '\'' +
                '}';
    }
}
