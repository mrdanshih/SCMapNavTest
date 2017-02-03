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
        
        //Assume Zone 1
        PrimaryExit[] zone1Primaries = {new PrimaryExit("H", ""), new PrimaryExit("J",""), new PrimaryExit("I","")};
        //PrimaryExit[] zone1Secondaries = {new PrimaryExit("H", ""), new PrimaryExit("J",""), new PrimaryExit("I","")};
        
        Zone zone1 = new Zone(zone1Primaries, zone1Primaries);
         
        String bestNode = "";
        double lowestCost = 123456789;
        
        //Look at every node associated with the Zone
        for(PrimaryExit exitNode: zone1.getPrimaryExits()){
            //Test w/ algorithm each node as a starting point to same destination
            double currentCost = map.costFromTo(exitNode.getStrId(), endNode);
            
            //Compares if current node is less costlier
            if ( currentCost < lowestCost){
                lowestCost = currentCost;
                
                //Sets best node
                bestNode = exitNode.getStrId();
            }
        }    
        
        //Searches with the best node
        //LINKED LIST
        System.out.println(lowestCost);
        ArrayList<LinkedList<String>> paths = (ArrayList) map.searchFromTo(bestNode, endNode);
        System.out.println(paths.get(0));
 
    }
}

