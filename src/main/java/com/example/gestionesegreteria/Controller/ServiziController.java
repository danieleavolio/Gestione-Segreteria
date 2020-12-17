package com.example.gestionesegreteria.Controller;

import main.Model.Scuola;
import main.Model.Studente;
import main.persistence.DBManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ServiziController {

    //{matricola: matr, nome: nom, cognome: cogn, date: d }
    @PostMapping ("GestioneStudenti/iscriviStudente")
    public String iscriviStudente(@RequestParam(value = "matr") String matricola, String nome, String cognome, String date, int scuolaId){


        Studente stud = new Studente();
        stud.setMatricola(matricola);
        stud.setNome(nome);
        stud.setCognome(cognome);
        stud.setDataNascita(date);

        System.out.println(matricola);
        System.out.println(nome);
        System.out.println(cognome);
        System.out.println(date);
        System.out.println(scuolaId);

        Scuola school = DBManager.getInstance().scuolaDAO().findByPrimaryKey(scuolaId); //dal dao
        stud.setScuola(school);
        DBManager.getInstance().studenteDAO().save(stud);
        return "Success"; //solitmanete si usa tornare un messaggio per cpaire se è andato tutto bene
    }
}
