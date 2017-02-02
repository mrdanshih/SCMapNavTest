/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graphshortestpathtest;
import es.usc.citius.hipster.algorithm.Hipster;
import es.usc.citius.hipster.graph.*;
import es.usc.citius.hipster.model.impl.WeightedNode;
import es.usc.citius.hipster.model.problem.SearchProblem;

/**
 *
 * @author dzshih
 */
public class Test {
    public static void main(String[] args){
        Searcher map = new Searcher();
        
        String endNode = "G";
        
        
        //Assume Zone 1
        PrimaryExit[] zone1Primaries = {new PrimaryExit("H", ""), new PrimaryExit("J",""), new PrimaryExit("I","")};
        PrimaryExit[] zone1Secondaries = {new PrimaryExit("H", ""), new PrimaryExit("J",""), new PrimaryExit("I","")};
        
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
        map.searchFromTo(bestNode, endNode);
 
    }
}

class Searcher {
    GraphBuilder<String,Double> graphTemplate;
    
    HipsterGraph<String,Double> graph; 
    
    public Searcher(){
        graphTemplate = GraphBuilder.<String,Double>create()
            //All edge values in feet.
            .connect("A").to("B").withEdge(40d)
            .connect("B").to("C").withEdge(15d)
            .connect("B").to("D").withEdge(18d)
            .connect("C").to("D").withEdge(16d)
            .connect("D").to("E").withEdge(36d)
            .connect("E").to("F").withEdge(40d)
            .connect("E").to("G").withEdge(36d)
            .connect("F").to("G").withEdge(10d)
            .connect("G").to("H").withEdge(38d)
            .connect("H").to("I").withEdge(18d)    
            .connect("H").to("J").withEdge(16d)
            .connect("I").to("J").withEdge(8d)
            .connect("J").to("A").withEdge(65d);   
    }
    
    //Above and below methods allow us to add relevant secondary exits to the graph without fully rebuilding
    //the primay exits into the graph when they will always be there anyway 
    
    //WORK IN PROGRESS
    
    public void setGraph(String a, String b, double edgeValue){
        graph = graphTemplate.connect(a).to(b).withEdge(edgeValue).createUndirectedGraph();
        
    }
    
    public double costFromTo(String start, String end){
        SearchProblem problem = GraphSearchProblem
                                .startingFrom(start)
                                .in(graph)
                                .takeCostsFromEdges()
                                .build();
        WeightedNode node = (WeightedNode) Hipster.createDijkstra(problem).search(end).getGoalNode();
        return (double) (node.getCost());
    }
    
    public void searchFromTo(String start, String end){
        SearchProblem problem = GraphSearchProblem
                                .startingFrom(start)
                                .in(graph)
                                .takeCostsFromEdges()
                                .build();
        System.out.println(Hipster.createDijkstra(problem).search(end).getOptimalPaths());
    }
    
    
    
    
}
