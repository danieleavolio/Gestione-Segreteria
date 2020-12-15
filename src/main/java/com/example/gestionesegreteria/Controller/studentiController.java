package com.example.gestionesegreteria.Controller;

import main.Model.Studente;
import main.persistence.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class studentiController {
    @GetMapping("GestioneStudenti/studenti.html")
    public String dammiStudenti(HttpSession session, Model model) {
        //logica di business
        //invoca il db tramite il daoma
        //ottiene oggetti STUDENTE e li mette nel Model

        if(checkAuth(session)){

            List<Studente> listaStudenti = new ArrayList<>();
            listaStudenti = DBManager.getInstance().studenteDAO().findAll();
            Studente S1 = new Studente();
           /* S1.setNome("Giovannino");
            S1.setCognome("Rinaldino");
            S1.setMatricola("201918");
            Studente S2 = new Studente();
            S2.setCognome("Morone");
            S2.setNome("Colone");
            S2.setMatricola("202018");

            listaStudenti.add(S1);
            listaStudenti.add(S2);*/
            model.addAttribute("listStudenti", listaStudenti);
            return "studenti";
        }
        else
            return "unauthorized";

    }

    private boolean checkAuth(HttpSession session){
        if (session.getAttribute("usernameLogged")!=null)
            return session.getAttribute("usernameLogged").equals("admin");
        return false;
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
