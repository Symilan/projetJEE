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
    <link rel="stylesheet" href="style.css" />
</head>
<body>
<fieldset id="tfa_Address" class="section">
    <legend id="tfa_Address-L"><b>Information de base </b></legend>
    <div id="tfa_6980290244516" class="section inline group">
        <div class="mandatory-field    " id="pseudo-D">
            <label id="pseudo-L" class="label preField reqMark" for="pseudo">Pseudo</label><br><div class="inputWrapper"><input type="text" id="pseudo" name="pseudo" value="" aria-required="true" title="Pseudo" class="required"></div>
        </div>
        <div class="mandatory-field    " id="mailAdress-D">
            <label id="mailAdress-L" class="label preField reqMark" for="mailAdress-L">Adresse mail</label><br><div class="inputWrapper"><input type="text" id="mailAdress" name="mailAdress" value="" aria-required="true" title="Adresse mail" class="required"></div>
        </div>
        <div class="mandatory-field    " id="password-D">
            <label id="password-L" class="label preField reqMark" for="password-L">Mot de passe</label><br><div class="inputWrapper"><input type="text" id="password" name="password" value="" aria-required="true" title="Mot de passe" class="required"></div>
        </div>
        <div class="mandatory-field    " id="passwordConfirmed-D">
            <label id="passwordConfirmed-L" class="label preField reqMark" for="passwordConfirmed-L">Confirmer mot de passe</label><br><div class="inputWrapper"><input type="text" id="passwordConfirmed" name="passwordConfirmed" value="" aria-required="true" title="Confirmer mot de passe" class="required"></div>
        </div>
        <div class="mandatory-field    " id="preferredGames-D">
            <label id="preferredGames-L" class="label preField " for="preferredGames">Jeux préférés</label><br><div class="inputWrapper"><textarea id="preferredGames" name="preferredGames" title="Jeux préférés" class=""></textarea></div>
        </div>
        <div class="mandatory-field    " id="birthdate-D">
            <label id="birthdate-L" class="label preField reqMark" for="birthdate">Date de naissance (jj-mm-aaaa) </label><br><div class="inputWrapper"><input type="text" id="birthdate" name="birthdate" value="" aria-required="true" autoformat="##" title="Date de naissance (jj) " class="calc-DOB required">/<input type="text" id="tfa_6980290244514" name="tfa_6980290244514" value="" aria-required="true" autoformat="##" title="Date de naissance (mm) " class="calc-DOB required">/<input type="text" id="tfa_6980290244513" name="tfa_6980290244513" value="" aria-required="true" autoformat="####" title="Date de naissance (aaaa) " class="calc-DOB required"></div>
        </div><br>
        <input type="button" value="Confirmer">
        <input type="button" value="Annuler">
    </div>
</fieldset>
</body>
</html>