package model;

public enum SessionType {
    Player,
    Administrator,
    Error;

    @Override
    public String toString() {
        if (this==SessionType.Player)
        {
            return "Joueur";
        }
        else if (this==SessionType.Administrator)
        {
            return "Admin";
        }
        else if (this==SessionType.Error)
        {
            return "Erreur";
        }
        return "Type de session non reconnu";
    }
}
