package com.example.mission_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class MissionResponse {

    private LocalDate date;

    private Long missionId;

    private String category;

    private String content;

}