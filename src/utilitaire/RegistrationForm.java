package utilitaire;
import model.Player;
import objectManager.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * This interface RegistrationForm is used to implement every tools to manipulate Form
 */
public interface RegistrationForm {
    String CHAMP_PSEUDO = "pseudo";
    String CHAMP_MAIL = "mailAdress";
    String CHAMP_MOTDEPASSE = "password";
    String CHAMP_CONF_MOTDEPASSE = "passwordConfirmed";
    String CHAMP_ANCIEN_MOTDEPASSE = "oldPassword";
    String CHAMP_PREFEREDGAMES = "preferedGames";
    String CHAMP_DATENAISSANCE_JOUR = "birthdate_day";
    String CHAMP_DATENAISSANCE_MOIS = "birthdate_month";
    String CHAMP_DATENAISSANCE_ANNEE = "birthdate_year";
    String CHAMP_NBSESSION = "nbPlayedSessions";

    /**
     * Method to get the value of a field, what it contains
     * @param request               HTTP request
     * @param nomChamp              Name of the field
     * @return                      Value of the field
     */
    static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0)
        {
            return null;
        }
        else
        {
            return valeur;
        }
    }

    /**
     * Method to check if a mail is valid
     * @param mail              Mail we want to check
     * @throws Exception        Throw an exception if the mail isn't valid.
     */
    static void validationMail(String mail) throws Exception
    {
        if (mail != null && mail.trim().length() != 0)
        {
            if (!mail.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)"))
            {
                throw new Exception("Merci de saisir une adresse mail valide.");
            }
        } else
        {
            throw new Exception("Merci de saisir une adresse mail.");
        }
    }

    /**
     * Method to check is a password is valid and if it is well confirmed
     * @param password          Password we want to check
     * @param conf_password     Confirmation password we want to check
     * @throws Exception        Throws an exception is password and conf_password are not the same, of if the password is way too weak
     */
    static void validationPassword(String password, String conf_password) throws Exception
    {
        if (password != null && password.trim().length() != 0 && conf_password != null && conf_password.trim().length() != 0)
        {
            if (!password.equals(conf_password))
            {
                throw new Exception("Mot de passe et confirmation différents");
            }
            else if (password.trim().length() < 5)
            {
                throw new Exception("Le mot de passe n'est pas assez long");
            }
        }
        else
        {
            throw new Exception("Merci de saisir un mot de passe et de le confirmer");
        }
    }

    /**
     * Method to check is a password is valid and if it is well confirmed, but the field can be empty if we don't want to change the password.
     * Used in Settings
     * @param password          Password we want to check
     * @param conf_password     Confirmation password we want to check
     * @throws Exception        Throws an exception is password and conf_password are not the same, of if the password is way too weak
     */
    static void validationPassword_opt(String password, String conf_password) throws Exception
    {
        if (!password.equals(conf_password))
        {
            throw new Exception("Mot de passe et confirmation différents");
        }
        else if (password.trim().length() < 5)
        {
            throw new Exception("Le mot de passe n'est pas assez long");
        }
    }


    /**
     * Method used to check is a pseudo is valid
     * @param pseudo                Pseudo that we want to check
     * @param idplayer              Id of the player who want to check a pseudo, used only in modification try
     * @param creation              If the check is on a creation or a modification
     * @throws Exception            Throws an exception is the pseudo is too long or too short, and if another player already got this pseudo
     */
    static void validationPseudo(String pseudo, int idplayer,  boolean creation) throws Exception
    {
        if (pseudo != null && pseudo.trim().length() != 0)
        {
            if (pseudo.trim().length() < 3)
            {
                throw new Exception("Le pseudo est trop court");
            }
            else if (pseudo.trim().length() > 17)
            {
                throw new Exception("Désolé, le pseudo est trop long");
            }
            Player otherPlayer = RequestHandler.getRequestHandler().getPlayerFromPseudo(pseudo);
            if (otherPlayer != null && (creation || otherPlayer.getId() != idplayer)) {
                throw new Exception("Ce joueur existe déjà");
            }
        }
        else
        {
            throw new Exception("Veuillez renseigner un pseudo");
        }
    }

    /**
     * Method used to check if a birth date is valid
     * @param dateDay               The day
     * @param dateMonth             The month
     * @param dateYear              The year
     * @throws Exception            Throws an exception if the birth date is not valid (e.g : 32-12-1997). It is considered invalid if year < 1900
     */
    static void validationDate(String dateDay, String dateMonth, String dateYear) throws Exception
    {
        if (dateDay != null && dateMonth != null && dateYear != null)
        {
            if (dateDay.trim().length() != 2 || dateMonth.trim().length() != 2 || dateYear.trim().length() != 4)
            {
                throw new Exception("Veuillez rentrer une date de naissance au format DD-MM-YYYY");
            }
            else if (!dateDay.matches("[0-9][0-9]") || !dateMonth.matches("[0-9][0-9]") || !dateYear.matches("[0-9][0-9][0-9][0-9]"))
            {
                throw new Exception("Caractère non reconnu dans la date, veuillez n'utiliser que des chiffres");
            }
            else
            {
                int day = Integer.parseInt(dateDay);
                int month = Integer.parseInt(dateMonth);
                int year = Integer.parseInt(dateYear);
                if (day > 31 || day < 1 || month > 12 || month < 1 || year > (new Date().getYear())+1900 || year < 1900)
                {
                    throw new Exception("Cette date n'est pas valide");
                }
            }
        } else
        {
            throw new Exception("Veuillez remplir votre date de naissance");
        }
    }
}
