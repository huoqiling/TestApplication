package com.example.testing.myapplication.bean;

/**
 * author: baiiu
 * date: on 16/6/23 10:18
 * description:
 */
public class Sign {
    public String color;
    public String name;

    public Sign(String color, String name) {
        this.color = color;
        this.name = name;
    }

    @Override public String toString() {
        return "Sign{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
