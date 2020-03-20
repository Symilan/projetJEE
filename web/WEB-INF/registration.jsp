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
        <div class="oneField field-container-D    " id="tfa_6980290243481-D">
            <label id="tfa_6980290243481-L" class="label preField reqMark" for="tfa_6980290243481">Pseudo</label><br><div class="inputWrapper"><input type="text" id="tfa_6980290243481" name="tfa_6980290243481" value="" aria-required="true" title="Pseudo" class="required"></div>
        </div>
        <div class="oneField field-container-D    " id="tfa_6980290243482-D">
            <label id="tfa_6980290243482-L" class="label preField reqMark" for="tfa_6980290243482">Adresse mail</label><br><div class="inputWrapper"><input type="text" id="tfa_6980290243482" name="tfa_6980290243482" value="" aria-required="true" title="Adresse mail" class="required"></div>
        </div>
        <div class="oneField field-container-D    " id="tfa_6980290243483-D">
            <label id="tfa_6980290243483-L" class="label preField reqMark" for="tfa_6980290243483">Mot de passe</label><br><div class="inputWrapper"><input type="text" id="tfa_6980290243483" name="tfa_6980290243483" value="" aria-required="true" title="Mot de passe" class="required"></div>
        </div>
        <div class="oneField field-container-D    " id="tfa_6980290243484-D">
            <label id="tfa_6980290243484-L" class="label preField reqMark" for="tfa_6980290243481">Confirmer mot de passe</label><br><div class="inputWrapper"><input type="text" id="tfa_6980290243484" name="tfa_6980290243484" value="" aria-required="true" title="Confirmer mot de passe" class="required"></div>
        </div>
        <div class="oneField field-container-D    " id="tfa_6980290244525-D">
            <label id="tfa_6980290244525-L" class="label preField " for="tfa_6980290244525">Jeux préférés</label><br><div class="inputWrapper"><textarea id="tfa_6980290244525" name="tfa_6980290244525" title="Jeux préférés" class=""></textarea></div>
        </div>
        <div class="oneField field-container-D    " id="tfa_6980290244512-D">
            <label id="tfa_6980290244512-L" class="label preField reqMark" for="tfa_6980290244512">Date de naissance (jj-mm-aaaa) </label><br><div class="inputWrapper"><input type="text" id="tfa_6980290244512" name="tfa_6980290244512" value="" aria-required="true" autoformat="##" title="Date de naissance (jj) " class="calc-DOB required">/<input type="text" id="tfa_6980290244514" name="tfa_6980290244514" value="" aria-required="true" autoformat="##" title="Date de naissance (mm) " class="calc-DOB required">/<input type="text" id="tfa_6980290244513" name="tfa_6980290244513" value="" aria-required="true" autoformat="####" title="Date de naissance (aaaa) " class="calc-DOB required"></div>
        </div><br>
        <input type="button" value="Confirmer">
        <a href="/projetJEE2_war_exploded/accueil"><input type="button" value="Annuler"></a>
    </div>
</fieldset>
</body>
</html>
