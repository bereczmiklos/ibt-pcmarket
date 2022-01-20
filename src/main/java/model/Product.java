/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author IBT
 */
public class Product {

    public static final String VGA = "grapichscard";
    public static final String PROCESSOR = "processor";
    public static final String MOTHERBOARD = "motherboard";
    public static final String MEMORY = "memory";
    public static final String POWERSUPPLY = "powersupply";
    
    static String[] keyWords = new String[] {VGA, PROCESSOR, MOTHERBOARD, MEMORY, POWERSUPPLY};
    
    String name;
    int price;
    String keyWord;
    String bookingEmailAddress;
    String ownerEmailAddress;

    public Product(String name, int price, String keyWord, String ownerEmailAddress) {
        this.name = name;
        this.price = price;
        this.ownerEmailAddress = ownerEmailAddress;
        setKeyWord(keyWord);
    }
    
    public Product(String name, int price, String keyWord) {
        this.name = name;
        this.price = price;
        setKeyWord(keyWord);
    }

    public void setOwnerEmailAddress(String ownerEmailAddress) {
        this.ownerEmailAddress = ownerEmailAddress;
    }

    public String getOwnerEmailAddress() {
        return ownerEmailAddress;
    }

    public static String[] getKeyWords() {
        return keyWords;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public String getBookingEmailAddress() {
        return bookingEmailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setKeyWord(String keyWord) {
        for (int i = 0; i < keyWords.length; i++) {
            if (keyWords[i].equals(keyWord)) {
                this.keyWord = keyWord;
            }
        }
        if (this.keyWord == null) {
            throw new RuntimeException("Invalid keyword: " + keyWord);
        }
    }

    public void setBookingEmailAddress(String emailAddress) {
        this.bookingEmailAddress = emailAddress;
    }
}
