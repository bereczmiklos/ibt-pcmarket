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
public class ProductDAO implements Dao<Product>{
    
    private PcMarketDb db;
    private Connection con = null;
    private Statement stmt = null;
    private PreparedStatement preSta = null;
    
    public ProductDAO() {
        try {
            db = new PcMarketDb();
            con = db.connect();
            stmt = db.statement(con);
        }
        catch(SQLException e){
            throw new RuntimeException("Failed to connect:" + e.getMessage());
        }
    }
    
    @Override
    public Product readOne(int id) {
        ResultSet queryResult = null;
        try {
            String readProd = "select * from public.product where id = ?";
            preSta = con.prepareStatement(readProd);
            preSta.setInt(1, id);
            
        } catch (SQLException ex) {
            throw new RuntimeException("Failed to read");
        }
        return (Product)queryResult;
    }

    @Override
    public List<Product> readAll() {
        ResultSet queryResult = null;
        List<Product> result = new ArrayList<>();
        
        try{
            queryResult = stmt.executeQuery("select * from public.product");
            
            while(queryResult.next()){
                Product prod = new Product();
                prod.setId(queryResult.getInt(1));
                prod.setAdvId(queryResult.getInt(2));
                prod.setBookerId(queryResult.getInt(3));
                prod.setKeyWord(queryResult.getString(4));
                prod.setProductName(queryResult.getString(5));
                prod.setPrice(queryResult.getInt(6));
                result.add(prod);
            }
            
        } catch(SQLException e)
        {
            throw new RuntimeException("Failed to read");
        }
        
        return result;
    }

    @Override
    public void create(Product prod) {
        try{
            String insertAdv = "insert into public.product values (?,?,?,?,?,?)";
            preSta = con.prepareStatement(insertAdv);
            preSta.setInt(1, prod.getId());
            preSta.setInt(2, prod.getAdvId());
            preSta.setInt(3, prod.getBookerId());
            preSta.setString(4, prod.getKeyWord());
            preSta.setString(5, prod.getProductName());
            preSta.setInt(6, prod.getPrice());
            
        } catch(SQLException e)
        {
            throw new RuntimeException("Failed to create");
        }
    }

    @Override
    public void update(int id) {
        
    }

    @Override
    public void delete(int id) {
        try{
           String deleteProd = "delete from public.product where id = ?";
           preSta = con.prepareCall(deleteProd);
           preSta.setInt(1, id);
            
        } catch(SQLException e)
        {
            throw new RuntimeException("Failed to delete");
        }
    }
    
    //TODO:
    //NON-CRUDS
}
