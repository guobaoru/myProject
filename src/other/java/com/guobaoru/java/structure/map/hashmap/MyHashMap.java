package com.guobaoru.java.structure.map.hashmap;

import java.util.Map;

/**
 * @author Created by guobaoru.
 * @create on 2019/1/17.
 */
public class MyHashMap<k, v> {

    private Entry<k, v>[] table;
    private static final Integer CAPACITY = 16;
    private int size;

    public MyHashMap(Entry[] table) {
        this.table = table;
    }

    class Entry<k, v> {
        private k k;
        private v v;

    }


    public Object get(Object key) {
        return null;
    }

    public Object put(Object key, Object value) {
        return null;
    }

    public Object remove(Object key) {
        return null;
    }

    public int size() {
        return this.size;
    }

}
