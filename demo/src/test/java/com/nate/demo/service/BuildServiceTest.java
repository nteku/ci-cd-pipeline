package com.nate.demo.service;

import com.nate.demo.model.BuildInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuildServiceTest {

    @Test
    void shouldReturnBuildInformation() {
        BuildService buildService = new BuildService(
                "test-app",
                "1.0.0",
                "42",
                "abc123",
                "test"
        );

        BuildInfo buildInfo = buildService.getBuildInfo();

        assertEquals("test-app", buildInfo.application());
        assertEquals("1.0.0", buildInfo.version());
        assertEquals("42", buildInfo.buildNumber());
        assertEquals("abc123", buildInfo.gitCommit());
        assertEquals("test", buildInfo.environment());
    }
}