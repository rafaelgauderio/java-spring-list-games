package com.rafaeldeluca.dslist.games.controller;

import com.rafaeldeluca.dslist.games.dto.GameListDTO;
import com.rafaeldeluca.dslist.games.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAllGameLists () {
        List<GameListDTO> gameListDTO = gameListService.findAllGameList();
        return ResponseEntity.ok().body(gameListDTO);

    }
}
