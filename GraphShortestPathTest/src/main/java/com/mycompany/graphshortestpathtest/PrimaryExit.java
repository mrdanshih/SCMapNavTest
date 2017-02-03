/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graphshortestpathtest;

/**
 *
 * @author dzshih
 */
public class PrimaryExit { 
    private int id; 
    private String strId, description;
    
    public PrimaryExit(int id, String description){
        this.id = id;
        this.description = description;
    
    }
    
    public PrimaryExit(String id, String description){
        this.strId = id;
        this.description = description;
    }
    
    public int getId(){
        return id;
    }
    
    public String getStrId(){
        return strId;
    }
    
    public String getDescription(){
        return description;
    }
    
    
    public void setId(int newId){
        id = newId;
    }
    
    public void setStrId(String newId){
        strId = newId;
    }
    
    public void setDescription(String newDescrip){
        description = newDescrip;
    }

}
