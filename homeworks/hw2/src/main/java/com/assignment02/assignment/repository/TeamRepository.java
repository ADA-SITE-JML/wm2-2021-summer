package com.assignment02.assignment.repository;

import com.assignment02.assignment.entity.Player;
import com.assignment02.assignment.entity.Team;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    @Query("select t from Team t where t.name = ?1")
    Optional<Team> findTeamByName(String name);

    @Modifying
    @Query(value = "delete from teams_players where team_id = ?1", nativeQuery = true)
    void deleteTeamPlayersById(Long id);

    @Modifying
    @Query(value = "delete from team where team_id = ?1", nativeQuery = true)
    void deleteTeamById(Long id);

    @Modifying
    @Query(value = "delete from teams_players where team_id = ?1 and player_id = ?2", nativeQuery = true)
    void removePlayer(Long teamId, Long playerId);

    @Modifying
    @Query(value = "update team set name = ?1 where team_id = ?2", nativeQuery = true)
    void updateTeam(String teamName, Long teamId);
}
