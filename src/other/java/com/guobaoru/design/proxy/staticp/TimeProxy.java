package com.guobaoru.design.proxy.staticp;

/**
 * @author Created by guobaoru.
 * @create on 2018/9/19.
 */
public class TimeProxy implements Moveable {

    Moveable moveable;

    public TimeProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        System.out.println("startTime:" + startTime);
        moveable.move();
        System.out.println("runTime:" + (System.currentTimeMillis() - startTime));
    }
}
