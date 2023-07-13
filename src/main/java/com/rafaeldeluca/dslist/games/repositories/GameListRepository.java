package com.rafaeldeluca.dslist.games.repositories;

import com.rafaeldeluca.dslist.games.entities.GameList;
import com.rafaeldeluca.dslist.games.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameListRepository extends JpaRepository<GameList, Long> {

    @Query(nativeQuery= true, value =
            "SELECT tb_game.id, tb_game.tiTLE , tb_game.gaME_YEAR AS yearm, tb_game.img_URL AS imgUrl, tb_game.short_DESCRIPTION AS shortDescription, tb_belonging.poSITION \n" +
            "FROM tb_game\n" +
            "INNER JOIN tb_belonging\n" +
            "ON tb_game.id = tb_belonging.game_id\n" +
            "WHERE tb_belonging.game_list_id = :listId\n" +
            "ORDER BY tb_belonging.position")
    List<GameMinProjection> searchGameByList(Long listId);

}
