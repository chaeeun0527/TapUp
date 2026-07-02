package com.example.mission_project.repository;

import com.example.mission_project.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query(value = """
            SELECT *
            FROM mission
            WHERE id NOT IN (
                SELECT mission_id
                FROM daily_mission
            )
            ORDER BY RAND()
            LIMIT 1
            """, nativeQuery = true)
    Optional<Mission> findRandomMission();

}