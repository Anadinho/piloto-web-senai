/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.anadinho.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author anadinho
 */
public class Conexao {
    
    private static Connection conexao = null;
    
    public static Connection getConexao(){
        try
        {
               
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://192.168.1.11:3306/senai";
                String user = "anadinho";
                String password = "123";
                
//                String driver = "org.postgresql.Driver";
//                String url = "jdbc:postgresql://localhost:5432/usuario";
//                String user = "postgres";
//                String password = "123456";
                  
                Class.forName(driver);
                conexao = DriverManager.getConnection(url, user, password);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return conexao;
        
    }
}
