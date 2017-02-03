package com.mycompany.graphshortestpathtest;

import es.usc.citius.hipster.algorithm.Hipster;
import es.usc.citius.hipster.graph.GraphBuilder;
import es.usc.citius.hipster.graph.GraphSearchProblem;
import es.usc.citius.hipster.graph.HipsterGraph;
import es.usc.citius.hipster.model.impl.WeightedNode;
import es.usc.citius.hipster.model.problem.SearchProblem;
import java.util.List;

public class Searcher {
    GraphBuilder<String,Double> graphTemplate;
    
    HipsterGraph<String,Double> graph; 
    
    public Searcher(){
//        graphTemplate = GraphBuilder.<String,Double>create()
//            //All edge values in feet.
//            .connect("A").to("B").withEdge(40d)
//            .connect("B").to("C").withEdge(15d)
//            .connect("B").to("D").withEdge(18d)
//            .connect("C").to("D").withEdge(16d)
//            .connect("D").to("E").withEdge(36d)
//            .connect("E").to("F").withEdge(40d)
//            .connect("E").to("G").withEdge(36d)
//            .connect("F").to("G").withEdge(10d)
//            .connect("G").to("H").withEdge(38d)
//            .connect("H").to("I").withEdge(18d)    
//            .connect("H").to("J").withEdge(16d)
//            .connect("I").to("J").withEdge(8d)
//            .connect("J").to("A").withEdge(65d);   
        graphTemplate = GraphBuilder.<String,Double>create()
            //All edge values in feet.
            .connect("A").to("B").withEdge(10d)
            .connect("B").to("C").withEdge(12d)
            .connect("C").to("D").withEdge(14d)
            .connect("D").to("E").withEdge(4d)
            .connect("E").to("A").withEdge(12d);
    }
    
    //Above and below methods allow us to add relevant secondary exits to the graph without fully rebuilding
    //the primay exits into the graph when they will always be there anyway 
    
    //WORK IN PROGRESS
    
    //This is for adding additional nodes to the graph.
    public void addToGraph(String a, String b, double edgeValue){
        graphTemplate.connect(a).to(b).withEdge(edgeValue);
        
        graph = graphTemplate.createUndirectedGraph();
        
    }
    
    public double costFromTo(String start, String end){
        if (graph == null){
            graph = graphTemplate.createUndirectedGraph();
        }
            
        SearchProblem problem = GraphSearchProblem
                                .startingFrom(start)
                                .in(graph)
                                .takeCostsFromEdges()
                                .build();
        WeightedNode node = (WeightedNode) Hipster.createDijkstra(problem).search(end).getGoalNode();
        return (double) (node.getCost());
    }
    
    public List searchFromTo(String start, String end){
        if (graph == null){
            graph = graphTemplate.createUndirectedGraph();
        }
        
        SearchProblem problem = GraphSearchProblem
                                .startingFrom(start)
                                .in(graph)
                                .takeCostsFromEdges()
                                .build();

        return Hipster.createDijkstra(problem).search(end).getOptimalPaths();
    }
    
    
    
    
}