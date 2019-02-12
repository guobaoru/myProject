package com.guobaoru.design.proxy.dynamic.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Created by guobaoru.
 * @create on 2018/12/4.
 */
public class StudentInvocationHandler implements InvocationHandler {

    Person person;

    public StudentInvocationHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before ...");
        Object result = method.invoke(person, args);
        System.out.println("after ...");
        return result;
    }

}
