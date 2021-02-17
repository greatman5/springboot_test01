package com.gtman5.test.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.StandardCharsets;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext ctx;

    @BeforeEach
    public void before() {
        mvc = MockMvcBuilders.webAppContextSetup(ctx)
                .addFilter(new CharacterEncodingFilter(StandardCharsets.UTF_8.name(), true))
                .alwaysDo(MockMvcResultHandlers.print())
                .build();
    }

    @Test
    public void hello() throws Exception {
        String hello = "안녕하세요.";

        mvc.perform(MockMvcRequestBuilders.get("/hello.do"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string(hello));
    }

    @Test
    public void hello2() throws Exception {
        String name = "한재종";

        mvc.perform(MockMvcRequestBuilders.get("/hello2.do")
                .param("name", name)
                .param("amount", "5000"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(name));
    }

    @Test
    public void lombok() {
        String name = "한재종";
        int amount = 10000;

        Hello hello = new Hello(name, amount);

        Assertions.assertEquals(hello.getName(), name);
        Assertions.assertEquals(hello.getAmount(), amount);
    }
}
