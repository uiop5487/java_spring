package com.sparta.week01.prac;

import java.util.ArrayList;
import java.util.List;

public class PracCondition {

    public static int countFruit(String fruit) {
        List<String> fruits = new ArrayList<>();

        fruits.add("감");
        fruits.add("배");
        fruits.add("감");
        fruits.add("딸기");
        fruits.add("수박");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("딸기");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("감");

        int count = 0;

        for (int i = 0; i < fruits.size(); i++) {
            if(fruits.get(i) == fruit) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int age = 19;
        if (age > 19) {
            System.out.println("성인입니다.");
        } else {
            System.out.println("성인이 아닙니다.");
        }

        int ret = countFruit("감");

        System.out.println(ret);
    }
}
