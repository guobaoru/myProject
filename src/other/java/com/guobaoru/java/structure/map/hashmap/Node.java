package com.guobaoru.java.structure.map.hashmap;

import java.util.Objects;

/**
 * @author Created by guobaoru.
 * @create on 2019/1/17.
 */
public class Node {

    private Object item;
    private Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

}
