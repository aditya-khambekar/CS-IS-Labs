package Showdown;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Showdown {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        Integer numProblems = Integer.parseInt(input.nextLine().trim());
        //input.nextLine();
        Queue<String> q = new LinkedList<String>();
        while(numProblems-->0&&input.hasNextLine()){
            
                ArrayList<Player> list = new ArrayList<Player>();
                Player desired = null;
                for(int i = 0; i<5; i++){
                    try {
                        if(desired==null){
                            desired = new Player(input.nextLine());
                            list.add(desired);
                        }else{
                            list.add(new Player(input.nextLine()));
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
                q.add(solve(list, desired));
        }

        while(q.size()>0){
            System.out.println(q.remove());
        }
        
    }

    public static class Player implements Comparable{
        int trophies, power, health;

        public Player(String s){
            //System.out.println("s = "+s);
            List<String> list = Arrays.asList(s.split(","));
            //System.out.println(list);
            trophies = Integer.parseInt(list.get(0).trim());
            //System.out.println("trophies = "+trophies);
            power = Integer.parseInt(list.get(1).trim());
            //System.out.println("power = "+power);
            health = Integer.parseInt(list.get(2).trim());
            //System.out.println("health = "+health);
        }

        @Override
        public int compareTo(Object o) {
            Player p = (Player)o;
            if(trophies>p.trophies&&health>p.health&&Math.abs(power-p.power)<=3){
                return -1;
            }else if(p.trophies>trophies&&p.health>health&&Math.abs(power-p.power)<=3){
                return 1;
            }else{
                return p.power - power;
            }
        }
    }

    public static String solve(List<Player>p, Player desired){
        Collections.sort(p);
        int place = p.indexOf(desired);

        switch(place){
            case 0:
                desired.trophies+=10;
                return place+1+", "+desired.trophies;
            case 1:
                desired.trophies+=5;
                return place+1+", "+desired.trophies;
            case 2:
                return place+1+", "+desired.trophies;
            case 3:
                desired.trophies-=5;
                return place+1+", "+desired.trophies;
            case 4:
                desired.trophies-=10;
                return place+1+", "+desired.trophies;
            default: 
                return "";
        }
    }
}
