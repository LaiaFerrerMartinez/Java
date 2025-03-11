package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PeliculaDAO implements DAO{
    @Override
    public void add(Pelicula pelicula) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Pelicula pelicula) {

    }

    @Override
    public void find(int id) throws SQLException {
        /*IDEAS AYUDA*/

        ConexionPostGre conex = Singleton.getInstance();
        Connection conn = conex.getConnection();
        Statement st = conn.createStatement();
        ResultSet lstDatos = st.executeQuery("SELECT * FROM PELICULAS");
        /*FIN IDEAS AYUDA*/
    }

    @Override
    public void findAll() {

    }
}