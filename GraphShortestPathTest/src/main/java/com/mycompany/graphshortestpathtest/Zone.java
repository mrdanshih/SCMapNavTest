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
public class Zone {
    //Each Zone should know it's own primary exits and secondary exits.
    private PrimaryExit[] primaryExits;
    private SecondaryExit[] secondaryExits;
    
    public Zone(PrimaryExit[] primaryExits, SecondaryExit[] secondaryExits){
        this.primaryExits = primaryExits;
        this.secondaryExits = secondaryExits;
    }
    
    public PrimaryExit[] getPrimaryExits(){
        return primaryExits;
    }
    
    public SecondaryExit[] getSecondaryExits(){
        return secondaryExits;
    }
    
    @Override
    public String toString(){
        String result = "PRIMARIES:\n";
        for(PrimaryExit primary: primaryExits){
            result += primary + ", ";
        }
        
        result += "\n\n SECONDARIES:\n";
        
        for(SecondaryExit secondary: secondaryExits){
            result += secondary + ", ";
        }
        
        return result;
        
    }
}
