package com.nate.demo.model;

public record BuildInfo(
        String application,
        String version,
        String buildNumber,
        String gitCommit,
        String environment
) {
}
