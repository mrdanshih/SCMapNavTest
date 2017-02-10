package com.mycompany.graphshortestpathtest;

import es.usc.citius.hipster.algorithm.Hipster;
import es.usc.citius.hipster.graph.GraphBuilder;
import es.usc.citius.hipster.graph.GraphSearchProblem;
import es.usc.citius.hipster.graph.HipsterGraph;
import es.usc.citius.hipster.model.impl.WeightedNode;
import es.usc.citius.hipster.model.problem.SearchProblem;
import java.util.List;

public class Searcher {
    private final GraphBuilder<String,Double> graphTemplate;
    
    private HipsterGraph<String,Double> graph; 
    
    public Searcher(){
        /*Take in a list of Zones, 
         * which shall contain primary exits and secondary exits.
         */
        
        graphTemplate = GraphBuilder.<String,Double>create()
           //All edge values in feet.
            .connect("P1").to("P2").withEdge(40d)
            .connect("P2").to("P3").withEdge(15d)
            .connect("P2").to("P4").withEdge(18d)
            .connect("P3").to("P4").withEdge(16d)
            .connect("P4").to("P5").withEdge(36d)
            .connect("P5").to("P6").withEdge(40d)
            .connect("P5").to("P7").withEdge(36d)
            .connect("P6").to("P7").withEdge(10d)
            .connect("P7").to("P8").withEdge(38d)
            .connect("P8").to("P9").withEdge(18d)    
            .connect("P8").to("P10").withEdge(16d)
            .connect("P9").to("P10").withEdge(8d)
            .connect("P10").to("P1").withEdge(65d);

        /* Builds a temporary hard coded graph for the primary exits within a building. 
         * This graph template will ALWAYS be the base graph for any search. 
         * Before a search can be performed, this graphTemplate MUST be built.
         */
//       graphTemplate = GraphBuilder.<String,Double>create()
//            //All edge values in feet.
//            .connect("A").to("B").withEdge(10d)
//            .connect("B").to("C").withEdge(12d)
//            .connect("C").to("D").withEdge(14d)
//            .connect("D").to("E").withEdge(4d)
//            .connect("E").to("A").withEdge(12d);
    }
    
    //Above and below methods allow us to add relevant secondary exits to the graph without fully rebuilding
    //the primay exits into the graph when they will always be there anyway 
    
    //WORK IN PROGRESS
    
    //This is for adding additional nodes to the graph.
    public void addEdgeToGraph(String a, String b, double edgeValue){
        /*
         * Adds one additional edge (start, end, value) to the graphTemplate
         */
        graphTemplate.connect(a).to(b).withEdge(edgeValue);
    }
    
    public void buildGraph(){
        /*
         * Should be called whenever a user is ready to use the graph.
         * Builds whatever is in the graph template into a usable graph.
         * The built graph is then ready to be used in a search.
         */
        graph = graphTemplate.createUndirectedGraph();
    }
    
    public double costFromTo(String start, String end){
        /*
         * Computes the cost of a the shortest path from the start node to the end node
         */
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
        /*
         * Returns a list of shortest paths (if there is more than one best one),
         * containing lists with the individual steps/nodes along that path,
         * from the start node to the end node
         */
        
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