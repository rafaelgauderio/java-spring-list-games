package com.rafaeldeluca.dslist.games.services;

// service is the layer that manage all the application rules

import com.rafaeldeluca.dslist.games.dto.GameDTO;
import com.rafaeldeluca.dslist.games.dto.GameMinDTO;
import com.rafaeldeluca.dslist.games.entities.Game;
import com.rafaeldeluca.dslist.games.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findALlGames () {
        List<Game> listGame = new ArrayList<Game>();
        listGame = gameRepository.findAll();
        return listGame.stream().map( (game) -> new GameMinDTO(game)).collect(Collectors.toList());
    }

    // Trsancactional make the operation with the database ACID (atomicity, consistency, isolation, durability)
    @Transactional(readOnly = true)
    public GameDTO findGameById(Long id) {
        Game entity = gameRepository.findById(id).get();
        GameDTO gameDTO = new GameDTO(entity);
        return gameDTO;
    }

}
