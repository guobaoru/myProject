package com.guobaoru.algorithm.node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by guobaoru.
 * @create on 2018/9/14.
 */
public class NodeList {

    public static void main(String[] args) {
        // 获取一个Node实例
        Node node = Node.createInstance(1);
        // 添加链表结构
        node.addNextNode(2).addNextNode(3).addNextNode(3).addNextNode(4).addNextNode(4).addNextNode(5);
        // 去重
        Node result = duplicateRemove(node);
        // 打印返回值
        while (result != null) {
            System.out.println(result.getValue());
            result = result.getNext();
        }

    }

    /**
     * 去重方法
     * @param node
     * @return
     */
    public static Node duplicateRemove(Node node) {
        if (node == null) {
            return null;
        }
        // 返回值 - 链表头
        Node result = null;
        // 前一个值
        Node previous = null;
        // 当前值
        Node current = node;
        // 下一个值
        Node next = current.getNext();
        // 重复元素集合
        List<Integer> list = new ArrayList<>();
        // 循环过滤
        while (next != null) {
            // 当两个值相等时，删除current值
            if (current.getValue() == next.getValue()) {
                current = next;
                next = next.getNext();
                if (previous != null) {
                    previous.setNext(current);
                }
                list.add(current.getValue());
                continue;
            }
            // 不相等时，判断当前元素是否在重复列表中
            // 如果在，则删除current值
            if (list.contains(current.getValue())) {
                current = next;
                next = next.getNext();
                if (previous != null) {
                    previous.setNext(current);
                }
                continue;
            }
            // 返回结果为空时，赋值链表头
            if (result == null) {
                result = current;
            }
            // 不相等时，也不在重复列表中，每个值向后移一位
            previous = current;
            current = next;
            next = next.getNext();
        }
        return result;
    }
}
