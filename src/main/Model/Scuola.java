package main.Model;

public class Scuola {
    int ID;
    String codiceMeccanografico;
    String nome;

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public String getCodiceMeccanografico() {
        return codiceMeccanografico;
    }

    public void setCodiceMeccanografico(String codiceMeccanografico) {
        this.codiceMeccanografico = codiceMeccanografico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
