package com.example.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SingletonBean //implements ApplicationContextAware
 {

    private ApplicationContext applicationContext;

    private PrototypeBean prototypeBean;

    @Lookup
    public PrototypeBean getPrototypeBean() {
        //return applicationContext.getBean(PrototypeBean.class);
        return this.prototypeBean;
    }

    public void setPrototypeBean(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }

    /*@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }*/
}
