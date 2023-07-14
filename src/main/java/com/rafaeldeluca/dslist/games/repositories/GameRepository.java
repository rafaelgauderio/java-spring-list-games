package com.rafaeldeluca.dslist.games.repositories;

import com.rafaeldeluca.dslist.games.entities.Game;
import com.rafaeldeluca.dslist.games.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// the repository is the object responsible for quering the database
public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery= true, value =
            "SELECT tb_game.id, tb_game.title , tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl, tb_game.short_description AS shortDescription, tb_belonging.position\n" +
                    "FROM tb_game\n" +
                    "INNER JOIN tb_belonging\n" +
                    "ON tb_game.id = tb_belonging.game_id\n" +
                    "WHERE tb_belonging.game_list_id = :listId\n" +
                    "ORDER BY tb_belonging.position")
    List<GameMinProjection> searchGamesByList(Long listId);

}
