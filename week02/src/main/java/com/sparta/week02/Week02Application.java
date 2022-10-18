package com.sparta.week02;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;

@EnableJpaAuditing
@SpringBootApplication
public class Week02Application {

	public static void main(String[] args) {
		SpringApplication.run(Week02Application.class, args);
	}

	// Week02Application.java 의 main 함수 아래에 붙여주세요.
	@Bean
	public CommandLineRunner demo(CourseRepository repository) {
    	return (args) -> {
			Course course1 = new Course("강의제목", "김진성");
			repository.save(course1);

			List<Course> couresList = repository.findAll();

			for(int i = 0; i < couresList.size(); i++) {
				Course c = couresList.get(i);
				System.out.println(c.getTitle());
				System.out.println(c.getTutor());
			}
    	};
	}

}
