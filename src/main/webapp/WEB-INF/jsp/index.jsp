<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../../css/home.css" type="text/css"/>

</head>
<body>
<h1>Home</h1>
<div class="row">
    <div class="col-lg-2 col-md-2">
        <figure>
            <figcaption><img src="../../images/segreteria.png"></figcaption>
            <figcaption class="sopraImmagine"><h3>La nostra segreteria studenti </h3></figcaption>
        </figure>
    </div>

    <div class="col-lg-6 col-lg-6">
        <h2 id="portale">  <strong> Portale segreteria Studenti </strong> </h2>
    </div>

    <div class="col-lg-2 col-md-2">
        <figure>
            <img src="../../images/logo_unical.png" width="200">
        </figure>
    </div>

    <div class="col-md-4 col-md-1">
        <c:if test="${usernameLogged == null}">
            <a href="" data-toggle="modal" data-target="#modalLoginForm"><h1>Login</h1></a>
        </c:if>
        <c:if test="${usernameLogged != null}">
            <h2 style="color:rebeccapurple">${usernameLogged} is logged</h2>
            <a href="doLogout"> <h3>Logout</h3></a>
        </c:if>

    </div>
</div>
<nav class="navbar navbar-expand-sm bg-dark">
    <!-- Links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Studenti</a>
            <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="GestioneStudenti/studenti.html">Elenco studenti</a></li>
                <li><a class="dropdown-item" href="../../GestioneStudenti/iscriviStudente.html">Iscrivi uno studente</a>
                </li>
                <li><a class="dropdown-item" href="../../GestioneStudenti/calcolaIsee.html">Calcola ISEE</a></li>
            </ul>
        </li>
        <li class="nav-item">
            <a class="nav-link dropdown-toggle" data-toggle="dropwdown" href="#">Corsi</a>
            <ul class="dropdown-menu">
                <li>Elenco corsi</li>
                <li>Corsi a numero aperto</li>
                <li>Corsi a numero chiuso</li>
            </ul>
        </li>
        <li class="nav-item">
            <a class="nav-link dropdown-toggle" data-toggle="dropwdown" href="#">Corsi di Laurea</a>
        </li>
        <li class="nav-item">
            <a class="nav-link dropdown-toggle" data-toggle="dropwdown" href="#">Dipartimenti</a>
        </li>
    </ul>
</nav>
<p id="p3">
<h3 id="benvenuto">Benvenuti nel portale di gestione delle Segreterie Studenti</h3>
</p>
<p id="p2">
<h5>Buona nagivazione</h5>
</p>
<p>
<h6>Finiamola in fretta</h6>
</p>
<section class="row">
    <article class="col-lg-5 col-md-45">
        <section class="jumbotron specifico">
            <h4>Dicono di noi</h4>
            <p id="p1">La segreteria è un servizio di riferimento che serve per..</p>
        </section>
    </article>
    <article class="col-lg-5 col-md-5">
        <section class="jumbotron">
            <h4>Centro ICT di Ateneo</h4>
            <p class="specifico">Dalla pagina accessibile da questo <a
                    href="https://www.unical.it/portale/strutture/centri/centroict/"> link </a></p>
        </section>
    </article>

</section>
<section class="row">
    <article class="col-lg-5 col-md-5">
        <section class="jumbotron">
            <h4>Dicono di noi</h4>
            <p>La segreteria è un servizio di riferimento che serve per..</p>
        </section>
    </article>
    <article class="col-lg-5 col-md-5">

        <section class="jumbotron">
            <h4>Dicono di noi</h4>
            <p>La segreteria è un servizio di riferimento che serve per..</p>
        </section>
    </article>
</section>
<footer>
    <p> Web Computing 2021 LTD</p>
</footer>
<div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <form method="POST" action="doLogin">
            <div class="modal-content">
                <div class="modal-header text-center">
                    <h4 class="modal-title w-100 font-weight-bold">Sign in</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body mx-3">
                    <div class="md-form mb-5">
                        <i class="fas fa-envelope prefix grey-text"></i>
                        <input type="text" id="defaultForm-email" class="form-control validate" name="username">
                        <label data-error="wrong" data-success="right" for="defaultForm-email">Username</label>
                    </div>

                    <div class="md-form mb-4">
                        <i class="fas fa-lock prefix grey-text"></i>
                        <input type="password" id="defaultForm-pass" class="form-control validate" name="password">
                        <label data-error="wrong" data-success="right" for="defaultForm-pass">Password</label>
                    </div>

                </div>
                <div class="modal-footer d-flex justify-content-center">
                    <button class="btn btn-default">Login</button>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="text-center">
    <a href="" class="btn btn-default btn-rounded mb-4" data-toggle="modal" data-target="#modalLoginForm">Launch
        Modal Login Form</a>
</div>
</body>
</html>