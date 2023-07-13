package com.rafaeldeluca.dslist.games.services;


import com.rafaeldeluca.dslist.games.dto.GameListDTO;
import com.rafaeldeluca.dslist.games.entities.GameList;
import com.rafaeldeluca.dslist.games.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = false)
    public List<GameListDTO> findAllGameList () {
        List<GameList> listGameList = new ArrayList<GameList>();
        listGameList = gameListRepository.findAll();
        return listGameList.stream().map( g -> new GameListDTO(g)).collect(Collectors.toList());
    }



}
