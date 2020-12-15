package main.persistence.dao;

import main.Model.CorsoDiLaurea;
import main.Model.Studente;

import java.util.List;

public interface CorsoDiLaureaDAO {
    public void save(CorsoDiLaureaDAO cdl); // Create
    public Studente findByPrimaryKey(String matricola); // Retrieve
    public List<CorsoDiLaurea> findAll();
    public void update(CorsoDiLaureaDAO cdl); //Update
    public void delete(CorsoDiLaureaDAO cdl); //Delete
}
