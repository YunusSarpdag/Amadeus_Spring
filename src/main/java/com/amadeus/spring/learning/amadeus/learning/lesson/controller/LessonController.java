package com.amadeus.spring.learning.amadeus.learning.lesson.controller;

import com.amadeus.spring.learning.amadeus.learning.lesson.model.Lesson;
import com.amadeus.spring.learning.amadeus.learning.lesson.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/lessons")
public class LessonController {

  @Autowired
  private LessonRepository repository;

  @GetMapping("/getAllLessons")
  public List<Lesson> getAllLessons(){
    return repository.findAll();
  }


  @PostMapping("/addLesson")
  public Lesson addLesson(@RequestBody Lesson lesson){
    return repository.save(lesson);
  }

  @PostMapping("/deleteLesson")
  public void deleteLesson(@RequestBody String id){
    repository.deleteById(Long.valueOf(id));
  }
}
