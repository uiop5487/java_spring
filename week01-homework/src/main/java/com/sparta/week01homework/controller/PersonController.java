package com.sparta.week01homework.controller;

import com.sparta.week01homework.prac.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/myinfo")
    public Person getPerson() {
        Person person = new Person();
        person.setName("김진성");
        person.setHobby("코딩");
        person.setAge(24);
        return person;
    }
}
