package main.persistence.dao.jdbc;

import main.Model.CorsoDiLaurea;
import main.Model.Scuola;
import main.persistence.DBSource;
import main.persistence.dao.ScuolaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ScuolaDAOJDBC implements ScuolaDAO {


    DBSource dbSource;

    public ScuolaDAOJDBC(DBSource dbSource){
        this.dbSource = dbSource;
    }
    @Override
    public void save(Scuola scuola) {

    }

    @Override
    public Scuola findByPrimaryKey(int id) {
        Scuola scuola = null;
        try {
            Connection conn = dbSource.getConnection();
            String queryUpdate = "select * from scuola where id=?";
            PreparedStatement st = conn.prepareStatement(queryUpdate);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                int idS = rs.getInt("id");
                String codMecc = rs.getString("codicemeccanografico");
                String nome = rs.getString("nome");

                scuola = new Scuola();
                scuola.setId(idS);
                scuola.setCodiceMeccanografico(codMecc);
                scuola.setNome(nome);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return scuola;
    }

    @Override
    public List<Scuola> findAll() {
        return null;
    }

    @Override
    public void update(Scuola scuola) {

    }

    @Override
    public void delete(Scuola scuola) {

    }
}
