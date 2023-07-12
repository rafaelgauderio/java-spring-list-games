package com.rafaeldeluca.dslist.games.repositories;

import com.rafaeldeluca.dslist.games.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

// the repository is the object responsible for quering the database
public interface GameRepository extends JpaRepository<Game, Long> {
    
}
