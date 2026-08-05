package com.nate.demo.controller;

import com.nate.demo.service.BuildService;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BuildControllerTest {

    private final BuildService buildService = new BuildService(
            "test-app",
            "1.0.0",
            "42",
            "abc123",
            "test"
    );

    private final MockMvc mockMvc = MockMvcBuilders
            .standaloneSetup(new BuildController(buildService))
            .build();

    @Test
    void shouldReturnBuildInformation() throws Exception {
        mockMvc.perform(get("/api/build"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.application").value("test-app"))
                .andExpect(jsonPath("$.version").value("1.0.0"))
                .andExpect(jsonPath("$.buildNumber").value("42"))
                .andExpect(jsonPath("$.gitCommit").value("abc123"))
                .andExpect(jsonPath("$.environment").value("test"));
    }
}