package main.Model;

import java.util.ArrayList;

public class CorsoDiLaurea {

    int ID;
    String nome;
    ArrayList<Studente> studenti;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
