package com.rafaeldeluca.dslist.games.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;


@Embeddable // will represent to fields on the database relational table
public class BelongingPk implements Serializable {

    private static final long serialVersionUID = 7811420767112406087L;

    // it is not possible to create a composite primary key for the associated entities
    // then we create an auxiliary class for the 2 primary key that form this composite primary key

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "game_list_id")
    private GameList gameList;

    public BelongingPk () {

    }

    public BelongingPk(Game game, GameList gameList) {
        this.game = game;
        this.gameList = gameList;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getGameList() {
        return gameList;
    }

    public void setGameList(GameList gameList) {
        this.gameList = gameList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BelongingPk that = (BelongingPk) o;
        return game.equals(that.game) && gameList.equals(that.gameList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, gameList);
    }
}
