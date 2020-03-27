<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Game" %>

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
    <title>Liste des jeux</title>
    <link rel="stylesheet" href="ressources/style.css" />
</head>
<body class="main">
<div class="sidenav">
    <div id="infos_joueur" class="info_corner">
        ${player.pseudo}
        <a href="reglages"><img src="ressources/settings_wheel.png" style="height:30px; filter: invert(65%)"></a>
    </div>
    <div id="liste jeux" class="scroll">
        <%
            ArrayList<model.Game> gameList = (ArrayList<model.Game>) request.getAttribute("gameList");
            for (Game game : gameList)
            {
                out.println("<form type=\"hidden\" method=\"post\" action=\"listeDesJeux\">");
                out.println("<a href=\"\"><input type=\"submit\" class=\"sidenav_button\" name=\""+game.getName()+"\" value=\""+game.getName()+"\"></a>");
                out.println("</form>");
            }
        %>
    </div>
</div>
<div class="main_panel">
    <div class="game_display">
        <p>
            ${empty selectedGame ? '' : selectedGame.name }
        </p>

        ${empty selectedGame ? '' : '<form method="get" type="hidden" action="jeu"><input type="submit" name="Jouer" value="Jouer !" class="button"></form>' }
    </div>
</div>
</body>
</html>
