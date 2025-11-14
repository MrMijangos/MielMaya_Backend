package com.mieleria.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class Database {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties props = new Properties();
                InputStream input = Database.class.getClassLoader().getResourceAsStream("application.properties");
                props.load(input);

                String url = props.getProperty("db.url");
                String user = props.getProperty("db.user");
                String password = props.getProperty("db.password");
                String driver = props.getProperty("db.driver");

                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);

                System.out.println(" Conexión a MySQL exitosa!");
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(" Error al conectar a la base de datos");
            }
        }
        return connection;
    }
}
