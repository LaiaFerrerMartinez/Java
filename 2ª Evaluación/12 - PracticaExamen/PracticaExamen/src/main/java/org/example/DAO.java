package org.example;

import java.sql.SQLException;

public interface DAO {
    void add(Pelicula pelicula);
    void delete(int id);
    void update(Pelicula pelicula);
    void find(int id) throws SQLException;
    void findAll();
}
