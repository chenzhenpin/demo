package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MocMvcTest {
    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    @Before
    public void setup(){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    @Test
    public void test1(){
        try {
            mockMvc.perform(get("/moc"))
                    .andExpect(status().isOk())
                    //.andExpect(view().name("upload"))
                    .andExpect(content().string("hello word"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
