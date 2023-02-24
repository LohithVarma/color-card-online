package com.colourcardonline.backend.repo;

import com.colourcardonline.backend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Query(value = "select * from player where playername=?1 limit 1",nativeQuery = true)
    Optional<Player> getPlayerByPlayerName(String playerName);

    @Query(value = "select * from player where playername=?1 and password=?2 limit 1",nativeQuery = true)
    Optional<Player> getPlayerByCredentials(String playerName, String password);

    @Query(value = "select * from player order by wins desc limit 100",nativeQuery = true)
    List<Player> getLeaderboard();

    @Modifying
    @Query(value = "update player set wins=?1, trophies=?2 where playername=\"lohith\"", nativeQuery = true)
    void saveGameData(Integer wins, Long trophies, String playerName);
}
