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

        
  
     
        
        //Set up an imaginary Zone 1, with primary exits H, J, I, and exits H, J, I all being able to conne to Jamba Juice
        /*
        PrimaryExit H = new PrimaryExit("H");
        PrimaryExit J = new PrimaryExit("J");
        PrimaryExit I = new PrimaryExit("I");
        
        PrimaryExit[] zone1Primaries = {H, J, I};
        
        //Setting up a secondary exit (physical destination) with associated primaries
        Object[] jambaJuicePrimaries = {H, 3.0, J, 4.0, I, 1.0};
        SecondaryExit jambaJuice = new SecondaryExit("Jamba", jambaJuicePrimaries);
        
        SecondaryExit[] zone1Secondaries = {jambaJuice};
        
        Zone zone1 = new Zone(zone1Primaries, zone1Secondaries);
        
        System.out.println(zone1);
        */
        
        //Set up an imaginary Zones
        
        //Zone 1
        PrimaryExit A = new PrimaryExit("A");
        PrimaryExit B = new PrimaryExit("B");
        
        PrimaryExit[] zone1Primaries = {A, B};
        
        //Setting up a secondary exit (physical destination) with associated primaries
        Object[] jambaJuicePrimaries = {A, 2.0, B, 6.0};
        SecondaryExit jambaJuice = new SecondaryExit("Jamba", jambaJuicePrimaries);
        
        Object[] restroomPrimaries = {A, 5d, B, 4d};
        SecondaryExit restroom = new SecondaryExit("Restroom", restroomPrimaries);
        
        SecondaryExit[] zone1Secondaries = {jambaJuice, restroom};
        Zone zone1 = new Zone(zone1Primaries, zone1Secondaries);
        
        
        
        //Zone 2
        PrimaryExit C = new PrimaryExit("C");   
        PrimaryExit[] zone2Primaries = {B, C};    
        
        //Setting up a secondary exit (physical destination) with associated primaries
        Object[] pandaPrimaries = {C, 4.0, B, 5.0};
        SecondaryExit panda = new SecondaryExit("Panda", pandaPrimaries);
        
        SecondaryExit[] zone2Secondaries = {panda};
        
        Zone zone2 = new Zone(zone2Primaries, zone2Secondaries);
        
        //Zone 3
        PrimaryExit D = new PrimaryExit("D");   
        PrimaryExit[] zone3Primaries = {C, D};      
        Zone zone3 = new Zone(zone3Primaries);
        
        
        Zone[] listOfZones = {zone1, zone2, zone3};
        
        
        //BEGIN A SEARCH
        Zone startZone = zone3;
        String userSearch = "Jamba";
        String endNode = "A";
        //Now, find the SECONDARY exit that contains th user search
        for(Zone zone: listOfZones){
            if(zone.getSecondaryExits() != null){
                for(SecondaryExit secondary: zone.getSecondaryExits()){
                    String secondaryName = secondary.getLocationName();
                    if(secondaryName.equals(userSearch)){
                        endNode = secondary.getLocationName();

                        //Connections to primaries of the secondary
                        for(HashMap.Entry entry: secondary.getFromToPrimaryMap().entrySet()){
                            map.addToGraph(secondaryName, ((PrimaryExit) entry.getKey()).getId(), (double) entry.getValue());                     
                        }   
                    }
                }
            }
        }
        
        
        
        System.out.println(zone1);
        System.out.println(zone2);
        
        
        ///END INITIAL CONFIGURATION
        //BEGIN ALGORITHM FOR FINDING BEST START PRIMARY NODE WITHIN A ZONE
        String bestNode = "";
        double lowestCost = 123456789;
        
        //Look at every node associated with the Zone
        for(PrimaryExit exitNode: startZone.getPrimaryExits()){
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

