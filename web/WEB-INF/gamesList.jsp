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
    <style>
        .sidenav {
            height: 100%;
            width: 256px;
            position: absolute;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: rgba(0, 0, 0, 0.79);
            overflow-x: hidden;
            padding-top: 250px;
            display: flex;
            flex-direction: row;
        }

        .sidenav a {
            padding: 6px 8px 6px 16px;
            text-decoration: none;
            font-size: 25px;
            color: #818181;
            display: block;
        }

        .sidenav a:hover {
            color: #f1f1f1;
        }

        .scroll{
            width: 100%;
            height: 92%;
            position: absolute;
            bottom: 0;
        }

        .main {
            margin-left: 250px; /* Same as the width of the sidenav */
            font-size: 28px; /* Increased text to enable scrolling */
            padding: 0px 10px;
        }

        .info_corner {
            font-size: 26px;
            color : #147020;
            border: 3px solid #8AC007;
            position : fixed;
            top : 0;
            background-color: teal;
            height: 7%;
            width: 250px;
        }

        .flexbox{
            display: flex;
            flex-direction: column;
        }

        @media screen and (max-height: 450px) {
            .sidenav {padding-top: 15px;}
            .sidenav a {font-size: 18px;}
        }
    </style>
</head>
<div class="sidenav">
    <div class="flexbox">
        <div id="infos_joueur" class="info_corner">
            ${player.pseudo}
            <a href="reglages"><img src="ressources/settings_wheel.png" style="height:30px; filter: invert(50%)"></a>
        </div>
    </div>
    <div id="liste jeux" class="scroll">
        <%
            ArrayList<model.Game> gameList = (ArrayList<model.Game>) request.getAttribute("gameList");
            for (Game game : gameList)
            {
                out.println("<a href=<\"\">"+game.getName()+"</a>");
            }
        %>
    </div>
</div>
<div class="main" style="margin-left: 160px; position: fixed">
    <ul>

    </ul>
</div>
</html>
