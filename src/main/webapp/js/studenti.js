

function iscriviStudente(){

    var table = document.getElementById("tabellaStud");
    var row = table.insertRow(-1);
    var matricola = row.insertCell(0);
    var nome = row.insertCell(1);
    var cognome= row.insertCell(2);

    nome.innerHTML =  document.getElementById("nome").value;
    cognome.innerHTML =  document.getElementById("cognome").value;
    matricola.innerHTML =  document.getElementById("matricola").value;
}

function sortStudents(){

}