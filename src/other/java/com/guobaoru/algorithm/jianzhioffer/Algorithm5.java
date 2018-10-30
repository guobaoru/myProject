package com.guobaoru.algorithm.jianzhioffer;

import java.util.Stack;

/**
 * @author Created by guobaoru.
 * @create on 2018/9/25.
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Algorithm5 {

    public static void main(String[] args) {
        Algorithm5 ins = new Algorithm5();
        for (int i = 1; i < 6; i++) {
            ins.push(i);
        }
        for (int j = 0; j < 5; j++) {
            System.out.println(ins.pop());
        }
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1 == null && stack2 == null) {
            throw new RuntimeException("Empty!");
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
