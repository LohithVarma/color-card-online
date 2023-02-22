package com.colorcardonline.backend.service;

import com.colorcardonline.backend.model.Credentials;
import com.colorcardonline.backend.model.Player;

import java.util.List;

public interface PlayerService {
    String createPlayer(Player player);
    Boolean loginPlayer(Credentials credentials);
    List<Player> getLeaderboard();
    void saveGameData(String playerName, Integer wins);
}
