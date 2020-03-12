package model;

import java.util.Date;
import java.util.Objects;

public class GameSession {
    private Integer id;
    private Integer duration;
    private Game game;
    private Integer score;
    private Player player;
    private Date beginDate;
    private Date endDate;

    @Override
    public String toString() {
        return "GameSession{" +
                "id=" + id +
                ", duration=" + duration +
                ", game=" + game +
                ", score=" + score +
                ", player=" + player +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
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
                Objects.equals(beginDate, that.beginDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duration, game, score, player, beginDate, endDate);
    }

    public GameSession() {
    }

    public GameSession(Integer id, Integer duration, Game game, Integer score, Player player, Date beginDate, Date endDate) {
        this.id = id;
        this.duration = duration;
        this.game = game;
        this.score = score;
        this.player = player;
        this.beginDate = beginDate;
        this.endDate = endDate;
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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
