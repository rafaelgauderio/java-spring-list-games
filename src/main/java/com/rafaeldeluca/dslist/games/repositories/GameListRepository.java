package com.rafaeldeluca.dslist.games.repositories;

import com.rafaeldeluca.dslist.games.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
