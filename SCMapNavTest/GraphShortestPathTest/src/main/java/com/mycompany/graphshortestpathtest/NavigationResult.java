package com.mycompany.graphshortestpathtest;

import java.util.LinkedList;

public class NavigationResult{
    public final LinkedList<String> bestPath;
    public final double cost;
    
    public NavigationResult(LinkedList<String> bestPath, double cost){
        this.bestPath = bestPath;
        this.cost = cost;
    }
}