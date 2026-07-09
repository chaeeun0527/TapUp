package com.example.mission_project.controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.mission_project.dto.MissionResponse;
import com.example.mission_project.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @GetMapping("/today")
    public MissionResponse getTodayMission() {
        return missionService.getTodayMission();
    }
}
