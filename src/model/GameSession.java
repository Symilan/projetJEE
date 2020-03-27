package model;

import java.util.Date;
import java.util.Objects;


/**
 * This class represent the instance of a player playing one game
 */
public class GameSession {
    private Integer id;
    private Integer duration;
    private Game game;
    private Integer score;
    private Player player;
    private Date beginningDate;
    private Date endingDate;

    @Override
    public String toString() {
        return "GameSession{" +
                "id=" + id +
                ", duration=" + duration +
                ", game=" + game +
                ", score=" + score +
                ", player=" + player +
                ", beginningDate=" + beginningDate +
                ", endingDate=" + endingDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameSession that = (GameSession) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(game, that.game) &&
                Objects.equals(score, that.score) &&
                Objects.equals(player, that.player) &&
                Objects.equals(beginningDate, that.beginningDate) &&
                Objects.equals(endingDate, that.endingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duration, game, score, player, beginningDate, endingDate);
    }

    public GameSession() {
    }

    public GameSession(Integer id, Integer duration, Game game, Integer score, Player player, Date beginningDate, Date endingDate) {
        this.id = id;
        this.duration = duration;
        this.game = game;
        this.score = score;
        this.player = player;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Date getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }
}
