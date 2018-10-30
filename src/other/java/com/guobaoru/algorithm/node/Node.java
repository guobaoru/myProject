package com.guobaoru.algorithm.node;

//import lombok.Data;

/**
 * @author Created by guobaoru.
 * @create on 2018/9/14.
 */
//@Data
public class Node {

    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public static Node createInstance(int value){
        return new Node(value);
    }

    public Node addNextNode(int value){
        this.setNext(new Node(value));
        return this.getNext();
    }


    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
