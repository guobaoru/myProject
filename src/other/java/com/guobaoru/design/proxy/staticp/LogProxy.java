package com.guobaoru.design.proxy.staticp;

/**
 * @author Created by guobaoru.
 * @create on 2018/9/19.
 */
public class LogProxy implements Moveable {
    Moveable moveable;

    public LogProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {

        System.out.println("log日志开始...");
        moveable.move();
        System.out.println("log日志结束.");
    }
}
