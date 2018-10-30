package com.guobaoru.algorithm.jianzhioffer;

//import lombok.Data;

import java.util.ArrayList;

/**
 * @author Created by guobaoru.
 * @create on 2018/9/19.
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Algorithm3 {

    public static void main(String[] args) {

        ListNode node = ListNode.createInstance(1);
        node.addNextNode(2).addNextNode(3).addNextNode(4);
        System.out.println(printListFromTailToHead(node));

    }

    static ArrayList<Integer> result = new ArrayList<>();

    /**
     * 递归方式
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        if (listNode.next != null) {
            printListFromTailToHead(listNode.next);
        }
        result.add(listNode.val);
        return result;
    }

}

//@Data
class ListNode {

    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
    }

    public static ListNode createInstance(int val){
        return new ListNode(val);
    }

    public ListNode addNextNode(int val){
        this.setNext(new ListNode(val));
        return this.getNext();
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
