package edu.miu.nomin.jpa;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PrototypePreDestroyerInvoker implements BeanPostProcessor, BeanFactoryAware, DisposableBean {
    private List<Object> prototypeBeans = new ArrayList<>();
    private BeanFactory beanFactory;

    //this is aware interface so it'll called before after initialization
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Aware interface called bean factory");
        this.beanFactory = beanFactory;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("PrototypePreDestroyerInvoker::destroy");
        for (Object prototypeBean : prototypeBeans) {
            if(prototypeBean instanceof DisposableBean) {
                ((DisposableBean) prototypeBean).destroy();
            }
        }
        this.prototypeBeans.clear();
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("PrototypePreDestroyerInvoker::postProcessAfterInitialization");
        synchronized (BeanFactory.class){
            if(this.beanFactory.isPrototype(beanName)) {
                this.prototypeBeans.add(bean);
            }
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
    private void init() {
        System.out.println("Initializing PrototypePreDestroyerInvoker");
    }
}
