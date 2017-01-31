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
        String[] list = {"H","J","I"};
        Zone zone1 = new Zone(list);
         
        String bestNode = "";
        double lowestCost = 123456789;
        
        //Look at every node associated with the Zone
        for(String exitNode: zone1.getNodes()){
            //Test w/ algorithm each node as a starting point to same destination
            double currentCost = map.costFromTo(exitNode, endNode);
            
            //Compares if current node is less costlier
            if ( currentCost < lowestCost){
                lowestCost = currentCost;
                
                //Sets best node
                bestNode = exitNode;
            }
        }    
        
        //Searches with the best node
        map.searchFromTo(bestNode, endNode);
 
    }
}

class Searcher {
    HipsterGraph<String,Double> graph;
    
    public Searcher(){
        graph = GraphBuilder.<String,Double>create()
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
            .connect("J").to("A").withEdge(65d)  
            .createUndirectedGraph();
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
