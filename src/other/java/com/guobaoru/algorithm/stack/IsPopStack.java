package com.guobaoru.algorithm.stack;

import java.util.Stack;

/**
 * 问题：
 * a、b两个栈，判断b是否符合a栈的出栈顺序
 *
 * @author guobaoru
 * 解答思路：
 * for循环进栈，每次循环判断栈顶元素是否与出栈元素相等，出栈元素从0开始，每次相等后则进行pop操作，并将出栈index++，继续同样的比较，最终栈为空，则返回true
 */
public class IsPopStack {
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        // 空栈
        Stack<Integer> stack = new Stack<>();
        // index出栈的标记，出几个了
        int index_pop = 0;
        // 外层入栈，内层判断是否出栈
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            // stack.peek() 查看栈顶对象，不移除
            while (!stack.empty() && stack.peek() == popA[index_pop]) {
                index_pop++;
                stack.pop();
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        int b[] = {1, 2, 3, 4, 5};
        System.out.println(IsPopOrder(a, b));
    }
}
