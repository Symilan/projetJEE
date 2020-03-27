package model;

import java.util.Objects;


/**
 * This class represent a game (for exemple Bomberman or Pacman)
 */
public class Game {
    private Integer id;
    private String name;
    private Integer nbPlayedSessions;
    private Boolean activated;


    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nbPlayedSessions=" + nbPlayedSessions +
                ", activated=" + activated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) &&
                Objects.equals(name, game.name) &&
                Objects.equals(nbPlayedSessions, game.nbPlayedSessions) &&
                Objects.equals(activated, game.activated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nbPlayedSessions, activated);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNbPlayedSessions() {
        return nbPlayedSessions;
    }

    public void setNbPlayedSessions(Integer nbPlayedSessions) {
        this.nbPlayedSessions = nbPlayedSessions;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public Game() {
    }

    public Game(Integer id, String name, Integer nbPlayedSessions, Boolean activated) {
        this.id = id;
        this.name = name;
        this.nbPlayedSessions = nbPlayedSessions;
        this.activated = activated;
    }
}
