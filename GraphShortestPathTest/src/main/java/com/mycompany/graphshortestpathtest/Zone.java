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
    private PrimaryExit[] primaryExits, secondaryExits;
    
    public Zone(PrimaryExit[] primaryExits, PrimaryExit[] secondaryExits ){
        this.primaryExits = primaryExits;
        this.secondaryExits = secondaryExits;
    }
    
    public PrimaryExit[] getPrimaryExits(){
        return primaryExits;
    }
    
    public PrimaryExit[] getSecondaryExits(){
        return secondaryExits;
    }
}
