package edu.miu.nomin.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//@Component
public class C {
    private B b;
    private C(){

    }
//    @Autowired
    public C( B b) {
        this.b = b;
    }
    public B getB() {
        return b;
    }
}
