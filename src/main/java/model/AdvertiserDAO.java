/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

import static model.Product.*;
/**
 *
 * @author IBT
 */
public class AdvertiserDAO implements Dao<Advertiser> {
    
    private final List<Advertiser> advertisers = new ArrayList<>();
    private static AdvertiserDAO aDao;
        
    private AdvertiserDAO() {
        testDataSeed();
    }
    
    public static AdvertiserDAO getInstance()
    {
        if (aDao == null) {
            aDao = new AdvertiserDAO();
        }
        return aDao;
    }
    
    @Override
    public Advertiser readOne(String email) {
        
        return advertisers.stream()
                .filter(a->a.getEmailAddress().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Advertiser> readAll() {
        return advertisers;
    }

    @Override
    public void create(Advertiser adv) {
        advertisers.add(adv);
    }

    @Override
    public void update(String oldName, Advertiser newAdvertiser) {
        
        Advertiser oldAdvertiser; // = readOne(oldName);
        oldAdvertiser = (Advertiser)newAdvertiser;
    }

    @Override
    public void delete(Advertiser adv) {
        advertisers.remove(adv);
    }
    
    void testDataSeed() {
        ProductDAO pDao =  ProductDAO.getInstance();
        
        Advertiser advertiser = new Advertiser("misike@gmail.com");
        Product product = new Product("i3", 20000, PROCESSOR, advertiser.getEmailAddress());
        Product product1 = new Product("gtx550", 20000, VGA, advertiser.getEmailAddress());
        advertiser.getProducts().add(product);
        product.setBookingEmailAddress("soosjozska@gmail.com");
        advertiser.getProducts().add(product1);
        pDao.create(product);
        pDao.create(product1);
        //advertisers.add(advertiser);
        create(advertiser);

        advertiser = new Advertiser("soosjozska@gmail.com");
        //Product product2 = new Product("B450", 40000, MOTHERBOARD, advertiser.getEmailAddress());
        Product product3 = new Product("CoolerMaster", 15000, POWERSUPPLY, advertiser.getEmailAddress());
        //advertiser.getProducts().add(product2);
        advertiser.getProducts().add(product3);
        product3.setBookingEmailAddress("arnivagyok@gmail.com");
        //pDao.create(product2);
        pDao.create(product3);
        advertisers.add(advertiser);

        advertiser = new Advertiser("arnivagyok@gmail.com");
        Product product4 = new Product("DDR4", 16000, MEMORY, advertiser.getEmailAddress());
        Product product5 = new Product("DDR5", 30000, MEMORY, advertiser.getEmailAddress());
        product4.setBookingEmailAddress("gizella@gmail.com");
        advertiser.getProducts().add(product4);
        advertiser.getProducts().add(product5);
        pDao.create(product4);
        pDao.create(product5);
        advertisers.add(advertiser);

        advertiser = new Advertiser("gizella@gmail.com");
        Product product6 = new Product("3030ti", 450000, VGA, advertiser.getEmailAddress());
        Product product7 = new Product("1050", 160000, VGA, advertiser.getEmailAddress());
        product6.setBookingEmailAddress("arnivagyok@gmail.com");
        advertiser.getProducts().add(product6);
        advertiser.getProducts().add(product7);
        pDao.create(product6);
        pDao.create(product7);
        advertisers.add(advertiser);
    }
}

