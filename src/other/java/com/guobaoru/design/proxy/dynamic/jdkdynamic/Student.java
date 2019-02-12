package com.guobaoru.design.proxy.dynamic.jdkdynamic;

/**
 * @author Created by guobaoru.
 * @create on 2018/12/4.
 */
public class Student implements Person {

    @Override
    public void getName() {
        System.out.println("Please call me Mr.Guo");
    }

}
