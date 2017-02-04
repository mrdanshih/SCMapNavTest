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
    //Identifier for the primary exit, and a description for it?? (necessary to have both?)
    private String strId, description;
    
    
    public PrimaryExit(String id, String description){
        this.strId = id;
        this.description = description;
    }
    
    public PrimaryExit(String id){
        this.strId = id;
    }
    
    
    public String getId(){
        return strId;
    }
    
    public String getDescription(){
        return description;
    }
    
    @Override
    public String toString(){
        return "PRIMARY: " + strId;
    }
    
   
    
    public void setStrId(String newId){
        strId = newId;
    }
    
    public void setDescription(String newDescrip){
        description = newDescrip;
    }

}
