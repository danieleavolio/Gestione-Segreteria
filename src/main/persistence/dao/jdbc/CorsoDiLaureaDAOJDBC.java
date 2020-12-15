package main.persistence.dao.jdbc;

import main.Model.CorsoDiLaurea;
import main.Model.Studente;
import main.persistence.DBSource;
import main.persistence.dao.CorsoDiLaureaDAO;

import java.util.List;

public class CorsoDiLaureaDAOJDBC implements main.persistence.dao.CorsoDiLaureaDAO {
    private final DBSource dbSource;

    @Override
    public void save(main.persistence.dao.CorsoDiLaureaDAO cdl) {

    }

    public CorsoDiLaureaDAOJDBC(DBSource dbSource) {
        this.dbSource = dbSource;
    }

    @Override
    public Studente findByPrimaryKey(String matricola) {
        return null;
    }

    @Override
    public List<CorsoDiLaurea> findAll() {
        return null;
    }

    @Override
    public void update(main.persistence.dao.CorsoDiLaureaDAO cdl) {

    }

    @Override
    public void delete(main.persistence.dao.CorsoDiLaureaDAO cdl) {

    }
}
