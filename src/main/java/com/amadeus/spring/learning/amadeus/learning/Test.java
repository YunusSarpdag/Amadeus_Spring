package com.amadeus.spring.learning.amadeus.learning;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/testHttp")
public class Test {
  @RequestMapping("/test")
  public String test() {
    return "Hello World Amadeus Spring Learning";
  }
}
