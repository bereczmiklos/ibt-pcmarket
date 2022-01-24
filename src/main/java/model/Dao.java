/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author IBT
 */
public interface Dao<T> {
    
    T readOne(int id);
    
    List<T> readAll();
    
    void create(T t);
    
    void update(T t);
    
    void delete(int id);
}
