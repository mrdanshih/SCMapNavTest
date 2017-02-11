/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graphshortestpathtest;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author dzshih
 */
public class IndoorSearchSimulator{
    /**
     * A TEST CLASS FOR SIMULATING AN INDOOR SEARCH.
     * It sets up a few "zones" (with primary nodes, secondary nodes), 
     * then creates a list of these Zones.
     */
    
    //Zone 1
      String[] P1Neighbors = {"P2", "Go through white doors to lobby, turn right inside, and walk straight towards doors in hall",
                              "P10", "Walk straight through the courtyard"};
      String[] P2Neighbors = {"P1", "Walk straight down the hall, and turn left to go through the doors to outside courtyard",
                                "P3", "Walk straight forward and go through a blue door",
                                "P4", "Slant right and walk into the next hallway"};
                                     
      PrimaryExit P1 = new PrimaryExit("P1");
      PrimaryExit P2 = new PrimaryExit("P2");

      PrimaryExit[] zone1Primaries = {P1, P2};

      //Setting up a secondary exit (physical destination) with associated primaries
      Object[] S1Primaries = {P1, 45.0, P2, 60.0};
      SecondaryExit S1 = new SecondaryExit("S1", "Myrmey the Anteater Stairs", S1Primaries);

      SecondaryExit[] zone1Secondaries = {S1};
      Zone zone1 = new Zone(zone1Primaries, zone1Secondaries);


      //Zone 2
      //P2 ALREADY INSTANTIATED
      //P3 is useless fo rnow, disregard it sneighbors
      String[] P4Neighbors = {"P2", "Slant right then turn left at the doors",
                                "P5", "Walk down hallway to next set of doors"};
      
      PrimaryExit P3 = new PrimaryExit("P3"); 
      PrimaryExit P4 = new PrimaryExit("P4"); 
      
      PrimaryExit[] zone2Primaries = {P2, P3, P4};    

      //Setting up a secondary exit (physical destination) with associated primaries
      Object[] S2Primaries = {P2, 10.0, P3, 7.0, P4, 15.0};
      SecondaryExit S2 = new SecondaryExit("S2", "Newspaper", S2Primaries);
      
      Object[] S3Primaries = {P2, 12.0, P3, 15.0, P4, 5.0};
      SecondaryExit S3 = new SecondaryExit("S3", "Computer Lab", S3Primaries);
      

      SecondaryExit[] zone2Secondaries = {S2, S3};
      Zone zone2 = new Zone(zone2Primaries, zone2Secondaries);

      
      //Zone 3
      //---This zone does not have any destinations----
      //P4 ALREADY EXISTS
      PrimaryExit P5 = new PrimaryExit("P5");   
      PrimaryExit[] zone3Primaries = {P4, P5};    
      
      //Secondaries in Zone 3
      Object[] S4Primaries = {P4, 33.0, P5, 11.0};
      SecondaryExit S4 = new SecondaryExit("S4", "Newspaper", S4Primaries);
      
      SecondaryExit[] zone3Secondaries = {S4};
      Zone zone3 = new Zone(zone3Primaries, zone3Secondaries);

      
      //Zone 4
      //P5 ALREADY INSTANTIATED
      PrimaryExit P6 = new PrimaryExit("P6"); 
      PrimaryExit P7 = new PrimaryExit("P7"); 
      PrimaryExit[] zone4Primaries = {P5, P6, P7};    

      //Setting up a secondary exit (physical destination) with associated primaries
      Object[] S5Primaries = {P5, 8.0, P6, 36.0, P7, 34.0};
      SecondaryExit S5 = new SecondaryExit("S5", "Computer Lab", S5Primaries);
      
      Object[] S6Primaries = {P5, 27.0, P6, 20.0, P7, 15.0};
      SecondaryExit S6 = new SecondaryExit("S6", "Restroom", S6Primaries);
      
      Object[] S7Primaries = {P5, 70.0, P6, 18.0, P7, 22.0};
      SecondaryExit S7 = new SecondaryExit("S7", "Operations", S7Primaries);

