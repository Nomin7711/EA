package edu.miu.nomin.jpa;


import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(true)
public class Bike implements Vehicle, DisposableBean, BeanNameAware {
    private String beanName;
    private int tireSize;
    private String brand;

    public Bike() {
        System.out.println("Bike created");
    }
    public Bike(int i, String honda) {
        this.tireSize = i;
        this.brand = honda;
    }

    @Override
    public void move() {
        System.out.println("Bike move at 10 mph");
        System.out.println(toString());
    }

    public int getTireSize() {
        return tireSize;
    }
    public void setTireSize(int tireSize) {
        this.tireSize = tireSize;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBeanName() {
        return beanName;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
    @Override
    public String toString() {
        return "Bike{" +
                "tireSize=" + tireSize +
                ", brand='" + brand + '\'' +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bike destroyed");
    }
}
