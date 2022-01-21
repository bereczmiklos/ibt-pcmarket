/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author IBT
 */
public class PcMarketDb {
    private String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    private String username = "postgres";
    private String password = "1234";

    private Connection con = null;
    private Statement stmt = null;
        
    public Connection connect() throws SQLException {

        try{
            con = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Successful connection");
            Statement stmt = con.createStatement();
            System.out.println("reading records...");

            ResultSet q1 = stmt.executeQuery("select * from public.product");

        } catch(SQLException e){
            System.out.println("Connection failed: " + e.getMessage());
        }

        return con;
    }
     
    public Statement statement(Connection con) throws SQLException{
        stmt = con.createStatement();
        return stmt; 
    }
}
