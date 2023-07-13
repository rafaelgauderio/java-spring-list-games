package com.rafaeldeluca.dslist.games.projections;

public interface GameMinProjection {
    // get methods for each data the the query will return
    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
