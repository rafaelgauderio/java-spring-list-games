package com.rafaeldeluca.dslist.games.controller;

import com.rafaeldeluca.dslist.games.dto.GameListDTO;
import com.rafaeldeluca.dslist.games.dto.GameMinDTO;
import com.rafaeldeluca.dslist.games.services.GameListService;
import com.rafaeldeluca.dslist.games.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAllGameLists () {
        List<GameListDTO> gameListDTO = gameListService.findAllGameList();
        return ResponseEntity.ok().body(gameListDTO);
    }

    @GetMapping(value="/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> findGamesByList(@PathVariable Long listId) {
        List<GameMinDTO> gameListDTO = gameService.findGamesByList(listId);
        return ResponseEntity.ok().body(gameListDTO);
    }
}
