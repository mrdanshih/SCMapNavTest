/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graphshortestpathtest;
import java.util.*;
import java.util.HashMap;
/**
 *
 * @author dzshih
 */
public class Test {
    HashMap<String,HashMap<String,String>> primaryToPrimaryDescriptionsMap;
    
    public static void main(String[] args) throws Exception{
        Test test = new Test();
        test.initializePrimaryDescriptionMap();
        test.testNavigation();
    }
    
    private void testNavigation() throws Exception{
        IndoorSearchSimulator simulator = new IndoorSearchSimulator();
        //Searches with the best node
        
        //LINKED LIST
        String startZone = "Zone 1";
        String userSearch = "Restroom";
        //If you search for same name/ multiple secondary exits to same destination, doesn't return shortest path. Find way to fix?????
        System.out.println("START: " + startZone + " END: " + userSearch);
        
        NavigationResult navResult = simulator.getDirections(startZone, userSearch);
        LinkedList<String> steps = navResult.bestPath;
        System.out.println("COST: " + navResult.cost);
        printFormattedSteps(steps, userSearch);
        
    }
    
    private void printFormattedSteps(LinkedList<String> steps, String destination){
        String previous = steps.get(0);
        System.out.println("First go through " + steps.get(0));
        
        for(int i = 1; i < steps.size() - 1; i++){
            if(primaryToPrimaryDescriptionsMap.containsKey(previous)){
                System.out.print(steps.get(i) + " ");
                System.out.println(primaryToPrimaryDescriptionsMap.get(previous).get(steps.get(i)));
            }else{
                System.out.println(steps.get(i));
                
            }
            previous = steps.get(i);
            
        }
        
        System.out.println("You've reached " + destination + "!");
    }
    
    private void initializePrimaryDescriptionMap(){
        primaryToPrimaryDescriptionsMap = new HashMap<>();
        HashMap<String,String> P1Neighbors = new HashMap<>();
        P1Neighbors.put("P2", "Go through white doors to lobby, turn right inside, and walk straight towards doors in the hall");
        P1Neighbors.put("P10", "Walk straight through the courtyard");
        primaryToPrimaryDescriptionsMap.put("P1", P1Neighbors);
        
        
        HashMap<String,String> P2Neighbors = new HashMap<>();
        P2Neighbors.put("P1", "Walk straight down the hall, and turn left to go through the doors to outside courtyard");
        P2Neighbors.put("P3", "Walk straight forward and go through a blue door");
        P2Neighbors.put("P4", "Slant right and walk into next hallway");
        primaryToPrimaryDescriptionsMap.put("P2", P2Neighbors);   
        
        HashMap<String,String> P4Neighbors = new HashMap<>();
        P4Neighbors.put("P2", "Slant right and then make a left");
        P4Neighbors.put("P3", "Turn right and approach doors");
        P4Neighbors.put("P5", "Walk towards end of hallway");
        primaryToPrimaryDescriptionsMap.put("P4", P4Neighbors);   
        
        
        HashMap<String,String> P5Neighbors = new HashMap<>();
        P5Neighbors.put("P4", "Slant left and walk towards end of hallway");
        P5Neighbors.put("P7", "Walk down hallway then turn right at first fork");
        primaryToPrimaryDescriptionsMap.put("P5", P5Neighbors);   
    }
}


