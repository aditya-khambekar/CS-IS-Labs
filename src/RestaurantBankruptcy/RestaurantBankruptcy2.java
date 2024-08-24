package RestaurantBankruptcy;

import java.util.*;

public class RestaurantBankruptcy2 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while (n-->0){
            int days = 0;
            int initial = input.nextInt();
            int current = initial;
            int cost = -300; //the initial cost per day of the billboard (-1000 + (70*10))
            while((double)current >= initial / 2.0){
                current += cost;
                cost += 20; //two more customers than the previous day
                days++;
                if (current <= 0){
                    System.out.println(initial+": "+days);
                    break;
                }
                else if (cost >= 0){ //if the cost starts to become positive then they will never go in debt
                    System.out.println(initial+": "+-1);
                    //if(initial==4760){System.out.println(24);}
                    break;
                }
                
            }
            if (cost < 0 && current > 0){
                cost = -180;
                while ((double)current >= initial / 4.0){
                    current += cost;
                    
                    days++;
                    if (current <=0){
                        System.out.println(initial+": "+days);
                        break;
                    }
                    else if (cost >= 0){
                        System.out.println(initial+": "+-1);
                        //if(initial==4760){System.out.println(39);}
                        break;
                    }
                    cost += 10;
                }
                if (cost < 0 && current > 0){
                    cost = -50;
                    while (current > 0){
                        current += cost;
                        days++;
                    }
                    System.out.println(initial+": "+days);
              }
            }
        }
    }
}