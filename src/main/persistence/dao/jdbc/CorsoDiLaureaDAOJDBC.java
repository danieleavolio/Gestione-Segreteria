package main.persistence.dao.jdbc;

import main.Model.CorsoDiLaurea;
import main.Model.Studente;
import main.persistence.DBManager;
import main.persistence.DBSource;
import main.persistence.dao.CorsoDiLaureaDAO;

import java.sql.*;
import java.util.ArrayList;
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
        List<CorsoDiLaurea>   cdls = new ArrayList<>();
        try {
            Connection conn = dbSource.getConnection();
            String query = "select * from corsodilaurea";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");

                CorsoDiLaurea cdl = new CorsoDiLaurea();
                cdl.setID(id);
                cdl.setNome(nome);
                cdl.setStudenti(DBManager.getInstance().corsoDiLaureaDAO().findByCorsoDiLaureaID(id));

                cdls.add(cdl);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cdls;
    }

    @Override
    public void update(main.persistence.dao.CorsoDiLaureaDAO cdl) {

    }

    @Override
    public void delete(main.persistence.dao.CorsoDiLaureaDAO cdl) {

    }

    @Override
    public ArrayList<Studente> findByCorsoDiLaureaID(int clid) {
        ArrayList<Studente> studenti = new ArrayList<>();
        try {
            Connection conn = dbSource.getConnection();
            String query = "select * from studente where corsodilaurea=?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,clid);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                String matr = rs.getString("matricola");
                String nome = rs.getString("nome");
                String cognome = rs.getString("cognome");
                String dataNascita = rs.getString("datanascita");
                int scuola = rs.getInt("scuola");

                Studente stud = new Studente();
                stud.setNome(nome);
                stud.setCognome(cognome);
                stud.setMatricola(matr);
                stud.setDataNascita(dataNascita);
                stud.setScuola(DBManager.getInstance().scuolaDAO().findByPrimaryKey(scuola));

                studenti.add(stud);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studenti;
    }
}
