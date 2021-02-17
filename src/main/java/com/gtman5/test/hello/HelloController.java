package com.gtman5.test.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello.do")
    public String hello() {
        return "안녕하세요.";
    }

    @RequestMapping("/hello2.do")
    public Hello hello2(Hello hello) {
        return hello;
    }
}
