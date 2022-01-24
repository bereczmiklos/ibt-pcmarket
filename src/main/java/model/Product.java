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

    public static final String VGA = "graphicscard";
    public static final String PROCESSOR = "processor";
    public static final String MOTHERBOARD = "motherboard";
    public static final String MEMORY = "memory";
    public static final String POWERSUPPLY = "powersupply";
    
    static String[] keyWords = new String[] {VGA, PROCESSOR, MOTHERBOARD, MEMORY, POWERSUPPLY};
    
    int id;
    int advId;
    int bookerId;
    String keyWord;
    String productName;
    int price;

    public Product() {
    }

    public Product(int id, int advId, int bookerId, String keyWord, String productName, int price) {
        this.id = id;
        this.advId = advId;
        this.bookerId = bookerId;
        this.keyWord = keyWord;
        this.productName = productName;
        this.price = price;
    }

    public static void setKeyWords(String[] keyWords) {
        Product.keyWords = keyWords;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAdvId(int advId) {
        this.advId = advId;
    }

    public void setBookerId(int bookerId) {
        this.bookerId = bookerId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public int getAdvId() {
        return advId;
    }

    public int getBookerId() {
        return bookerId;
    }

    public String getProductName() {
        return productName;
    }

    public static String[] getKeyWords() {
        return keyWords;
    }

    public int getPrice() {
        return price;
    }

    public String getKeyWord() {
        return keyWord;
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
}
