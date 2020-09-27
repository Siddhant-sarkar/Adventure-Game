package com.sarkarSiddhant.developer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        Map<String,Integer >tempExit=new HashMap<>();

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",null));

        tempExit=new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));

        tempExit=new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));


        tempExit=new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));


        tempExit=new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));



        tempExit=new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest",tempExit));



        int loc = 1;
        while(true) {
            System.out.println(locations.get(loc).getDescription());
            tempExit.remove("S");
            if(loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for(String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            String finalDirection=directionTeller(direction.split(" "));


            if(exits.containsKey(finalDirection)) {
                loc = exits.get(finalDirection);

            } else {
                System.out.println("You cannot go in that direction");
            }
        }
    }
    public static String directionTeller(String[]test){
        for (int i=0;i<test.length;i++){
            if ((test[i].toUpperCase().equals("NORTH"))){
                return "N";
            }else if ((test[i].toUpperCase().equals("EAST"))){
                return "E";
            }else if ((test[i].toUpperCase().equals("WEST"))){
                return "W";
            }else if ((test[i].toUpperCase().equals("SOUTH"))){
                return "S";
            }else if ((test[i].toUpperCase().equals("QUIT"))){
                return "Q";
            }
        }
        return null;
    }
}
