package com.amadeus.spring.learning.amadeus.learning.lesson.repository;

import com.amadeus.spring.learning.amadeus.learning.lesson.model.Lesson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LessonRepositoryTest {

  @Autowired
  private LessonRepository lessonRepository;

  @Test
  void testAddLesson() {
    Lesson lesson = new Lesson();
    lesson.setId(12L);
    lesson.setName("Angular");
    lesson.setDescription("Angular Description");
    lesson.setTeacher("Amanda");
    lessonRepository.save(lesson);
    assertEquals(lessonRepository.findAll().size(), 1);
  }

}