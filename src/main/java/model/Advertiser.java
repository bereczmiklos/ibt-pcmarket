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
public class Advertiser {
    
    private String emailAddress;
    private List<Product> products;

    public Advertiser(String emailAddress) {
        this.emailAddress = emailAddress;
        products = new ArrayList<>();
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> Products) {
        this.products = Products;
    }
    
}
