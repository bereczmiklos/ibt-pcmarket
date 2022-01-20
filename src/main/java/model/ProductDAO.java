/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IBT
 */
public class ProductDAO implements Dao<Product>{

    private final List<Product> products = new ArrayList<>();
    private static ProductDAO pDao;
    
    private ProductDAO() {
        
    }
    
    public static ProductDAO getInstance()
    {
        if (pDao==null) {
           pDao = new ProductDAO();
        }
        return pDao;
    }

    @Override
    public Product readOne(String name) {
        return products.stream()
            .filter(p->p.getName().equals(name))
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<Product> readAll() {
        return products;
    }

    @Override
    public void create(Product prod) {
        products.add(prod);
    }

    @Override
    public void update(String oldName, Product newProduct) {
        Product oldProduct; // = readOne(oldName);
        oldProduct = newProduct;
    }

    @Override
    public void delete(Product prod) {
      products.remove(prod);
    }
    
    public Product readOneByAllParameter(String ownerEmail, String productName, int price)
    {
        return products.stream()
            .filter(x->x.getOwnerEmailAddress().equals(ownerEmail) 
                    && x.getName().equals(productName) 
                    && x.getPrice() == price)
            .findFirst()
            .orElse(null);

    }
}
