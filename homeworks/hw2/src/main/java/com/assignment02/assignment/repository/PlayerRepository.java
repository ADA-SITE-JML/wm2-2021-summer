package com.assignment02.assignment.repository;

import com.assignment02.assignment.entity.Player;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    @Query("select p from Player p where p.firstName = ?1")
    Optional<Player> findPlayersByFirstName(String firstName);

    @Modifying
    @Query(value = "delete from teams_players where PLAYER_ID = ?1", nativeQuery = true)
    void deletePlayerFromTeamById(Long id);

    @Modifying
    @Query(value = "delete from player where player_id = ?1", nativeQuery = true)
    void deletePlayerById(Long id);

    @Modifying
    @Query(value = "update player set first_name = ?1, last_name = ?2 where player_id = ?3", nativeQuery = true)
    void updatePlayer(String firstName, String lastName, Long id);

    @Query(value = "select * from player where player.player_id not in (select player_id from teams_players);", nativeQuery = true)
    List<Player> freePlayers();
}
