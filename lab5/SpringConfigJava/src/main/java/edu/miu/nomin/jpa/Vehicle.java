package edu.miu.nomin.jpa;

import org.springframework.beans.factory.DisposableBean;

public interface Vehicle extends DisposableBean {
    public void move();
}
