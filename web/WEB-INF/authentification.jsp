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
            <label id="tfa_6980290243481-L" class="label preField reqMark" for="tfa_6980290243481">Pseudo :</label><input type="text" id="tfa_6980290243481" name="tfa_6980290243481" value="<% Player player = (Player) request.getAttribute("player"); if (player!=null) out.println(player.getPseudo()); %>" aria-required="true" title="Pseudo" class="auth_field">
            <label id="tfa_6980290243483-L" class="label preField reqMark" for="tfa_6980290243483">Mot de passe :</label><input type="text" id="tfa_6980290243483" name="tfa_6980290243483" value="" aria-required="true" title="Mot de passe" class="auth_field">
        </div>
        <a href="/JEEux_fr/enregistrement" class="hyperlink"><p>Pas encore de compte ? Inscris toi...</p></a>
        <input type="submit" value="S'authentifier" class="button">
        <a href="/JEEux_fr/accueil" ><input type="button" value="Annuler" class="button"></a>
        <a href="/JEEux_fr/listeDesJeux"><input type="button" value="skip(debug)" class="button"></a>
    </div>
</fieldset>
</form>
</body>
</html>
