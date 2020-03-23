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
    <style>
        body {
            font-family: "Lato", sans-serif;
        }

        .sidenav {
            height: 100%;
            width: 160px;
            position: absolute;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #111;
            overflow-x: hidden;
            padding-top: 20px;
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
            overflow-y: scroll;
            scrollbar-color: rebeccapurple green;
            scrollbar-width: thin;
            width: 100%;
            height: 92%;
            position: absolute;
            bottom: 0;
        }

        .main {
            margin-left: 160px; /* Same as the width of the sidenav */
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
        }

        @media screen and (max-height: 450px) {
            .sidenav {padding-top: 15px;}
            .sidenav a {font-size: 18px;}
        }
    </style>
</head>
<div class="sidenav">
    <div id="infos_joueur" class="info_corner">
        Infos Joueur
    </div>
    <div id="liste jeux" class="scroll">
        <a href="">Jeu1</a>
        <a href="">Jeu2</a>
        <a href="">Jeu3</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
        <a href="">Jeu4</a>
    </div>
</div>
<div class="main" style="margin-left: 160px;">
    <p>Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem Ipsem </p>
</div>
</html>
