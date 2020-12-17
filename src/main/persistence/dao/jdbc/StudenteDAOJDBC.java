package main.persistence.dao.jdbc;

import main.Model.CorsoDiLaurea;
import main.Model.Studente;
import main.persistence.DBManager;
import main.persistence.DBSource;
import main.persistence.dao.CorsoDiLaureaDAO;
import main.persistence.dao.StudenteDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudenteDAOJDBC implements StudenteDAO {

    DBSource dbSource;

    public StudenteDAOJDBC(DBSource dbSource){
        this.dbSource = dbSource;
    }

    @Override
    public void save(Studente studente) {
        try {
            Connection conn = dbSource.getConnection();
            String queryUpdate = "INSERT INTO studente values (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(queryUpdate);
            st.setString(1, studente.getMatricola());
            st.setString(2, studente.getNome());
            st.setString(3, studente.getCognome());
            st.setString(4, studente.getDataNascita());
            st.setLong(5, studente.getScuola().getId());

            CorsoDiLaurea cdl = dammiCorsoDiLaurea(studente);
            if (cdl != null)
                st.setLong(6, cdl.getID());
            else
                st.setObject(6, null);
            st.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Studente findByPrimaryKey(String matricola) {
        Studente studente = null;
        try {
            Connection conn = dbSource.getConnection();
            String query = "select * from studente where matricola=?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, matricola);
            ResultSet rs = st.executeQuery(query);
            if (rs.next()){
                String matr = rs.getString("matricola");
                String nome = rs.getString("nome");
                String cognome = rs.getString("cognome");
                String dataNascita = rs.getString("datanascita");

                Studente stud = new Studente();
                stud.setNome(nome);
                stud.setCognome(cognome);
                stud.setMatricola(matr);
                stud.setDataNascita(dataNascita);
                studente = stud;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studente;
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

    @Override
    public CorsoDiLaurea dammiCorsoDiLaurea(Studente studente) {
        List<CorsoDiLaurea> cdls = DBManager.getInstance().corsoDiLaureaDAO().findAll();
        for (CorsoDiLaurea cdl : cdls) {
            for (Studente studente1 : cdl.getStudenti()) {
                if (studente1.getMatricola().equals(studente.getMatricola())) {
                    return cdl;
                }
            }
        }
        return null;
    }
}
