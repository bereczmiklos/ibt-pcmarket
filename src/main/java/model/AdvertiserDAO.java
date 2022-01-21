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
/**
 *
 * @author IBT
 */
public class AdvertiserDAO implements Dao<Advertiser> {
    
    private PcMarketDb db= new PcMarketDb();
    private Connection con = null;
    private Statement stmt = null;
    private PreparedStatement preSta = null;
        
    public AdvertiserDAO() {
        try {
            con = db.connect();
            Statement stmt = db.statement(con);
        }
        catch(SQLException e){
            throw new RuntimeException("Failed to connect:" + e.getMessage());
        }
    }
    
    @Override
    public Advertiser readOne(int id) {
        ResultSet queryResult = null;
        try {
            String readAdv = "select * from advertiser where id = ?";
            preSta = con.prepareStatement(readAdv);
            preSta.setInt(1, id);
            
        } catch (SQLException ex) {
            throw new RuntimeException("Failed to read");
        }
        return (Advertiser)queryResult;
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
            
        } catch(SQLException e)
        {
            throw new RuntimeException("Failed to create");
        }
    }

    //TODO:
    //select one by id
    //update selected one
    @Override
    public void update(int id) {
        try{
           stmt.executeQuery("select * from public.advertiser");
            
        } catch(SQLException e)
        {
            throw new RuntimeException("Failed to update");
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
    }
    
    //TODO:
    //NON-CRUDS
}

