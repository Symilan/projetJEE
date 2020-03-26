<%--
  Created by IntelliJ IDEA.
  User: virgi
  Date: 13/03/2020
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enregistrement</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="ressources/style.css" />
</head>
<body>
<form method="post" action="enregistrement">
<fieldset id="tfa_Address" class="left_side">
    <legend id="tfa_Address-L"><b>Information de base </b></legend>
    <div id="tfa_6980290244516">
        <div id="pseudo-D" class="registration_paragraph">
            <label id="pseudo-L" for="pseudo">Pseudo :</label><br><input type="text" id="pseudo" name="pseudo" value="" title="Pseudo" style="width: 100%" placeholder="ex : JeanJean_du_26">
            <span class="erreur">${erreurs['pseudo']}</span>
        </div>
        <div id="mailAdress-D" class="registration_paragraph">
            <label id="mailAdress-L" for="mailAdress-L">Adresse mail :</label><br><input type="text" id="mailAdress" name="mailAdress" value="" title="Adresse mail" style="width: 100%" placeholder="ex : jeanjean@gmail.com">
            <span class="erreur">${erreurs['mailAdress']}</span>
        </div>
        <div id="password-D" class="registration_paragraph">
            <label id="password-L" for="password-L">Mot de passe :</label><br><input type="password" id="password" name="password" value="" title="Mot de passe" style="width: 100%">
            <span class="erreur">${erreurs['password']}</span>
        </div>
        <div class="registration_paragraph">
            <label id="passwordConfirmed-L" for="passwordConfirmed-L">Confirmer le mot de passe :</label><br><input type="password" id="passwordConfirmed" name="passwordConfirmed" value="" title="Confirmer mot de passe" style="width: 100%">
        </div>
        <div id="preferredGames-D" class="registration_paragraph">
            <label id="preferredGames-L" for="preferredGames">Jeux préférés :</label><br><textarea id="preferredGames" name="preferredGames" title="Jeux préférés" style="width: 100%" placeholder="ex : Minecraft, Legends of Runeterra, Darkest Dungeons"></textarea>
        </div>
        <div id="birthdate-D" class="registration_paragraph">
            <label id="birthdate-L" for="birthdate">Date de naissance (jj-mm-aaaa) : </label><br>
            <input type="text" id="birthdate" name="birthdate_day" value="" autoformat="##" title="Date de naissance (jj)" style="width: 32%" placeholder="ex : 02">/
            <input type="text" id="tfa_6980290244514" name="birthdate_month" value="" autoformat="##" title="Date de naissance (mm) " style="width: 32%" placeholder="ex : 11">/
            <input type="text" id="tfa_6980290244513" name="birthdate_year" value="" autoformat="####" title="Date de naissance (aaaa)" style="width: 32%" placeholder="ex : 2003">
        </div>
        <input type="submit" value="Confirmer" id="Confirmation" class="button">
        <a href="/JEEux_fr/accueil"><input type="button" value="Annuler" class="button"></a>
        <a href="/JEEux_fr/authentification"><input type="button" value="skip (debug)" class="button"></a>
    </div>
</fieldset>
</form>
</body>
</html>
