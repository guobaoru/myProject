package com.guobaoru.algorithm;

/**
 * 值传递与引用传递
 */
public class Example {
    String str = "good";
    String[] ch = {"a", "b", "c"};

    public void change(String str, String ch[]) {
        str = "ok";
        ch[0] = "g";
    }

    public static void main(String[] args) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + "and" + ex.ch[0] + ex.ch[1] + ex.ch[2]);
    }
}