      SecondaryExit[] zone4Secondaries = {S5, S6, S7};
      Zone zone4 = new Zone(zone4Primaries, zone4Secondaries);
      
      
      //Zone 5
      //P7 ALREADY INSTANTIATED
      PrimaryExit P8 = new PrimaryExit("P8");  
      PrimaryExit[] zone5Primaries = {P7, P8};    

      //Setting up a secondary exit (physical destination) with associated primaries
      Object[] S8Primaries = {P7, 15.0, P8, 20.0};
      SecondaryExit S8 = new SecondaryExit("S8", "IT Office", S8Primaries);
      
      Object[] S9Primaries = {P7, 40.0, P8, 13.0};
      SecondaryExit S9 = new SecondaryExit("S9", "Marketing Photos", S9Primaries);
      
      Object[] S10Primaries = {P7, 38.0, P8, 5.0};
      SecondaryExit S10 = new SecondaryExit("S10", "Marketing", S10Primaries);

      SecondaryExit[] zone5Secondaries = {S8, S9, S10};
      Zone zone5 = new Zone(zone5Primaries, zone5Secondaries);
      
      
      //Zone 6
      //PRIMARY EXITS ONLY IN THIS ZONE - NO PHYSICAL DESTINATIONS 
      //p8 already instantiated
      PrimaryExit P9 = new PrimaryExit("P9"); 
      PrimaryExit P10 = new PrimaryExit("P10");  
      PrimaryExit[] zone6Primaries = {P8, P9, P10};    

      Zone zone6 = new Zone(zone6Primaries);
      
      //Zone 7
      //P9 Already exists
      PrimaryExit[] zone7Primaries = {P9};    

      //Setting up a secondary exit (physical destination) with associated primaries
      Object[] S11Primaries = {P9, 16.0};
      SecondaryExit S11 = new SecondaryExit("S11", "Blood Donor Center", S11Primaries);
      
      Object[] S12Primaries = {P9, 22.0};
      SecondaryExit S12 = new SecondaryExit("S12", "Courtyard Study Lounge", S12Primaries);

      SecondaryExit[] zone7Secondaries = {S11, S12};
      Zone zone7 = new Zone(zone7Primaries, zone7Secondaries);      

    
      //Zone 8
      //P10 and P1 exist already
      PrimaryExit[] zone8Primaries = {P10, P1};    

      //Setting up a secondary exit (physical destination) with associated primaries
      Object[] S13Primaries = {P10, 23.0, P1, 50.0};
      SecondaryExit S13 = new SecondaryExit("S13", "Courtyard Study Lounge", S13Primaries);
      
      Object[] S14Primaries = {P10, 27.0, P1, 41.0};
      SecondaryExit S14 = new SecondaryExit("S14", "Computer Lab", S14Primaries);

      SecondaryExit[] zone8Secondaries = {S13, S14};
      Zone zone8 = new Zone(zone8Primaries, zone8Secondaries);    
      
      
      Zone[] listOfZones = {zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8};
      
      //This is the object that represents the indoor "map"
      Searcher map = new Searcher();
    
      
    public NavigationResult getDirections(String detectedStartZone, String userSearch) throws Exception{
        /* Algorithm used to get directions:
            1. The phone would report a zone that it is in, and a user would 
                have specified a destination location.
            2. Find the end node that corresponds to the user's destination,
                build the map to include that destination, and return 
                the ID for that node so it can be used in the search
            3. Find the start node (an exit from the Zone) that is best for the
                to use. In other words, which way should the user leave the zone?
            4. Use the map to find the shortest path from the start node to the end node.
            5. Return that path (a list of directions)
        
        */
        Zone startZone;
        
        int startZoneNumber = Character.getNumericValue(detectedStartZone.charAt(detectedStartZone.length() - 1));
        
        if(startZoneNumber >= 1 && startZoneNumber <= 8){
            startZone = listOfZones[startZoneNumber - 1];
        }else{
            throw new Exception("START ZONE INVALID");
        }
        
        StartEndStringPair fromToPair = prepareSearchAndGetStartEndNodes(startZone, userSearch);
        
        return map.searchFromTo(fromToPair.startNode, fromToPair.endNode);
    }
    
