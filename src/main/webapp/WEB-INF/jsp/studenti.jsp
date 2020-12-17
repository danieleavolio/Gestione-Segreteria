<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="../../js/studenti.js"></script>

    <meta charset="UTF-8">
    <title>Elenco studenti</title>
</head>
<body>
<h2>Elenco Studenti</h2>
<div class="table-responsive">
    <table class="table table-bordered table-hover" id="tabellaStud">
        <thead class="thead-dark">
            <tr>
                <th>Matricola</th>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Data di Nascita</th>
                <th>Scuola di Diploma</th>

               <!-- <th>Email</th> -->
            </tr>
        </thead>
        <tbody>
            <c:forEach var="stud" items="${listStudenti}">
                <tr class="table">
                    <!--<td><input type="checkbox" id = "${stud.matricola}" name ="${stud.matricola}" value="${stud.matricola}"></td> -->

                    <td> ${stud.matricola}</td>
                    <td> ${stud.nome}</td>
                    <td> ${stud.cognome}</td>
                    <td> ${stud.dataNascita}</td>
                    <td> ${stud.scuola.id}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<form method="get" action="">
    <div class="form-group">
        <label for="matricola">Matricola:</label>
        <input type="number" class="form-control" placeholder="Inserisci matricola" id="matricola" name="matricola">
    </div>
    <div class="form-group">
        <label for="Nome"> Nome: </label>
        <input type="text" class="form-control" placeholder="Inserisci nome" id="nome" name="nome"/>
    </div>
    <div class="form-group">
        <label> Cognome:</label>
        <input type="text" class="form-control" placeholder="Inserisci cognome" id="cognome" name="cognome"/>
    </div>
    <div class="form-group">
        <label> Data di Nascita:</label>
        <input type="date" class="form-control" placeholder="Inserisci data di nascita" id="dataNascita" name="dataNascita"/>
    </div>
    <div class="form-group">
        <label>Scuola:</label>
        <input type="text" class="form-control" placeholder="Inserisci la scuola" id="idScuola" name="idScuola"/>
    </div>
</form>
<div>
    <button id="idIscrivi" type="button" class="btn btn-primary">Iscrivi</button>
    <button id="sort" type="button" class="btn btn-warning">Ri-ordina</button>
</div>

</body>
</html>