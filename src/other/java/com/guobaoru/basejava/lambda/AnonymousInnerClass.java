//package com.guobaoru.java.lambda;
//
//import org.junit.ConditionTest;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
///**
// * @author Created by guobaoru.
// * @create on 2018/9/5.
// */
//public class AnonymousInnerClass {
//
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
//        oldRunable();
//        runable();
//    }
//
//    @ConditionTest
//    public static void oldRunable() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("The old runable now is using!");
//            }
//        }).start();
//    }
//
//    @ConditionTest
//    public static void runable() {
////        new Thread(() -> System.out.println("It's a lambda function!")).start();
//    }
//
//}
