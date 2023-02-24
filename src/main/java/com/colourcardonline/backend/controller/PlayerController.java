package com.colourcardonline.backend.controller;

import com.colourcardonline.backend.model.Credentials;
import com.colourcardonline.backend.model.Player;
import com.colourcardonline.backend.service.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    private PlayerServiceImpl playerService;

    @PostMapping(value = "/post")
    public ResponseEntity<String> postPlayer(@RequestBody Player player){
        return new ResponseEntity<>(playerService.createPlayer(player), HttpStatus.OK);
    }

    @GetMapping(value = "/login")
    public ResponseEntity<Boolean> loginPlayer(@RequestBody Credentials credentials){
        return new ResponseEntity<>(playerService.loginPlayer(credentials), HttpStatus.OK);
    }

    @GetMapping(value = "/leaderboard")
    public ResponseEntity<List<Player>> getLeaderboard(){
        return new ResponseEntity<>(playerService.getLeaderboard(), HttpStatus.OK);
    }

    @PutMapping(value = "/save/{playerName}/{wins}")
    public ResponseEntity<HttpStatus> saveGameData(@PathVariable("playerName") String playerName,
                             @PathVariable("wins") Integer wins) {
        playerService.saveGameData(playerName, wins);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
