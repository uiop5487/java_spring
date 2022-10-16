package com.sparta.week01.prac;

public class PracMethod {

    public static void printInfo() {
        String title = "제목";
        String student = "김진성";
        int weeks = 1;
        float rating = 5.0f;

        System.out.println("제목: " + title);
        System.out.println("이름: " + student);
        System.out.println("주차: " + weeks);
        System.out.println("점수: " + rating);
    }

    public static String returnString(String arg) {
        return arg;
    }

    public static int addNum(int num1, int num2) {
        return num1 + num2;
    }

    public static int minusNum(int num1, int num2) {
        return num1 - num2;
    }

    public static void main(String[] args) {
        printInfo();
        System.out.println(returnString("파라미터"));
        System.out.println(addNum(1, 2));
        System.out.println(minusNum(4, 2));
    }
}
