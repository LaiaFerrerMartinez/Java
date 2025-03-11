package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Main {
    private static Connection conn;
    private static Statement st;

    public static final String URLPostgre = "jdbc:postgresql://127.0.0.1:5432/postgres";
    public static final String USERPostgre = "postgres";
    public static final String PASSPostgre = "123456";

    public static void connect() {
        Properties properties = new Properties();
        properties.setProperty("url", URLPostgre);
        properties.setProperty("user", USERPostgre);
        properties.setProperty("password", PASSPostgre);
        properties.setProperty("ssl", "false");
        try {
            conn = DriverManager.getConnection(URLPostgre, properties);
            if (conn != null) {
                System.out.println("Conectado a base de datos");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // 📌 Lista donde guardaremos las películas con sus géneros
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        try {
            // 🔗 Conectar a PostgreSQL y hacer el JOIN
            connect();
            System.out.println("✅ Conexión exitosa a PostgreSQL!");

            st = conn.createStatement();

            // 📌 Consulta con JOIN entre películas y género
            String query = "SELECT \n" +
                    "    p.id AS pelicula_id,\n" +
                    "    p.titulo AS pelicula_titulo,\n" +
                    "    p.descripcion AS pelicula_descripcion,\n" +
                    "    p.anio AS pelicula_anio,\n" +
                    "    g.id AS genero_id,\n" +
                    "    g.titulo AS genero_titulo\n" +  // Traemos id y titulo del genero
                    "FROM \n" +
                    "    peliculas p\n" +
                    "INNER JOIN \n" +
                    "    genero g\n" +
                    "ON \n" +
                    "    p.genero_id = g.id;";

            ResultSet rs = st.executeQuery(query);

            // 📌 Procesar los resultados
            while (rs.next()) {
                int id = rs.getInt("pelicula_id");
                String titulo = rs.getString("pelicula_titulo");
                String descripcion = rs.getString("pelicula_descripcion");
                int anio = rs.getInt("pelicula_anio");
                String generoTitulo = rs.getString("genero_titulo");
                int generoId = rs.getInt("genero_id");

                // 📌 Crear el objeto Genero
                Genero genero = new Genero(generoId, generoTitulo);

                // 📌 Crear el objeto Pelicula con el género y agregarlo a la lista
                Pelicula pelicula = new Pelicula(id, titulo, descripcion, anio, genero);
                peliculas.add(pelicula);
            }


            // 📌 Mostrar los resultados almacenados en el ArrayList
            System.out.println("\n🎬 Lista de Películas con Géneros:");
            for (Pelicula p : peliculas) {
                System.out.println(p);  // Ahora muestra también el género
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


}