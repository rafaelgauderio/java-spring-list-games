package com.rafaeldeluca.dslist.games.repositories;
import com.rafaeldeluca.dslist.games.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GameListRepository extends JpaRepository<GameList, Long> {

    // query to update the position
    @Modifying // it is not a SELECT query
    @Query(nativeQuery = true, value = "UPDATE tb_belonging " +
            "SET position = :newPosition " +
            "WHERE game_list_id = :gameListId AND game_id = :gameId")
    void updateBelongingPosition(Long gameListId, Long gameId, Integer newPosition);

}
