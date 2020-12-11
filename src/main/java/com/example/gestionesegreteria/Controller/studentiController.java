package com.example.gestionesegreteria.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class studentiController {
    @GetMapping("GestioneStudenti/studenti.html")
    public String dammiStudenti() {
        //logica di business
        //invoca il db tramite il daoma
        //ottiene oggetti STUDENTE e li mette nel Model



        return "studenti";
    }

    @PostMapping("/GestioneStudenti/faiIscrizione")
    public String iscrivi(@RequestParam String matricola, @RequestParam String nome, @RequestParam String cognome, @RequestParam String luogoNascita, @RequestParam String dataNascita) {
        System.out.println(matricola);
        System.out.println(nome);
        System.out.println(cognome);
        System.out.println(luogoNascita);
        System.out.println(dataNascita);
        return "studenti";
    }
}
