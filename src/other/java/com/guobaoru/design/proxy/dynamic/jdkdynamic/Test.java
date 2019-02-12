package com.guobaoru.design.proxy.dynamic.jdkdynamic;

import java.lang.reflect.Proxy;

/**
 * @author Created by guobaoru.
 * @create on 2018/12/4.
 */
public class Test {
    public static void main(String[] args) {

        Person student = new Student();

        Person proxy = (Person) Proxy.newProxyInstance(Student.class.getClassLoader(), Student.class.getInterfaces(), new StudentInvocationHandler(student));

        proxy.getName();

//        System.out.println(proxy);

    }
}
