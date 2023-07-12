package com.rafaeldeluca.dslist.games.controller;

import com.rafaeldeluca.dslist.games.dto.GameMinDTO;
import com.rafaeldeluca.dslist.games.entities.Game;
import com.rafaeldeluca.dslist.games.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameMinDTO>>findAllGames () {
        List<GameMinDTO> listGame = gameService.findALlGames();
        return ResponseEntity.ok().body(listGame);
    }

}
