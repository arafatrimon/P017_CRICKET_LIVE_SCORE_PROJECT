package com.example.cricket_score.repository;

import com.example.cricket_score.model.Player;
import com.example.cricket_score.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {
    List<Player> findPlayerByTeam(Team team);

}
