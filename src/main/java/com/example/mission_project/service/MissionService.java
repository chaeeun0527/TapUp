package com.example.mission_project.service;

import com.example.mission_project.dto.MissionResponse;
import com.example.mission_project.entity.DailyMission;
import com.example.mission_project.entity.Mission;
import com.example.mission_project.repository.DailyMissionRepository;
import com.example.mission_project.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final DailyMissionRepository dailyMissionRepository;

    public MissionResponse getTodayMission() {

        // 한국 시간 기준 오늘 날짜
        LocalDate today = LocalDate.now(ZoneId.of("Asia/Seoul"));

        // 오늘 미션이 이미 존재하면 그대로 반환
        DailyMission dailyMission = dailyMissionRepository
                .findByMissionDate(today)
                .orElse(null);

        // 오늘 미션이 없으면 새로 생성
        if (dailyMission == null) {

            Mission randomMission = missionRepository.findRandomMission()
                    .orElseThrow(() ->
                            new RuntimeException("추천 가능한 미션이 없습니다."));

            dailyMission = new DailyMission(today, randomMission);

            dailyMissionRepository.save(dailyMission);
        }

        Mission mission = dailyMission.getMission();

        return MissionResponse.builder()
                .date(dailyMission.getMissionDate())
                .missionId(mission.getId())
                .category(mission.getCategory())
                .content(mission.getContent())
                .build();
    }
}