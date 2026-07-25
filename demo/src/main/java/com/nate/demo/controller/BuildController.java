package com.nate.demo.controller;

import com.nate.demo.model.BuildInfo;
import com.nate.demo.service.BuildService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BuildController {

    private final BuildService buildService;

    public BuildController(BuildService buildService) {
        this.buildService = buildService;
    }

    @GetMapping("/build")
    public BuildInfo getBuildInfo() {
        return buildService.getBuildInfo();
    }
}