<%@ page import="model.Player" %><%--
  Created by IntelliJ IDEA.
  User: virgi
  Date: 13/03/2020
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentification</title>
    <link rel="stylesheet" href="ressources/style.css" />
</head>
<body class="main">
<form method="post" action="authentification">
<fieldset id="tfa_Address">
    <legend><b>Connexion </b></legend>
    <div class="to_the_right">
        <div>
            <label id="pseudo-L" class="label preField reqMark" for="pseudo">Pseudo :</label><input type="text" id="pseudo" name="pseudo" value="${pseudo}" title="Pseudo" class="auth_field">
            <label id="password-L" class="label preField reqMark" for="password">Mot de passe :</label><input type="password" id="password" name="password" value="" title="Mot de passe" class="auth_field">
            <span class="erreur">${error}</span>
        </div>
        <a href="/JEEux_fr/enregistrement" class="hyperlink"><p>Pas encore de compte ? Inscris toi...</p></a>
        <input type="submit" value="S'authentifier" class="button">
        <a href="/JEEux_fr/accueil" ><input type="button" value="Annuler" class="button"></a>
    </div>
</fieldset>
</form>
</body>
</html>
