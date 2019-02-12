package com.guobaoru.java.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by guobaoru.
 * @create on 2018/9/5.
 */
public class ListTest {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(128);
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setName("name" + i);
            users.add(user);
        }

        System.out.println();

//        List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
//
//        System.out.println(sorted.toString());


    }
}

class User {
    private int id;
    private String name;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
