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
      PrimaryExit A = new PrimaryExit("A");
      PrimaryExit B = new PrimaryExit("B");

      PrimaryExit[] zone1Primaries = {A, B};

      //Setting up a secondary exit (physical destination) with associated primaries
      Object[] jambaJuicePrimaries = {A, 2.0, B, 6.0};
      SecondaryExit jambaJuice = new SecondaryExit("Jamba Juice", jambaJuicePrimaries);

      Object[] restroomPrimaries = {A, 5.0, B, 4.0};
      SecondaryExit restroom = new SecondaryExit("Restroom", restroomPrimaries);

      SecondaryExit[] zone1Secondaries = {jambaJuice, restroom};
      Zone zone1 = new Zone(zone1Primaries, zone1Secondaries);


      //Zone 2
      PrimaryExit C = new PrimaryExit("C");   
      PrimaryExit[] zone2Primaries = {B, C};    

      //Setting up a secondary exit (physical destination) with associated primaries
      Object[] pandaPrimaries = {C, 4.0, B, 5.0};
      SecondaryExit panda = new SecondaryExit("Panda Express", pandaPrimaries);

      SecondaryExit[] zone2Secondaries = {panda};

      Zone zone2 = new Zone(zone2Primaries, zone2Secondaries);

      //Zone 3
      //---This zone does not have any destinations----
      PrimaryExit D = new PrimaryExit("D");   
      PrimaryExit[] zone3Primaries = {C, D};      
      Zone zone3 = new Zone(zone3Primaries);

      //Zone 4
      PrimaryExit E = new PrimaryExit("E");
      PrimaryExit[] zone4Primaries = {D, E};
      Zone zone4 = new Zone(zone4Primaries);
      
      //Zone 5 
      PrimaryExit[] zone5Primaries = {A, E};
      Zone zone5 = new Zone(zone5Primaries);
      
      Zone[] listOfZones = {zone1, zone2, zone3, zone4, zone5};
      
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
         * (FOR NOW, ^ the above is not really implemented... the nodes just share
         * the same name as the physical location for now...
        */
        
        String endNode = null;
        
        for(Zone zone: listOfZones){
           if(zone.getSecondaryExits() != null){
               for(SecondaryExit secondary: zone.getSecondaryExits()){
                   String secondaryName = secondary.getLocationName();

                   if(secondaryName.equals(userSearch)){
                       //Right now, the "endNode ID" is just the same as the location name...
                       // might change for efficieny's sake later.
                       endNode = secondary.getLocationName();
                       
                       //Connections to primaries of the secondary
                       for(HashMap.Entry entry: secondary.getFromToPrimaryMap().entrySet()){
                           map.addEdgeToGraph(secondaryName, ((PrimaryExit) entry.getKey()).getId(), (double) entry.getValue());                     
                       }
                       
                       map.buildGraph();
                       
                       break;         
                   }
               }
           }
       }
       
        if(endNode == null){
            throw new Exception(userSearch + ": NO SECONDARY EXIT FOUND FOR LOCATION");
        }
        return endNode;
        
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
