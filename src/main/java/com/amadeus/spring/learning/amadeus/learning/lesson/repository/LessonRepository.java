package com.amadeus.spring.learning.amadeus.learning.lesson.repository;

import com.amadeus.spring.learning.amadeus.learning.lesson.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson , Long> {
}
