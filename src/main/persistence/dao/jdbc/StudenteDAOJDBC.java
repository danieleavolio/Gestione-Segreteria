package main.persistence.dao.jdbc;

import main.Model.Studente;
import main.persistence.DBManager;
import main.persistence.DBSource;
import main.persistence.dao.StudenteDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudenteDAOJDBC implements StudenteDAO {

    DBSource dbSource;

    public StudenteDAOJDBC(DBSource dbSource){
        this.dbSource = dbSource;
    }

    @Override
    public void save(Studente studente) {

    }

    @Override
    public Studente findByPrimaryKey(String matricola) {
        return null;
    }

    @Override
    public List<Studente> findAll() {
        List<Studente> studenti = new ArrayList<>();
        try {
            Connection conn = dbSource.getConnection();
            String query = "select * from studente";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                String matr = rs.getString("matricola");
                String nome = rs.getString("nome");
                String cognome = rs.getString("cognome");
                String dataNascita = rs.getString("datanascita");

                Studente stud = new Studente();
                stud.setNome(nome);
                stud.setCognome(cognome);
                stud.setMatricola(matr);
                stud.setDataNascita(dataNascita);

                studenti.add(stud);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studenti;
    }

    @Override
    public void update(Studente studente) {

    }

    @Override
    public void delete(Studente studente) {

    }
}
