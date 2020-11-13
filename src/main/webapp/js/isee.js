/*
* chiedere il numero dei componenti del nucleo familiare
* */


function Studente (nome, cognome, matricola, numeroComponenti){
    this.nome = nome;
    this.cognome = cognome;
    this.matricola = matricola;
    this.numeroComponenti = numeroComponenti;
}

window.onload = function (){
    var stud = new Studente("Mario", "Rossi",123456, 2);
    var stud2 = new Studente("Dior", "Jador",543215,2);

    calcolaIsee(stud);
    calcolaIsee(stud2);

}
//Chiedere il numero di componenti denl nucelo familiare
function calcolaIsee(stud) {
    var numeroComponenti; // undefined
    //numeroComponenti = prompt("Inserisci il numero di componenti");
    numeroComponenti = stud.numeroComponenti;
    var redditoComponenti = new Array();
    var patrimonioComponenti = new Array()

    for (var i = 0; i < numeroComponenti; i++) {
        redditoComponenti[i] = prompt("Inserisci il reddito del componente " + (i + 1));
        while (isNaN(redditoComponenti[i])) {
            alert("Errore. Inserire solo valori numerici. Riprovare")
            redditoComponenti[i] = prompt("Inserisci il reddito del componente " + (i + 1));
        }
        patrimonioComponenti[i] = prompt("Inserisci il patrimonio del componente " + (i + 1));
        while (isNaN(patrimonioComponenti[i])) {
            alert("Errore. Inserire solo valori numerici. Riprovare")
            patrimonioComponenti[i] = prompt("Inserisci il patrimonio del componente " + (i + 1));
        }
    }

    var redditoComplessivo = 0;
    var patrimonioComplessivo = 0;

    for (var i = 0; i < numeroComponenti; i++) {
        redditoComplessivo += parseInt(redditoComponenti[i]);
        patrimonioComplessivo += parseInt(patrimonioComponenti[i]);
    }

    alert("Reddito Complessivo: " + redditoComplessivo);
    alert("Patrimonio Complessivo: " + patrimonioComplessivo);

    console.log(redditoComplessivo);
    console.log(patrimonioComplessivo);


    var ISR, ISP, ISE, ISEE, SE;

    ISR = redditoComplessivo;
    ISP = patrimonioComplessivo;

    scaleEquivalenza = {
        "1": 1,
        "2": 1.57,
        "3": 2.04,
        "4": 2.46,
        "5": 2.85
    };

    ISE = ISR + ISP * 20 / 100;

    if (numeroComponenti < 5) {
        SE = scaleEquivalenza[numeroComponenti];
    } else
        SE = 2.85;
    ISEE = ISE / SE;

    alert(ISEE + " L'ISEE di " + stud.nome + " "+ stud.cognome);
    document.getElementById("numComponenti").innerText=numeroComponenti;
    document.getElementById("redditoComplessivo").innerText=redditoComplessivo;
    document.getElementById("patrimonioComplessivo").innerText=patrimonioComplessivo;
    document.getElementById("ise").innerText=ISE;
    document.getElementById("se").innerText=SE;
    document.getElementById("isee").innerText=ISEE;

}