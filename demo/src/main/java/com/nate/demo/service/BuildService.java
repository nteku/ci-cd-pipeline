package com.nate.demo.service;

import com.nate.demo.model.BuildInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BuildService {

    private final String applicationName;
    private final String version;
    private final String buildNumber;
    private final String gitCommit;
    private final String environment;

    public BuildService(
            @Value("${APP_NAME:ci-cd-demo-app}") String applicationName,
            @Value("${APP_VERSION:local}") String version,
            @Value("${BUILD_NUMBER:local}") String buildNumber,
            @Value("${GIT_COMMIT:unknown}") String gitCommit,
            @Value("${APP_ENVIRONMENT:development}") String environment
    ) {
        this.applicationName = applicationName;
        this.version = version;
        this.buildNumber = buildNumber;
        this.gitCommit = gitCommit;
        this.environment = environment;
    }

    public BuildInfo getBuildInfo() {
        return new BuildInfo(
                applicationName,
                version,
                buildNumber,
                gitCommit,
                environment
        );
    }
}
