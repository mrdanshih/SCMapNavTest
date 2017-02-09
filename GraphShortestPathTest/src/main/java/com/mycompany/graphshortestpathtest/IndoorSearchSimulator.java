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
    
    // THE FOLLOWING ARE JUST HARDCODED ZONE/EXIT INFORMATION, TO SIMULATE SOMETHING
    // THAT A DATABASE WOULD PROBABLY STORE.
    
    /* Zone 1:
            Primaries: A, B       Secondaries/Destinations: Jamba Juice, Restroom
       Zone 2:
            Primaries: B, C        Secondaries/Destinations: Panda Express
       Zone 3:
            Primaries: C, D         Secondaries/Destinations: none
        
    */      
    
    //Zone 1
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
      PrimaryExit P3 = new PrimaryExit("P3"); 
      PrimaryExit P4 = new PrimaryExit("P4"); 
      PrimaryExit[] zone2Primaries = {P2, P3, P4};    

      //Setting up a secondary exit (physical destination) with associated primaries
      Object[] S2Primaries = {P2, 10.0, P3, 7.0, P4, 15.0};
      SecondaryExit S2 = new SecondaryExit("S2", "Newspaper Main", S2Primaries);
      
      Object[] S3Primaries = {P2, 12.0, P3, 15.0, P4, 5.0};
      SecondaryExit S3 = new SecondaryExit("S3", "Computer Lab Main", S3Primaries);
      

      SecondaryExit[] zone2Secondaries = {S2, S3};
      Zone zone2 = new Zone(zone2Primaries, zone2Secondaries);

      
      //Zone 3
      //---This zone does not have any destinations----
      //P4 ALREADY EXISTS
      PrimaryExit P5 = new PrimaryExit("P5");   
      PrimaryExit[] zone3Primaries = {P4, P5};    
      
      //Secondaries in Zone 3
      Object[] S4Primaries = {P4, 33.0, P5, 11.0};
      SecondaryExit S4 = new SecondaryExit("S4", "Newspaper Side", S4Primaries);
      
      SecondaryExit[] zone3Secondaries = {S4};
      Zone zone3 = new Zone(zone3Primaries, zone3Secondaries);

      
      //Zone 4
      //P5 ALREADY INSTANTIATED
      PrimaryExit P6 = new PrimaryExit("P6"); 
      PrimaryExit P7 = new PrimaryExit("P7"); 
      PrimaryExit[] zone4Primaries = {P5, P6, P7};    

      //Setting up a secondary exit (physical destination) with associated primaries
      Object[] S5Primaries = {P5, 8.0, P6, 36.0, P7, 34.0};
      SecondaryExit S5 = new SecondaryExit("S5", "Computer Lab Side", S5Primaries);
      
      Object[] S6Primaries = {P5, 27.0, P6, 20.0, P7, 15.0};
      SecondaryExit S6 = new SecondaryExit("S6", "Bathroom", S6Primaries);
      
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
      SecondaryExit S14 = new SecondaryExit("S14", "Computer Lab Courtyard", S14Primaries);

      SecondaryExit[] zone8Secondaries = {S13, S14};
      Zone zone8 = new Zone(zone8Primaries, zone8Secondaries);    
      
      
      Zone[] listOfZones = {zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8};
      
      //This is the object that represents the indoor "map"
      Searcher map = new Searcher();
    
      
    public List getDirections(String detectedStartZone, String userSearch) throws Exception{
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
        
        if(detectedStartZone.equals("Zone 1")){
            startZone = zone1;
        }else if(detectedStartZone.equals("Zone 2")){
            startZone = zone2;
        }else if(detectedStartZone.equals("Zone 3")){
            startZone = zone3;
        }else if(detectedStartZone.equals("Zone 4")){
            startZone = zone4;
        }else if(detectedStartZone.equals("Zone 5")){
            startZone = zone5;
        }else if(detectedStartZone.equals("Zone 6")){
            startZone = zone6;    
        }else if(detectedStartZone.equals("Zone 7")){
            startZone = zone7;
        }else if(detectedStartZone.equals("Zone 8")){
            startZone = zone8;
        }else{
            throw new Exception(detectedStartZone + ": ZONE NOT FOUND");
        }
      
        String endNode = prepareUserSearchAndGetEndNode(userSearch);
        String bestStartNodeInZone = getBestStartNode(startZone, endNode);
        
        return map.searchFromTo(bestStartNodeInZone, endNode);

    }
    
    private String prepareUserSearchAndGetEndNode(String userSearch) throws Exception{
        /* Does two things:
         * 1. Takes in the physical name of a location a USER would search for,
         * and returns the ID of the end secondary exit that the location
         * corresponds to. 
         * 
         * 2. Completes the building of the Searcher object, by finishing
         * the building of the map. The method adds to the map the relevant
         * end secondary exit (and the edges to connecting primary exits)
         * for the destination location. Finally, it builds the undirected map by 
         * calling the relevant method in the Searcher object.
        
         * The returned result is a node name that is on the graph.

        */
        
        String endNodeId = null;
        
        for(Zone zone: listOfZones){
           if(zone.getSecondaryExits() != null){
               for(SecondaryExit secondary: zone.getSecondaryExits()){
                   String secondaryPhysicalLocation = secondary.getLocationName();

                   if(secondaryPhysicalLocation.equals(userSearch)){
                       //Right now, the "endNode ID" is just the same as the location name...
                       // might change for efficieny's sake later.
                       endNodeId = secondary.getId();
                       
                       //Connections to primaries of the secondary
                       for(HashMap.Entry entry: secondary.getFromToPrimaryMap().entrySet()){
                           map.addEdgeToGraph(endNodeId, ((PrimaryExit) entry.getKey()).getId(), (double) entry.getValue());                     
                       }
                       
                       map.buildGraph();
                       
                       break;         
                   }
               }
           }
       }
       
        if(endNodeId == null){
            throw new Exception(userSearch + ": NO SECONDARY EXIT FOUND FOR LOCATION");
        }
        return endNodeId;
        
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
