package com.leiva.ListaReproducion.repository;

import javax.security.auth.login.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public class ConnectionToBBDD {


    public static Connection ConnectionToMysql() {
        String connectionToSql = "jdbc:mysql://localhost:3306/PlayList?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(connectionToSql,"root","soymillonario512");
        }catch (SQLTimeoutException e){
            System.out.println(e.getMessage());
        }catch (SQLException e){
            System.out.println("Se ha producido un error al intentar conectar con Mysql");
        }
       return conn;
    }
}
