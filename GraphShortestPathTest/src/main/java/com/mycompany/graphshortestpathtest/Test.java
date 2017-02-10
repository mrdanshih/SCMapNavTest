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
    public static void main(String[] args) throws Exception{
        IndoorSearchSimulator simulator = new IndoorSearchSimulator();
        //Searches with the best node
        
        //LINKED LIST
        String startZone = "Zone 1";
        String userSearch = "Newspaper";
        //If you search for same name/ multiple secondary exits to same destination, doesn't return shortest path. Find way to fix?????
        System.out.println("START: " + startZone + " END: " + userSearch);
        
        ArrayList<LinkedList<String>> paths = (ArrayList) simulator.getDirections(startZone, userSearch);
        System.out.println(paths.get(0));
 
    }
}

