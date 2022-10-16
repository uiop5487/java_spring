package com.sparta.week01.prac;

public class PracClass {

    public static void main(String[] args) {
        Course course = new Course();
        String title = "제목";
        String tutor = "김진성";
        int days = 30;
        course.setTitle(title);
        course.setDays(days);
        course.setTutor(tutor);
        System.out.println(course.getDays());
        System.out.println(course.getTitle());
        System.out.println(course.getTutor());

        Tutor classTutor = new Tutor("김진성", 1);
        System.out.println(classTutor.getName());
        System.out.println(classTutor.getBio());

        Tutor classTutor2 = new Tutor();
        classTutor2.setName("김아무개");
        classTutor2.setBio(10);
        System.out.println(classTutor2.getName());
        System.out.println(classTutor2.getBio());
    }
}
