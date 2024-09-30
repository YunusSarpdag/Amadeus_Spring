package com.amadeus.spring.learning.amadeus.learning.lesson.controller;

import com.amadeus.spring.learning.amadeus.learning.lesson.aop.LessonAop;
import com.amadeus.spring.learning.amadeus.learning.lesson.configuration.LessonSecurity;
import com.amadeus.spring.learning.amadeus.learning.lesson.model.Lesson;
import com.amadeus.spring.learning.amadeus.learning.lesson.repository.LessonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(LessonController.class)
@Import(LessonSecurity.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LessonControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  LessonRepository repository;

  @Autowired
  ObjectMapper mapper;

  @MockBean
  EntityManager entityManager;

  @Test
  @Order(2)
  void getAllLessons() throws Exception {
    ResultActions response = mockMvc.perform(get("/api/v1/lessons/getAllLessons")
            .contentType("application/json")
            .with(SecurityMockMvcRequestPostProcessors.httpBasic("admin", "adminpassword")));
    response.andDo(result -> System.out.println("Result is " + result.getResponse().getContentAsString()))
            .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  @Order(1)
  void addLesson() throws Exception{
    Lesson lesson = new Lesson();
    lesson.setId(12L);
    lesson.setName("Angular");
    lesson.setDescription("Angular Description");
    lesson.setTeacher("Amanda");

    given(repository.save(lesson)).willReturn(lesson);

    ResultActions response = mockMvc.perform(post("/api/v1/lessons/addLesson")
            .contentType("application/json")
                    .with(SecurityMockMvcRequestPostProcessors.httpBasic("admin", "adminpassword"))
            .content(mapper.writeValueAsString(lesson)));

    response.andDo(result -> System.out.println("Result is " + result.getResponse().getContentAsString()))
      .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  void deleteLesson() {
  }
}