     private StartEndStringPair prepareSearchAndGetStartEndNodes(Zone startZone, String userSearch) throws Exception{
        /* The following method implements an algorithm that is designed to find two things (returns these):
           1. The best PRIMARY exit node that a user should take out of a START ZONE to a destination (starting point of path)
           2. What SECONDARY exit would get a user to their destination the quickest. 
              Because some areas may have MULTIPLE entries/exits (the Computer Lab, for example),
              the app needs to recognize that there are multiple ways to get to the same destination.
              
              The algorithm implemented here accounts for that.
             
           STEP-BY-STEP:
           Keep track of a the BEST STARTING NODE, BEST SECONDARY EXIT, and BEST COST (aka shortest way to get from A-->B)
           
           For every zone in the building:
             For every secondary exit in the Zone:
               If a secondary exit leads to the user's destination:
                 Find the best start node in the Zone to this secondary exit.
         
                 If the total distance taken using the path from this best start node
                 to the destination via this secondary exit is lower than
                 the distance using the current best path.... 
                (the current best path might use a different STARTING NODE 
                 and uses a different SECONDARY EXIT to the same destination)
                    Update the BEST STARTING NODE, SECONDARY EXIT, AND COST to these.
               
            In the end, return the BEST START NODE and BEST SECONDARY EXIT
         
         */
  
        String bestStartNode = "";
        SecondaryExit bestMatchingSecondary = null;
        double bestCost = 999999;
        
        for(Zone zone: listOfZones){
           if(zone.getSecondaryExits() != null){
               
               for(SecondaryExit secondary: zone.getSecondaryExits()){
                   String secondaryPhysicalLocation = secondary.getLocationName();
                  
                   if(secondaryPhysicalLocation.equals(userSearch)){
                       //Found a secondary exit node that leads to the destination
                       String endNodeId = secondary.getId();
                       
                       /*Add connections to this secondary to the map, and build it. 
                        *This method will build a new map everytime with just the connections
                        *to the secondary that it's checking right now.
                        */
                       finishBuildingMap(secondary);
                       
                       /*Find the best start node (in the start Zone) to use to get 
                         to the secondary exit currently being checked.
                         
                         Depending on WHICH secondary exit is being checked, the best
                         start node in the same Zone may change. Thus, this needs to be
                         redone for EVERY secondary exit that matches the physical destination.
                       */
                       String zoneStartNode = getBestStartNode(startZone, endNodeId);      
                       
                       /*Now find the cost from the start node to the end node
                        *Get and save the cost it would take using the path from 
                        *the best start node in the Zone to the current secondary exit being
                        *examined.
                       */
                       double costUsingCurrentSecondary = map.costFromTo(zoneStartNode, endNodeId);

                       /* If the path leading to the destination would be shorter than
                          the current best path...
                          update the best start and end nodes to the currently examined start/end nodes.
                          Of course, update the best cost as well.      
                       */
                       
                       if(costUsingCurrentSecondary < bestCost){
                           bestStartNode = zoneStartNode;
                           bestMatchingSecondary = secondary;
                           bestCost = costUsingCurrentSecondary;
                       }                
                   }
               }
           }
       }
       
        if(bestMatchingSecondary != null){
            //No need to build the map again, because now the map should be built with
            //only the best secondary exit to the destination
            
            //Returns the start/end pair that should be used for the search.
            return new StartEndStringPair(bestStartNode, bestMatchingSecondary.getId());
            
        }else{
            throw new Exception(userSearch + ": NO SECONDARY EXIT FOUND FOR LOCATION");
        }
        
    }
    
    private void finishBuildingMap(SecondaryExit secondary){
        for(HashMap.Entry entry: secondary.getFromToPrimaryMap().entrySet()){
            map.addEdgeToGraph(secondary.getId(), ((PrimaryExit) entry.getKey()).getId(), (double) entry.getValue());                      
        }
        map.buildGraph();
    } 
      
    private String getBestStartNode(Zone startZone, String endNode){
        String bestNode = "";
        
        //Arbitary max for now? Probably change to something better later
        double lowestCost = 999999;
        
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
        return bestNode;
        
    }
}


class StartEndStringPair{
    public final String startNode;
    public final String endNode;
    
    public StartEndStringPair(String start, String end){
        startNode = start;
        endNode = end;
    }
    
}