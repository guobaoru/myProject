package com.guobaoru.design.proxy.staticp;

/**
 * @author Created by guobaoru.
 * @create on 2018/9/19.
 * 静态代理
 *
 * 1、代理对象与被代理对象实现同一个接口Moveable
 * 2、代理类中聚合了代理对象
 *
 * 优点：可以自由组合代理逻辑
 * 缺点：代理类膨胀
 */
public class Client {
    public static void main(String[] args) {

        Tank tank = new Tank();
        TimeProxy timeProxy = new TimeProxy(tank);
        LogProxy logProxy = new LogProxy(timeProxy);
        logProxy.move();

    }
}
