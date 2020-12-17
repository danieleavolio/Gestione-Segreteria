window.addEventListener("load", function () {
    //inizializza()
    registraEventi()
});
var tuttiStudenti = new Array();

function Studente(matricola, nome, cognome, email) {
    this.matricola = matricola;
    this.cognome = cognome;
    this.nome = nome;
    this.email = email;
}

function inizializza() {
    var studente1 = new Studente(201018, "Daniele", "Avolio", "daniele.avolio@gmail.com");
    aggiungiStudente(studente1);
    tuttiStudenti.push(studente1);
    var studente2 = new Studente(201912, "Alex", "Fazio", "alex.fazio@jetbrains.com");
    aggiungiStudente(studente2)
    tuttiStudenti.push(studente2);
    var studente3 = new Studente(201917, "Simone", "Bilotta", "simonebilotta.curingone@gmail.com");
    aggiungiStudente(studente3);
    tuttiStudenti.push(studente3);
    var studente4 = new Studente(201922, "Domenico Nicodemo", "Panetta", "ddannidoro@gmail.com");
    aggiungiStudente(studente4);
    tuttiStudenti.push(studente4);

}

//Genera lo studente e lo manda ad aggiungiStudente
function registraStudente() {


    var matr = document.querySelector("#matricola").value;
    var nom = document.querySelector("#nome").value;
    var cogn = document.querySelector("#cognome").value;
    var d = document.querySelector("#dataNascita").value;
    var scuola = document.querySelector("#idScuola").value;

    $.ajax({
        url: "iscriviStudente",
        method: "POST",
        data: {matr: matr, nome: nom, cognome: cogn, date: d, scuolaId: scuola},
        success: function (response){ //se la mia chiamata restituisce un codice 200m ( tutto ok ) chiama la funzione giu
            if (response === "SUCCESS"){
                var studente = new Studente(matr, nom, cogn, d, scuola);
                aggiungiStudente(studente);
            }
            alert(response);
        },
        fail: function (jqHXR, textStatus){
            alert ("Request failed: " + textStatus);
        }
    });


}

function registraEventi() {
    var bottoneIscrivi = document.getElementById("idIscrivi");
    bottoneIscrivi.addEventListener("click", registraStudente);
    var bottoneRiordina = document.getElementById("sort");
    bottoneRiordina.addEventListener("click", sortStudents);
}

//Si prende lo studente e poi lo aggiunge
function aggiungiStudente(studente) {
    if (isInside(studente)) {
        alert("Studente già inserito. Impossibile aggiungere")
        return;
    }
    tuttiStudenti.push(studente);

    var table = document.querySelector(".table");
    var row = table.insertRow(-1);
    var matricola = row.insertCell(0);
    var nome = row.insertCell(1);
    var cognome = row.insertCell(2);
    var email = row.insertCell(3);

    nome.textContent = studente.nome;
    cognome.textContent = studente.cognome;
    matricola.textContent = studente.matricola;
    email.textContent = studente.email;
}

function sortStudents() {
    var table = document.getElementById(("tabellaStud"));
    var righe, x, y, riordinando, daRiordinare;
    //parto dicendo che va ordinato
    riordinando = true;
    while (riordinando) {
        //per ora lo fermo perche se poi non devo ordinare, esco
        riordinando = false;
        //mi predno le righe
        righe = table.rows;
        //adessp scorriamo le righe
        for (var i = 1; i < (righe.length - 1); i++) {
            daRiordinare = false;
            x = righe[i].getElementsByTagName("TD")[0];
            y = righe[i + 1].getElementsByTagName("TD")[0];
            //controllaimo se vanno scambiati
            if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                daRiordinare = true;
                break;
            }
        }
        //se vanno scambiati, gli cambio la posizione
        if (daRiordinare) {
            righe[i].parentNode.insertBefore(righe[i + 1], righe[i]);
            riordinando = true;
        }
    }
}

function isInside(studente) {
    for (let i = 0; i < tuttiStudenti.length; i++) {
        if (tuttiStudenti[i].matricola == studente.matricola) {
            return true;
        }
    }

    return false;
}