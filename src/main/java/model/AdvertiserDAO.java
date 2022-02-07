/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author IBT
 */
public class AdvertiserDAO implements Dao<Advertiser> {
    
    private PcMarketDb db;
    private Connection con;
    private Statement stmt;
    private PreparedStatement preSta;
    
    public AdvertiserDAO(){
        try {
            db  = new PcMarketDb();
            con = db.connect();
            stmt = db.statement(con);
        }
        catch(SQLException e){
            throw new RuntimeException("Failed to connect:" + e.getMessage());
        }
    }
    
    @Override
    public Advertiser readOne(int id) {
        ResultSet queryResult = null;
        Advertiser adv;
        try {
            String readAdv = "select * from advertiser where id = ?";
            preSta = con.prepareStatement(readAdv);
            preSta.setInt(1, id);
            queryResult = preSta.executeQuery();
            
            queryResult.next();
            adv = new Advertiser();
            adv.setId(queryResult.getInt(1));
            adv.setName(queryResult.getString(2));
            adv.setEmailAddress(queryResult.getString(3));
 
        } catch (SQLException ex) {
            System.err.println("*ReadOne: failed to read" + ex.getMessage());
            throw new RuntimeException("Failed to read");
        }
        System.err.println("ReadOne: success - rerturn: " + adv);
        return adv;
    }

    @Override
    public List<Advertiser> readAll() {
        
        ResultSet queryResult = null;
        List<Advertiser> result = new ArrayList<>();
        
        try{
            queryResult = stmt.executeQuery("select * from public.advertiser");
            
            while(queryResult.next()){
                Advertiser adv = new Advertiser();
                adv.setId(queryResult.getInt(1));
                adv.setName(queryResult.getString(2));
                adv.setEmailAddress(queryResult.getString(3));
                result.add(adv);
            }
            
        } catch(SQLException e)
        {
            throw new RuntimeException("Failed to read");
        }
        System.err.println("Readall: success");
        return result;
    }

    @Override
    public void create(Advertiser adv) {
          try{
            String insertAdv = "insert into advertiser values (?,?,?)";
            preSta = con.prepareStatement(insertAdv);
            preSta.setInt(1, adv.getId());
            preSta.setString(2, adv.getName());
            preSta.setString(3, adv.getEmailAddress());
            preSta.executeUpdate();
            
        } catch(SQLException e)
        {
            throw new RuntimeException("Failed to create");
        }
        System.err.println("Create: success - " + adv.toString());
    }

    /**
     * Update advertiser for a given ID ...
     * @param adv advertiser with an existing ID
     */
    @Override
    public void update(Advertiser adv) {
        
        if (adv.getId() > 0) {
            try {
                String updateAdv = "update advertiser set name = (?) where id = (?)";
                preSta = con.prepareCall(updateAdv);
                preSta.setString(1, adv.getName());
                preSta.setInt(2, adv.getId());
                preSta.executeUpdate();
                
            } catch (SQLException e) {
               System.err.println("Create: failed to create" + e.getMessage());
               throw new RuntimeException("Failed to create");
            }
        }
        else{
            System.err.println("Update: failed (invalid id) - " + adv.toString());
        }
    }

    @Override
    public void delete(int id) {
        try{
           String deleteAdv = "delete from public.advertiser where id = ?";
           preSta = con.prepareCall(deleteAdv);
           preSta.setInt(1, id);
            
        } catch(SQLException e)
        {
            throw new RuntimeException("Failed to delete");
        }
        System.err.println("Delete: success - id: " + id);
    }
}

