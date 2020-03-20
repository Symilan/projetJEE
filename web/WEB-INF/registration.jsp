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
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="style.css"/>
</head>
<body>
<fieldset id="tfa_Address" class="section">
    <legend id="tfa_Address-L"><b>Information de base </b></legend>
    <div id="tfa_6980290244516" class="section inline group">
        <div class="oneField field-container-D    " id="tfa_6980290243487-D">
            <label id="tfa_6980290243487-L" class="label preField reqMark" for="tfa_6980290243487">Nom </label><br>
            <div class="inputWrapper"><input type="text" id="tfa_6980290243487" name="tfa_6980290243487" value=""
                                             aria-required="true" title="Nom " class="required"></div>
        </div>
        <div class="oneField field-container-D    " id="tfa_6980290243481-D">
            <label id="tfa_6980290243481-L" class="label preField reqMark" for="tfa_6980290243481">Prénom</label><br>
            <div class="inputWrapper"><input type="text" id="tfa_6980290243481" name="tfa_6980290243481" value=""
                                             aria-required="true" title="Prénom" class="required"></div>
        </div>
        <div class="oneField field-container-D    " id="tfa_6980290243483-D" role="radiogroup"
             aria-labelledby="tfa_6980290243483-L" data-tfa-labelledby="-L tfa_6980290243483-L">
            <label id="tfa_6980290243483-L" class="label preField reqMark">Sexe</label><br>
            <div class="inputWrapper"><span id="tfa_6980290243483" class="choices  required"><span
                    class="oneChoice"><input type="radio" value="tfa_6980290243485" class="" id="tfa_6980290243485"
                                             name="tfa_6980290243483" aria-required="true"
                                             aria-labelledby="tfa_6980290243485-L"
                                             data-tfa-labelledby="tfa_6980290243483-L tfa_6980290243485-L"><label
                    class="label postField" id="tfa_6980290243485-L" for="tfa_6980290243485"><span
                    class="input-radio-faux"></span>F</label></span><span class="oneChoice"><input type="radio"
                                                                                                   value="tfa_6980290243486"
                                                                                                   class=""
                                                                                                   id="tfa_6980290243486"
                                                                                                   name="tfa_6980290243483"
                                                                                                   aria-required="true"
                                                                                                   aria-labelledby="tfa_6980290243486-L"
                                                                                                   data-tfa-labelledby="tfa_6980290243483-L tfa_6980290243486-L"><label
                    class="label postField" id="tfa_6980290243486-L" for="tfa_6980290243486"><span
                    class="input-radio-faux"></span>H</label></span></span></div>
        </div>
    </div>
    <div id="tfa_6980290244517" class="section inline group">
        <div class="oneField field-container-D    " id="tfa_6980290244512-D">
            <label id="tfa_6980290244512-L" class="label preField reqMark" for="tfa_6980290244512">Date de naissance
                (aaaa-mm-jj) </label><br>
            <div class="inputWrapper"><input type="text" id="tfa_6980290244512" name="tfa_6980290244512" value=""
                                             aria-required="true" autoformat="####-##-##"
                                             title="Date de naissance (aaaa-mm-jj) " class="calc-DOB required"></div>
        </div>
        <input type="hidden" id="tfa_6980290244495" name="tfa_6980290244495" value="0" class="formula=_calcAge(DOB)">
    </div>
    <div class="oneField field-container-D    " id="tfa_6980290243388-D" role="radiogroup"
         aria-labelledby="tfa_6980290243388-L" data-tfa-labelledby="-L tfa_6980290243388-L">
        <label id="tfa_6980290243388-L" class="label preField reqMark">Citoyenneté</label><br>
        <div class="inputWrapper"><span id="tfa_6980290243388" class="choices vertical required"><span
                class="oneChoice"><input type="radio" value="tfa_6980290243389" class="" id="tfa_6980290243389"
                                         name="tfa_6980290243388" aria-required="true"
                                         aria-labelledby="tfa_6980290243389-L"
                                         data-tfa-labelledby="tfa_6980290243388-L tfa_6980290243389-L"><label
                class="label postField" id="tfa_6980290243389-L" for="tfa_6980290243389"><span
                class="input-radio-faux"></span>Canadienne</label></span><span class="oneChoice"><input type="radio"
                                                                                                        value="tfa_6980290243390"
                                                                                                        class=""
                                                                                                        id="tfa_6980290243390"
                                                                                                        name="tfa_6980290243388"
                                                                                                        aria-required="true"
                                                                                                        aria-labelledby="tfa_6980290243390-L"
                                                                                                        data-tfa-labelledby="tfa_6980290243388-L tfa_6980290243390-L"><label
                class="label postField" id="tfa_6980290243390-L" for="tfa_6980290243390"><span
                class="input-radio-faux"></span>Résidence permanente</label></span><span class="oneChoice"><input
                type="radio" value="tfa_6980290243391" class="" id="tfa_6980290243391" name="tfa_6980290243388"
                aria-required="true" aria-labelledby="tfa_6980290243391-L"
                data-tfa-labelledby="tfa_6980290243388-L tfa_6980290243391-L"><label class="label postField"
                                                                                     id="tfa_6980290243391-L"
                                                                                     for="tfa_6980290243391"><span
                class="input-radio-faux"></span>Autre</label></span></span></div>
    </div>
    <div class="oneField field-container-D    " id="tfa_6980290244525-D">
        <label id="tfa_6980290244525-L" class="label preField " for="tfa_6980290244525">Lieu de naissance:</label><br>
        <div class="inputWrapper"><textarea id="tfa_6980290244525" name="tfa_6980290244525" title="Lieu de naissance:"
                                            class=""></textarea></div>
    </div>
    <div class="oneField field-container-D    " id="tfa_StreetAddress-D">
        <label id="tfa_StreetAddress-L" class="label preField reqMark" for="tfa_StreetAddress">Adresse
            civique </label><br>
        <div class="inputWrapper"><input type="text" id="tfa_StreetAddress" name="tfa_StreetAddress" value=""
                                         aria-required="true" title="Adresse civique " class="required"></div>
    </div>
    <div id="tfa_6980290243962" class="section inline group">
        <div class="oneField field-container-D    " id="tfa_City-D">
            <label id="tfa_City-L" class="label preField reqMark" for="tfa_City">Ville</label><br>
            <div class="inputWrapper"><input type="text" id="tfa_City" name="tfa_City" value="" aria-required="true"
                                             title="Ville" class="required"></div>
        </div>
        <div class="oneField field-container-D    " id="tfa_6980290243331-D">
            <label id="tfa_6980290243331-L" class="label preField reqMark" for="tfa_6980290243331">Province</label><br>
            <div class="inputWrapper"><select id="tfa_6980290243331" name="tfa_6980290243331" title="Province"
                                              aria-required="true" class="required">
                <option value="">Choisir</option>
                <option value="tfa_6980290243337" id="tfa_6980290243337" class="">Québec</option>
                <option value="tfa_6980290243333" id="tfa_6980290243333" class="">Alberta</option>
                <option value="tfa_6980290243381" id="tfa_6980290243381" class="">Colombie-Britannique</option>
                <option value="tfa_6980290243373" id="tfa_6980290243373" class="">Île-du-Prince-Édouard</option>
                <option value="tfa_6980290243341" id="tfa_6980290243341" class="">Manitoba</option>
                <option value="tfa_6980290243345" id="tfa_6980290243345" class="">Nouveau-Brunswick</option>
                <option value="tfa_6980290243369" id="tfa_6980290243369" class="">Nunavut</option>
                <option value="tfa_6980290243349" id="tfa_6980290243349" class="">Nouvelle-Écosse</option>
                <option value="tfa_6980290243377" id="tfa_6980290243377" class="">Ontario</option>
                <option value="tfa_6980290243353" id="tfa_6980290243353" class="">Saskatchewan</option>
                <option value="tfa_6980290243357" id="tfa_6980290243357" class="">Terre-Neuve et Labrador</option>
                <option value="tfa_6980290243361" id="tfa_6980290243361" class="">Territoire du Nord-Ouest</option>
                <option value="tfa_6980290243365" id="tfa_6980290243365" class="">Yukon</option>
            </select></div>
        </div>
        <div class="oneField field-container-D    " id="tfa_Zip-D">
            <label id="tfa_Zip-L" class="label preField reqMark" for="tfa_Zip">Code postal </label><br>
            <div class="inputWrapper"><input type="text" id="tfa_Zip" name="tfa_Zip" value="" aria-required="true"
                                             title="Code postal " class="required"></div>
        </div>
    </div>
    <div class="oneField field-container-D    " id="tfa_EmailAddress-D">
        <label id="tfa_EmailAddress-L" class="label preField " for="tfa_EmailAddress">Adresse courriel </label><br>
        <div class="inputWrapper"><input type="text" id="tfa_EmailAddress" name="tfa_EmailAddress" value=""
                                         title="Adresse courriel " class="validate-email">
            <div id="pwm-inline-icon-51101" class="pwm-field-icon"
                 style="position: absolute !important; width: 18px !important; height: 18px !important; min-height: 0px !important; min-width: 0px !important; z-index: 2147483645 !important; box-shadow: none !important; box-sizing: content-box !important; background: none !important; border: none !important; padding: 0px !important; cursor: pointer !important; outline: none !important; margin-top: -19.5px; margin-left: 292px;">
                <svg style="display: inline-block !important; width: 16px !important; height: 16px !important; fill: rgb(230, 0, 23) !important; margin-top: 0.5px !important; position: absolute !important; top: 0px !important; left: 0px !important;"
                     viewBox="0 0 40 64">
                    <g>
                        <path d="m20,28.12a33.78,33.78 0 0 1 13.36,2.74a22.18,22.18 0 0 1 0.64,5.32c0,9.43 -5.66,17.81 -14,20.94c-8.34,-3.13 -14,-11.51 -14,-20.94a22.2,22.2 0 0 1 0.64,-5.32a33.78,33.78 0 0 1 13.36,-2.74m0,-28.12c-8.82,0 -14,7.36 -14,16.41l0,5.16c2,-1.2 2,-1.49 5,-2.08l0,-3.08c0,-6.21 2.9,-11.41 8.81,-11.41l0.19,0c6.6,0 9,4.77 9,11.41l0,3.08c3,0.58 3,0.88 5,2.08l0,-5.16c0,-9 -5.18,-16.41 -14,-16.41l0,0zm0,22c-6.39,0 -12.77,0.67 -18.47,4a31.6,31.6 0 0 0 -1.53,9.74c0,13.64 8.52,25 20,28.26c11.48,-3.27 20,-14.63 20,-28.26a31.66,31.66 0 0 0 -1.54,-9.77c-5.69,-3.3 -12.08,-4 -18.47,-4l0,0l0.01,0.03z"></path>
                        <path d="m21.23,39.5a2.81,2.81 0 0 0 1.77,-2.59a2.94,2.94 0 0 0 -3,-2.93a3,3 0 0 0 -3,3a2.66,2.66 0 0 0 1.77,2.48l-1.77,4.54l6,0l-1.77,-4.5z"></path>
                    </g>
                </svg>
            </div>
        </div>
    </div>
    <div id="tfa_HomePhone" class="section inline group">
        <label class="label preField" id="tfa_HomePhone-L">Numéros de téléphone</label><br>
        <div class="oneField field-container-D    " id="tfa_6980290244518-D">
            <label id="tfa_6980290244518-L" class="label preField " for="tfa_6980290244518">Domicile</label><br>
            <div class="inputWrapper"><input type="text" id="tfa_6980290244518" name="tfa_6980290244518" value=""
                                             title="Domicile" class=""></div>
        </div>
        <div class="oneField field-container-D    " id="tfa_6980290244519-D">
            <label id="tfa_6980290244519-L" class="label preField " for="tfa_6980290244519">Cellulaire</label><br>
            <div class="inputWrapper"><input type="text" id="tfa_6980290244519" name="tfa_6980290244519" value=""
                                             title="Cellulaire" class=""></div>
        </div>
        <div class="oneField field-container-D    " id="tfa_6980290244520-D">
            <label id="tfa_6980290244520-L" class="label preField " for="tfa_6980290244520">Travail</label><br>
            <div class="inputWrapper"><input type="text" id="tfa_6980290244520" name="tfa_6980290244520" value=""
                                             title="Travail" class=""></div>
        </div>
    </div>
    <div class="oneField field-container-D    " id="tfa_Preferrednumber-D" role="radiogroup"
         aria-labelledby="tfa_Preferrednumber-L" data-tfa-labelledby="-L tfa_Preferrednumber-L">
        <label id="tfa_Preferrednumber-L" class="label preField reqMark">Numéro de téléphone préféré </label><br>
        <div class="inputWrapper"><span id="tfa_Preferrednumber" class="choices oneChoicePerLine required"><span
                class="oneChoice"><input type="radio" value="tfa_HomePhone1" class="" id="tfa_HomePhone1"
                                         name="tfa_Preferrednumber" aria-required="true"
                                         aria-labelledby="tfa_HomePhone1-L"
                                         data-tfa-labelledby="tfa_Preferrednumber-L tfa_HomePhone1-L"><label
                class="label postField" id="tfa_HomePhone1-L" for="tfa_HomePhone1"><span
                class="input-radio-faux"></span>Domicile</label></span><span class="oneChoice"><input type="radio"
                                                                                                      value="tfa_CellPhone1"
                                                                                                      class=""
                                                                                                      id="tfa_CellPhone1"
                                                                                                      name="tfa_Preferrednumber"
                                                                                                      aria-required="true"
                                                                                                      aria-labelledby="tfa_CellPhone1-L"
                                                                                                      data-tfa-labelledby="tfa_Preferrednumber-L tfa_CellPhone1-L"><label
                class="label postField" id="tfa_CellPhone1-L" for="tfa_CellPhone1"><span
                class="input-radio-faux"></span>Cellulaire</label></span><span class="oneChoice"><input type="radio"
                                                                                                        value="tfa_6980290243409"
                                                                                                        class=""
                                                                                                        id="tfa_6980290243409"
                                                                                                        name="tfa_Preferrednumber"
                                                                                                        aria-required="true"
                                                                                                        aria-labelledby="tfa_6980290243409-L"
                                                                                                        data-tfa-labelledby="tfa_Preferrednumber-L tfa_6980290243409-L"><label
                class="label postField" id="tfa_6980290243409-L" for="tfa_6980290243409"><span
                class="input-radio-faux"></span>Travail</label></span></span></div>
    </div>
    <div class="oneField field-container-D    " id="tfa_6980290243410-D" role="group"
         aria-labelledby="tfa_6980290243410-L" data-tfa-labelledby="-L tfa_6980290243410-L">
        <label id="tfa_6980290243410-L" class="label preField reqMark"
               aria-label="Statut professionnel  &nbsp; obligatoire">Statut professionnel </label><br>
        <div class="inputWrapper"><span id="tfa_6980290243410" class="choices  required"><span class="oneChoice"><input
                type="checkbox" value="tfa_6980290243411" class="" id="tfa_6980290243411" name="tfa_6980290243411"
                aria-labelledby="tfa_6980290243411-L"
                data-tfa-labelledby="tfa_6980290243410-L tfa_6980290243411-L"><label class="label postField"
                                                                                     id="tfa_6980290243411-L"
                                                                                     for="tfa_6980290243411"><span
                class="input-checkbox-faux"></span>&nbsp;Retraité&nbsp;</label></span><span class="oneChoice"><input
                type="checkbox" value="tfa_6980290243412" class="" id="tfa_6980290243412" name="tfa_6980290243412"
                aria-labelledby="tfa_6980290243412-L"
                data-tfa-labelledby="tfa_6980290243410-L tfa_6980290243412-L"><label class="label postField"
                                                                                     id="tfa_6980290243412-L"
                                                                                     for="tfa_6980290243412"><span
                class="input-checkbox-faux"></span>Pré retraité&nbsp;</label></span><span class="oneChoice"><input
                type="checkbox" value="tfa_6980290243413" class="" id="tfa_6980290243413" name="tfa_6980290243413"
                aria-labelledby="tfa_6980290243413-L"
                data-tfa-labelledby="tfa_6980290243410-L tfa_6980290243413-L"><label class="label postField"
                                                                                     id="tfa_6980290243413-L"
                                                                                     for="tfa_6980290243413"><span
                class="input-checkbox-faux"></span>&nbsp;Je travaille actuellement à temps plein</label></span><span
                class="oneChoice"><input type="checkbox" value="tfa_6980290243414" class="" id="tfa_6980290243414"
                                         name="tfa_6980290243414" aria-labelledby="tfa_6980290243414-L"
                                         data-tfa-labelledby="tfa_6980290243410-L tfa_6980290243414-L"><label
                class="label postField" id="tfa_6980290243414-L" for="tfa_6980290243414"><span
                class="input-checkbox-faux"></span>&nbsp;Je travaille actuellement à temps partiel</label></span><span
                class="oneChoice"><input type="checkbox" value="tfa_6980290243488" class="" id="tfa_6980290243488"
                                         name="tfa_6980290243488" data-conditionals="#tfa_6980290244521"
                                         aria-labelledby="tfa_6980290243488-L"
                                         data-tfa-labelledby="tfa_6980290243410-L tfa_6980290243488-L"><label
                class="label postField" id="tfa_6980290243488-L" for="tfa_6980290243488"><span
                class="input-checkbox-faux"></span>&nbsp;Autre</label></span></span></div>
    </div>
    <div class="oneField field-container-D     offstate" id="tfa_6980290244521-D">
        <label id="tfa_6980290244521-L" class="label preField reqMark" for="tfa_6980290244521">Si vous avez coché
            «Autre», veuillez préciser:</label><br>
        <div class="inputWrapper"><input type="text" id="tfa_6980290244521" name="tfa_6980290244521" value=""
                                         aria-required="true" data-condition="`#tfa_6980290243488`"
                                         title="Si vous avez coché «Autre», veuillez préciser:" class="required"
                                         disabled=""></div>
    </div>
</fieldset>
</body>
</html>
