<%--
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
    <link rel="stylesheet" href="style.css" />
</head>
<body>
<fieldset id="tfa_Address" class="section">
    <legend id="tfa_Address-L"><b>Information de base </b></legend>
    <div id="tfa_6980290244516" class="section inline group">
        <div class="oneField field-container-D    " id="tfa_6980290243481-D">
            <label id="tfa_6980290243481-L" class="label preField reqMark" for="tfa_6980290243481">Pseudo</label><br><div class="inputWrapper"><input type="text" id="tfa_6980290243481" name="tfa_6980290243481" value="" aria-required="true" title="Pseudo" class="required"></div>
        </div>
        <div class="oneField field-container-D    " id="tfa_6980290243483-D">
            <label id="tfa_6980290243483-L" class="label preField reqMark" for="tfa_6980290243483">Mot de passe</label><br><div class="inputWrapper"><input type="text" id="tfa_6980290243483" name="tfa_6980290243483" value="" aria-required="true" title="Mot de passe" class="required"></div>
        </div>
        <a href="/JEEux_fr/enregistrement"><p>Pas encore de compte ? Inscris toi...</p></a>
        <input type="button" value="S'authentifier">
        <a href="/JEEux_fr/accueil"><input type="button" value="Annuler"></a>
        <a href="/JEEux_fr/listeDesJeux"><input type="button" value="skip(debug)"></a>
    </div>
</fieldset>
</body>
</html>
