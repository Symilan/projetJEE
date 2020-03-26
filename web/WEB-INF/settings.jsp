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
    <title>Réglages</title>
    <link rel="stylesheet" href="ressources/style.css" />
</head>
<body class="main">
<fieldset id="tfa_Address" class="left_side">
    <legend id="tfa_Address-L"><b>Informations personnelles </b></legend>
    <div id="tfa_6980290244516">
        <div id="tfa_6980290243481-D" class="registration_paragraph">
            <label id="tfa_6980290243481-L" for="tfa_6980290243481">Pseudo :</label><br><input type="text" id="tfa_6980290243481" name="tfa_6980290243481" value="" title="Pseudo" style="width: 100%">
        </div>
        <div id="tfa_6980290243482-D" class="registration_paragraph">
            <label id="tfa_6980290243482-L" for="tfa_6980290243482">Adresse mail :</label><br><input type="text" id="tfa_6980290243482" name="tfa_6980290243482" value="" title="Adresse mail" style="width: 100%">
        </div>
        <div id="tfa_6980290243489-D" class="registration_paragraph">
            <label id="tfa_6980290243489-L" for="tfa_6980290243489">Ancien mot de passe :</label><br><input type="text" id="tfa_6980290243489" name="tfa_6980290243489" value="" title="Ancien mot de passe" style="width: 100%">
        </div>
        <div id="tfa_6980290243483-D" class="registration_paragraph">
            <label id="tfa_6980290243483-L" for="tfa_6980290243483">Nouveau mot de passe :</label><br><input type="text" id="tfa_6980290243483" name="tfa_6980290243483" value="" title="Nouveau mot de passe" style="width: 100%">
        </div>
        <div id="tfa_6980290243484-D" class="registration_paragraph">
            <label id="tfa_6980290243484-L" for="tfa_6980290243481">Confirmer nouveau mot de passe :</label><br><input type="text" id="tfa_6980290243484" name="tfa_6980290243484" value="" title="Confirmer nouveau mot de passe" style="width: 100%">
        </div>
        <div id="tfa_6980290244525-D" class="registration_paragraph">
            <label id="tfa_6980290244525-L" for="tfa_6980290244525">Jeux préférés :</label><br><textarea id="tfa_6980290244525" name="tfa_6980290244525" title="Jeux préférés" style="width: 100%"></textarea>
        </div>
        <div id="tfa_6980290244512-D" class="registration_paragraph">
            <label id="tfa_6980290244512-L" for="tfa_6980290244512">Date de naissance (jj-mm-aaaa) :</label><br>
            <input type="text" id="tfa_6980290244512" name="tfa_6980290244512" value="" autoformat="##" title="Date de naissance (jj) " disabled style="width: 32%">/
            <input type="text" id="tfa_6980290244514" name="tfa_6980290244514" value="" autoformat="##" title="Date de naissance (mm) " disabled style="width: 32%">/
            <input type="text" id="tfa_6980290244513" name="tfa_6980290244513" value="" autoformat="####" title="Date de naissance (aaaa)" disabled style="width: 32%"></div>
        </div><br>
        <input type="button" value="Modifier" class="button">
        <a href="/JEEux_fr/listeDesJeux"><input type="button" value="Annuler" class="button"></a>
        <a href="/JEEux_fr/accueil"><input type="button" value="Déconnexion" class="button"></a>
    </div>
</fieldset>
</body>
</html>
