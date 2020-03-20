package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Player {
    private String nom;
    private String prenom;
    private Integer id;
    private String pseudo;
    private String mail;
    private Date birthDate;
    private ArrayList<String> preferedGames;
    private Integer nbPlayedSessions;
    private Date registerDate;
    private Boolean banned;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) &&
                Objects.equals(pseudo, player.pseudo) &&
                Objects.equals(mail, player.mail) &&
                Objects.equals(birthDate, player.birthDate) &&
                Objects.equals(preferedGames, player.preferedGames) &&
                Objects.equals(nbPlayedSessions, player.nbPlayedSessions) &&
                Objects.equals(registerDate, player.registerDate) &&
                Objects.equals(banned, player.banned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, id, pseudo, mail, birthDate, preferedGames, nbPlayedSessions, registerDate, banned);
    }

    @Override
    public String toString() {
        return "Player{" +
                "nom=" + nom +
                "prenom=" + prenom +
                "id=" + id +
                ", pseudo='" + pseudo + '\'' +
                ", mail='" + mail + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", preferedGames=" + preferedGames +
                ", nbPlayedSessions=" + nbPlayedSessions +
                ", registerDate='" + registerDate + '\'' +
                ", banned=" + banned +
                '}';
    }

    public Player() {
    }

    public Player(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }

    public Player(String nom, String prenom, Integer id, String pseudo, String mail, Date birthDate, ArrayList<String> preferedGames, Integer nbPlayedSessions, Date registerDate, Boolean banned) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.pseudo = pseudo;
        this.mail = mail;
        this.birthDate = birthDate;
        this.preferedGames = preferedGames;
        this.nbPlayedSessions = nbPlayedSessions;
        this.registerDate = registerDate;
        this.banned = banned;
    }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }

    public void setPrenom(String prenom) { this.prenom = prenom; }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<String> getPreferedGames() {
        return preferedGames;
    }

    public void setPreferedGames(ArrayList<String> preferedGames) {
        this.preferedGames = preferedGames;
    }

    public Integer getNbPlayedSessions() {
        return nbPlayedSessions;
    }

    public void setNbPlayedSessions(Integer nbPlayedSessions) {
        this.nbPlayedSessions = nbPlayedSessions;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Boolean getBanned() {
        return banned;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }
}


