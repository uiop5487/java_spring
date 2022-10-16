package com.sparta.week01.prac;

import java.util.ArrayList;
import java.util.List;

public class Prac {

    public static void main(String[] args) {
        // 문자열
        String myName = "김진성";
        System.out.println(myName);

        // 정수
        int age = 24;
        System.out.println(age);

        // 소수점
        float num = 3.7f;
        System.out.println(num);

        // 100억 보다 큰 숫자
        Long bigNum = 10000000000L;
        System.out.println(bigNum);

        int myAge = 20;
        // 불리언
        boolean isAdult = myAge > 20;
        boolean isKid = myAge <= 20;
        System.out.println(isAdult);
        System.out.println(isKid);
        System.out.println(myAge == 20);
        System.out.println(myAge != 20);

        // 배열
        List<String> newList = new ArrayList<>();
        String course1 = "코스1";
        String course2 = "코스2";
        newList.add(course1);
        newList.add(course2);
        System.out.println(newList);
        System.out.println(newList.get(1));
        List<String> newList2 = new ArrayList<>();
        newList2.add(course1);
        newList2.addAll(newList);
        System.out.println(newList2);
        newList2.remove(1);
    }
}
