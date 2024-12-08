package edu.miu.nomin.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//@Component
public class B {
    private A a;
    private B(){

    }
//    @Autowired
    public B( A a) {
        this.a = a;
    }
    public A getA() {
        return a;
    }
}
