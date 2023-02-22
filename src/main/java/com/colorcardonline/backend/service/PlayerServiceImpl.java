package com.colorcardonline.backend.service;

import com.colorcardonline.backend.model.Credentials;
import com.colorcardonline.backend.model.Player;
import com.colorcardonline.backend.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService{
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public String createPlayer(Player player) {
        Optional<Player> existing = playerRepository.getPlayerByPlayerName(player.getPlayername());
        if(existing.isPresent()) return "Player Name Already Taken";
        player.setWins(0);
        player.setTrophies(0L);
        playerRepository.save(player);
        return "Created Successfully";
    }

    @Override
    public Boolean loginPlayer(Credentials credentials) {
        Optional<Player> player = playerRepository.getPlayerByCredentials(credentials.getPlayername(), credentials.getPassword());
        return player.isPresent();
    }

    @Override
    public List<Player> getLeaderboard() {
        return playerRepository.getLeaderboard();
    }

    @Override
    public void saveGameData(String playerName, Integer wins) {
        Optional<Player> optionalPlayer = playerRepository.getPlayerByPlayerName(playerName);
        if(optionalPlayer.isPresent()){
            Player player = optionalPlayer.get();
            playerRepository.saveGameData(player.getWins() + wins, player.getTrophies() + (wins * 10L), playerName);
        }
    }

}
