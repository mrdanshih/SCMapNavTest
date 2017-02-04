/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graphshortestpathtest;
import java.util.HashMap;
/**
 *
 * @author dzshih
 */
public class SecondaryExit{
    //Keeps track of the distances it is from a primary exit.
    
    //Name of the physical location that this exit leads to
    private String locationName;
    
    //Keeps track of what primary exits this secondary exit connects to, and the distance to each.
    private HashMap<PrimaryExit, Double> toPrimaryMap;
    
    
    public SecondaryExit(String locationName, HashMap<PrimaryExit, Double> toPrimaryMap){
        this.locationName = locationName;
        this.toPrimaryMap = toPrimaryMap;
    }
    
    public SecondaryExit(String locationName, Object[] initiationList){
        this.locationName = locationName;
        toPrimaryMap = new HashMap<>();
        
        for(int i = 0; i < initiationList.length - 1; i+=2){
            //For easy testing, use a list of alternating Primaries and Distanc eto primaries.
            toPrimaryMap.put((PrimaryExit) initiationList[i], (double) initiationList[i + 1]);
        }
        
    }
    
    public String getLocationName(){
        return locationName;
    }
    
    public HashMap<PrimaryExit, Double> getFromToPrimaryMap(){
        return toPrimaryMap;
    }
    
     @Override
    public String toString(){
        String result = "DESTINATION NAME: " + locationName;
        
        for(HashMap.Entry entry: toPrimaryMap.entrySet()){
            result += "\n --> distance to " + entry.getKey() + " = " + entry.getValue();
        }
        
        return result + "\n";
    }
   
    
    
}
