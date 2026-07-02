package com.example.mission_project.repository;

import com.example.mission_project.entity.DailyMission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface DailyMissionRepository
        extends JpaRepository<DailyMission, Long> {

    Optional<DailyMission> findByMissionDate(LocalDate missionDate);

}