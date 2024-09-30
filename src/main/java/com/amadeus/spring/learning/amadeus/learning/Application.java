package com.amadeus.spring.learning.amadeus.learning;

import com.amadeus.spring.learning.amadeus.learning.lesson.controller.LessonController;
import com.amadeus.spring.learning.amadeus.learning.lesson.model.Lesson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EntityScan("com.amadeus.spring.learning.amadeus.learning.lesson.model")
@EnableJpaRepositories("com.amadeus.spring.learning.amadeus.learning.lesson.repository")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		LessonController lessonController = run.getBean(LessonController.class);
		List<Lesson> lessonList = lessonController.getAllLessons();
		for (Lesson lesson : lessonList) {
			System.out.println(lesson);
		}
	}

}
