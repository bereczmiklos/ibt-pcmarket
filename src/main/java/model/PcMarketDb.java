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
    
//    public static void main(String[] args) throws SQLException{
//
//        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
//        String username = "postgres";
//        String password = "1234";
//
//        try(Connection con = DriverManager.getConnection(jdbcUrl, username, password)){
//            System.out.println("Successful connection");
//            Statement stmt = con.createStatement();
//            System.out.println("reading records...");
//
//            ResultSet q1 = stmt.executeQuery("select * from public.product");
//            process(q1);
//
//            ResultSet q2 = stmt.executeQuery("select * from public.product where advid = 3");
//            process(q2);
//
//        } catch(SQLException e){
//            System.out.println("Connection failed: " + e.getMessage());
//        }
//    }
    
    public static void connectToDb() throws SQLException {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "1234";
        
        try(Connection con = DriverManager.getConnection(jdbcUrl, username, password)){
            System.out.println("Successful connection");
            Statement stmt = con.createStatement();
            System.out.println("reading records...");
            
            ResultSet q1 = stmt.executeQuery("select * from public.product");
            process(q1);
            
            ResultSet q2 = stmt.executeQuery("select * from public.product where advid = 3");
            process(q2);
            
        } catch(SQLException e){
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
    
    private static void process(ResultSet result) throws SQLException{
        while(result.next()){
            System.out.printf("%-30s  %-30s  %-30s%n",
                    result.getInt("id"),
                    result.getString("productname"), 
                    result.getString("price"));
        }
        
        System.out.println("_____________________________________________________________");
    };
}
