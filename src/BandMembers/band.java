package BandMembers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class band{//this one doesnt work yet
    public static void main(String[]Args){
        Queue<unitRunner> q = new LinkedList<unitRunner>();
        Scanner kb = new Scanner(System.in);
        
        int numBands = Integer.parseInt(kb.nextLine());
        System.out.println(numBands+" bands");
        
        for(int i = 0; i<numBands; i++){
            q.add(new band.unitRunner(kb.nextLine(), kb.nextLine(),kb.nextLine(),kb.nextLine(),kb.nextLine(),kb.nextLine(),kb.nextLine(),kb.nextLine(),kb.nextLine()));
            //System.out.println("thing done ()");
        }
    }
    
    public static class unitRunner{
        public int money;

        player g1;
        player g2;
        player d1;
        player b1;
        player v1;

        HashMap<band.player.type, HashSet<band.player>> players = new HashMap<band.player.type, HashSet<band.player>>();

        

        public unitRunner(String supp, String gPrice, String gSkill, String dPrice, String dSkill, String bPrice, String bSkill, String vPrice, String vSkill){
            //System.out.println("unitRunner created"+supp+gPrice+gSkill+dPrice+dSkill+bPrice+bSkill+vPrice+vSkill);
            Scanner suppScanner = new Scanner(supp);
            Scanner gPScanner = new Scanner(gPrice);
            Scanner gSScanner = new Scanner(gSkill);
            Scanner dPScanner = new Scanner(dPrice);
            Scanner dSScanner = new Scanner(dSkill);
            Scanner bPScanner = new Scanner(bPrice);
            Scanner bSScanner = new Scanner(bSkill);
            Scanner vPScanner = new Scanner(vPrice);
            Scanner vSScanner = new Scanner(vSkill);
            
            
                players.put(band.player.type.GUITARIST, new HashSet<band.player>());
                players.put(band.player.type.DRUMMER, new HashSet<band.player>());
                players.put(band.player.type.BASSIST, new HashSet<band.player>());
                players.put(band.player.type.VOCALIST, new HashSet<band.player>());
            
            
            int guitarists = suppScanner.nextInt();
            for(int i = 0; i<guitarists; i++){
                band.player p = new band.player(band.player.type.GUITARIST, gPScanner.nextInt(), gSScanner.nextInt());
                players.get(band.player.type.GUITARIST).add(p);
            }
            int drummers = suppScanner.nextInt();
            for(int i = 0; i<drummers; i++){
                band.player p = new band.player(band.player.type.DRUMMER, dPScanner.nextInt(), dSScanner.nextInt());
                players.get(band.player.type.DRUMMER).add(p);
            }
            int bassists = suppScanner.nextInt();
            for(int i = 0; i<bassists; i++){
                band.player p = new band.player(band.player.type.BASSIST, bPScanner.nextInt(), bSScanner.nextInt());
                players.get(band.player.type.BASSIST).add(p);
            }
            int vocalists = suppScanner.nextInt();
            for(int i = 0; i<vocalists; i++){
                band.player p = new band.player(band.player.type.VOCALIST, vPScanner.nextInt(), vSScanner.nextInt());
                players.get(band.player.type.VOCALIST).add(p);
            }
            money = suppScanner.nextInt();

            /*for(band.player.type t:band.player.type.values()){
                for(band.player p:players.get(t)){
                    System.out.println(p);
                }
            }*/
        }

        public int totalPrice(){
            int price = 0;
            if(g1!=null){
                price += g1.price;
            }
            if(g2!=null){
                price += g2.price;
            }
            if(d1!=null){
                price += d1.price;
            }
            if(b1!=null){
                price += b1.price;
            }
            if(v1!=null){
                price += v1.price;
            }
            return price;
        }

        public player getRandom(HashSet<player> set){
            int i = (int)(Math.random()*set.size());
            for(player p:set){
                if(i++==0){
                    return p;
                }
            }
            return null;
        }

        public HashSet<HashSet<player>> createCombos(){
            HashSet<player> allPlayers = new HashSet<player>();
            for(band.player.type t:band.player.type.values()){
                for(player p:players.get(t)){
                    allPlayers.add(p);
                }
            }
            HashSet<HashSet<player>> ret = new HashSet<HashSet<player>>();
        }

        public boolean checkForEquals(HashSet<player> set1, HashSet<player> set2){
            for(player p:set1){
                if(!set2.contains(p)){
                    return false;
                }
            }
            return true;
        }
    }

    public static class player{
        public enum type{
            GUITARIST, 
            DRUMMER,
            BASSIST,
            VOCALIST
        }

        public type role;
        public Integer price;
        public Integer skill;

        public player(type t, Integer price, Integer skill){
            role = t;
            this.price = price;
            this.skill = skill;
        }

        public player(){
            role = null;
            price = 0;
            skill = Integer.MAX_VALUE;
        }

        public String toString(){
            return role+" - Price: "+price+", Skill: "+skill;
        }

        public boolean canPlay(type t){
            if(role==null||role==t){
                return true;
            }
            return false;
        }
    }

    
}
