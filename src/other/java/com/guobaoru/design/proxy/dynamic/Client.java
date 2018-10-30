package com.guobaoru.design.proxy.dynamic;

/**
 * @author Created by guobaoru.
 * @create on 2018/9/19.
 * 动态代理
 *
 * 静态代理为基础，动态生成代理类
 * 解决静态代理缺点
 */
public class Client {
    public static void main(String[] args) throws Exception {

        Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class);
        m.move();

    }
}
