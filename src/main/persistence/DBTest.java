package main.persistence;

import main.Model.Studente;
import main.persistence.dao.StudenteDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBTest {

    public static void main(String[] args) {
        StudenteDAO sDao = DBManager.getInstance().studenteDAO();
        List<Studente> studenteList = sDao.findAll();
        for (Studente studente : studenteList) {
            System.out.println(studente.getCognome());
            System.out.println(studente.getNome());
        }
    }
}
