package com.example.cricket_score.repository;

import com.example.cricket_score.model.Bowler;
import com.example.cricket_score.model.BowlerModel;
import com.example.cricket_score.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BowlerRepository extends JpaRepository<Bowler, Long> {
    //@Query(value ="select total_runs from score")
    //    int totalRuns();
    @Query(value = "select count(*) from bowler", nativeQuery = true)
    int value();

    @Query(value = "select id, name from bowler", nativeQuery = true)
    List<Bowler> findByBowlerName();

    @Query(value = "select bowl from bowler where id = :id", nativeQuery = true)
    int findByTotalBowls(@Param("id") long id);

    @Query(value = "select bowl from bowler where id = :id", nativeQuery = true)
    int findByTotalBowl(@Param("id") long id);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update bowler set runs = :total where id =1",nativeQuery = true)
    void updateValue(@Param("total") int total);




}
