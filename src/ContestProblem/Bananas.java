package ContestProblem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Bananas {
    public static void main(String[]args) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        int numProblems = Integer.parseInt(input.nextLine());//line 1
        for(int n = 0; n<numProblems; n++){
            String energy = input.nextLine();//line2
            int startingEnergy = Integer.parseInt(input.nextLine());//line 3
            String dimensions = input.nextLine();//line 4
            
            Scanner energyScanner = new Scanner(energy);
            Banana.energy = energyScanner.nextInt();
            Monkey.energyPerStep = energyScanner.nextInt();
            Scanner dimensionScanner = new Scanner(dimensions);

            Monkey starterMonkey = new Monkey();
            starterMonkey.energy = startingEnergy;
            int[] startPosition = new int[2];

            System.out.println("Dimensions = "+dimensions);

            for(int i = 0; i<dimensionScanner.nextInt(); i++){
                while(!input.hasNextLine()){

                }

                String row = input.nextLine();
                Scanner r = new Scanner(row);
                int j = 0;
                while(r.hasNextInt()){
                    switch(r.nextInt()){
                        case -1:
                            startPosition =new int[]{i, j};
                            break;
                        case 0:
                            break;
                        case 1:
                            Banana b = new Banana(i, j);
                            break;
                    }
                }
            }

            for(Banana b:Banana.all){
                if(Math.abs(b.x-startPosition[0])+Math.abs(b.y-startPosition[1])<=starterMonkey.energy){
                    Monkey m = new Monkey(starterMonkey);
                    m.energy-=(Math.abs(b.x-startPosition[0])+Math.abs(b.y-startPosition[1]));
                    m.visit(b);
                }
            }

            while(Monkey.all.size()>0){

            }

            //System.out.println(Monkey.highest);
        }
    }

    public static class Banana{
        public static HashSet<Banana> all = new HashSet<Banana>();
        public HashSet<BananaEdge> connections = new HashSet<BananaEdge>();
        public int x;
        public int y;

        public static int energy;

        public Banana(int x, int y){
            this.x = x;
            this.y = y;
            for(Banana b:all){
                new BananaEdge(this, b);//new edge will add itself to both Banana objects
            }
        }
    }

    public static class BananaEdge{
        public Integer weight;
        public Banana[] bananas = new Banana[2];

        public BananaEdge(Banana b1, Banana b2){
            b1.connections.add(this);
            b2.connections.add(this);

            bananas[0] = b1;
            bananas[1] = b2;

            weight = Math.abs(b1.x-b2.x)+Math.abs(b1.y-b2.y);
        }

        public Banana getOpposite(Banana b){
            for(Banana i:bananas){
                if(i!=b){
                    return i;
                }
            }
            return null;
        }
    }

    public static class Monkey{
        public HashSet<Banana> visited = new HashSet<Banana>();
        public Integer energy = 0;

        public static Integer energyPerStep = 0;

        public static int highest = 0;
        public static HashSet<Monkey> all = new HashSet<Monkey>();

        public Monkey(Monkey m){
            for(Banana b:m.visited){
                visited.add(b);
            }
            energy = m.energy;
            all.add(this);
        }

        public Monkey(){

        }

        public void visit(Banana b){
            energy += Banana.energy;
            int counter = 0;
            for(BananaEdge e:b.connections){
                if(e.weight<=energy&&!visited.contains(e.getOpposite(b))){
                    counter++;
                    Monkey m = new Monkey(this);
                    m.energy-=energyPerStep;
                    m.visit(e.getOpposite(b));
                }
            }
            if(counter==0){
                if(visited.size()>highest){
                    highest = visited.size();
                    all.remove(this);
                }
            }
        }
    }
}
