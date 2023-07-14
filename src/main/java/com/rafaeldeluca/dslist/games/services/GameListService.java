package com.rafaeldeluca.dslist.games.services;


import com.rafaeldeluca.dslist.games.dto.GameListDTO;
import com.rafaeldeluca.dslist.games.entities.GameList;
import com.rafaeldeluca.dslist.games.projections.GameMinProjection;
import com.rafaeldeluca.dslist.games.repositories.GameListRepository;
import com.rafaeldeluca.dslist.games.repositories.GameRepository;
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

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAllGameList () {
        List<GameList> listGameList = new ArrayList<GameList>();
        listGameList = gameListRepository.findAll();
        return listGameList.stream().map( g -> new GameListDTO(g)).collect(Collectors.toList());
    }

    @Transactional(readOnly = false)
    public void moveList(Long listId, int sourceIndex, int destinationIndex) {
        // first get the list, than change the position of the games
        List<GameMinProjection> gameList = gameRepository.searchGamesByList(listId); // list on the memory
        GameMinProjection sourceGame = gameList.remove(sourceIndex);
        gameList.add(destinationIndex, sourceGame);

        int lower = sourceIndex;
        if (sourceIndex < destinationIndex) {
            lower = sourceIndex;
        } else {
            lower = destinationIndex;
        }

        int  higher= sourceIndex;
        if(sourceIndex < destinationIndex) {
            higher = destinationIndex;
        } else {
            higher = sourceIndex;
        }

        for(int newPosition = lower; newPosition <= higher; newPosition++) {
            gameListRepository.updateBelongingPosition(listId,gameList.get(newPosition).getId(), newPosition);
        }
    }
}
