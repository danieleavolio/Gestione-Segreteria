package main.persistence.dao;

import main.Model.CorsoDiLaurea;
import main.Model.Scuola;
import main.Model.Studente;

import java.util.List;

public interface ScuolaDAO {
    public void save(Scuola scuola); // Create
    public Scuola findByPrimaryKey(int id); // Retrieve
    public List<Scuola> findAll();
    public void update(Scuola scuola); //Update
    public void delete(Scuola scuola); //Delete

}
