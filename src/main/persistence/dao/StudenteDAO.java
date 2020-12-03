package main.persistence.dao;
import main.Model.Studente;
import java.util.List;

public interface StudenteDAO {
    public void save(Studente studente); // Create
    public Studente findByPrimaryKey(String matricola); // Retrieve
    public List<Studente> findAll();
    public void update(Studente studente); //Update
    public void delete(Studente studente); //Delete
}
