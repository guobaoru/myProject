package com.guobaoru.design.proxy.staticp;

/**
 * @author Created by guobaoru.
 * @create on 2018/9/19.
 */
public class Tank implements Moveable{
    @Override
    public void move() {
        System.out.println("Tank is moving!");
    }
}
