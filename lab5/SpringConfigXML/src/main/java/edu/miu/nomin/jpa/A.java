package edu.miu.nomin.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Lazy;

//@Component
public class A {
    private C c;
    private A(){

    }
//    @Autowired
    public A( C c) {
        this.c = c;
    }
    public C getC() {
        return c;
    }

}
