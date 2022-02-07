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
    
    private int id;
    private String name;
    private String emailAddress;
    private List<Product> products;

    public Advertiser() {
    }

    public Advertiser(String emailAddress) {
        this.emailAddress = emailAddress;
        products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public void setProducts(List<Product> Products) {
        this.products = Products;
    }

    @Override
    public String toString() {
        return "Advertiser{" + "id=" + id + ", name=" + name + ", emailAddress=" + emailAddress + ", products=" + products + '}';
    }
}
