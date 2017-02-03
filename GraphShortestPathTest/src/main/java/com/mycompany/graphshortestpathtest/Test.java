/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graphshortestpathtest;
import java.util.*;
/**
 *
 * @author dzshih
 */
public class Test {
    public static void main(String[] args){
        Searcher map = new Searcher();
        
        String endNode = "D";
        
        //Set up an imaginary Zone 1, with primary exits H, J, I, and exits H, J, I all being able to conne to Jamba Juice
        PrimaryExit H = new PrimaryExit("H");
        PrimaryExit J = new PrimaryExit("J");
        PrimaryExit I = new PrimaryExit("I");
        
        PrimaryExit[] zone1Primaries = {H, J, I};
        
        Object[] jambaJuicePrimaries = {H, 3.0, J, 4.0, I, 1.0};
        SecondaryExit jambaJuice = new SecondaryExit("Jamba", jambaJuicePrimaries);
        
        SecondaryExit[] zone1Secondaries = {jambaJuice};
        
        Zone zone1 = new Zone(zone1Primaries, zone1Secondaries);
        
        System.out.println(zone1);
        
        String bestNode = "";
        double lowestCost = 123456789;
        
        //Look at every node associated with the Zone
        for(PrimaryExit exitNode: zone1.getPrimaryExits()){
            //Test w/ algorithm each node as a starting point to same destination
            double currentCost = map.costFromTo(exitNode.getId(), endNode);
            
            //Compares if current node is less costlier
            if ( currentCost < lowestCost){
                lowestCost = currentCost;
                
                //Sets best node
                bestNode = exitNode.getId();
            }
        }    
        
        //Searches with the best node
        //LINKED LIST
        System.out.println(lowestCost);
        ArrayList<LinkedList<String>> paths = (ArrayList) map.searchFromTo(bestNode, endNode);
        System.out.println(paths.get(0));
 
    }
}

