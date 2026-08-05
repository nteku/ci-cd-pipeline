package com.nate.demo.controller;

import com.nate.demo.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MessageControllerTest {

    private final MockMvc mockMvc = MockMvcBuilders
            .standaloneSetup(
                    new MessageController(new MessageService())
            )
            .build();

    @Test
    void shouldReturnMessage() throws Exception {
        mockMvc.perform(get("/api/message"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message")
                        .value("CI/CD pipeline deployed successfully!"));
    }
}
