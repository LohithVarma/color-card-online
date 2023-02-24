package com.colourcardonline.backend.service;

import com.colourcardonline.backend.model.Credentials;
import com.colourcardonline.backend.model.Player;

import java.util.List;

public interface PlayerService {
    String createPlayer(Player player);
    Boolean loginPlayer(Credentials credentials);
    List<Player> getLeaderboard();
    void saveGameData(String playerName, Integer wins);
}
