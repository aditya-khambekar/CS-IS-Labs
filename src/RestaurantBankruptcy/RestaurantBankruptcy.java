package RestaurantBankruptcy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class RestaurantBankruptcy {
    public static void main(String[]args) throws FileNotFoundException{
        //Scanner input = new Scanner(new File("src/RestaurantBankruptcy/Judges Input.txt"));
        Scanner input = new Scanner(System.in);
        Integer numProblems = input.nextInt();
        Queue<Integer> q = new LinkedList<Integer>();
        while(numProblems-->0){
            q.add(solve(input.nextInt()));
        }

        while(q.size()>0){
            System.out.println(q.remove());
        }
    }

    public static int solve(Integer budget){
        int totalCount = 0;
        int dayCount = 0;

        int originalBudget = Integer.valueOf(budget);

        while(budget>=(originalBudget+0.0)*0.5){
            dayCount++;
            totalCount++;

            budget -= 1000;
            if(getCustomers(1, dayCount)*10>=1000){
                return -1;
            }else{
                budget += getCustomers(1, dayCount)*10;
            }
            
        } 

        dayCount = 0;

        while(budget>=(originalBudget+0.0)*0.25){
            dayCount++;
            totalCount++;

            budget -= 500;
            if(getCustomers(2, dayCount)*10>=500){
                return -1;
            }else{
                budget += getCustomers(2, dayCount)*10;
            }
            
        }

        dayCount = 0;

        while(budget>0){
            dayCount++;
            totalCount++;

            budget -= 200;
            budget += getCustomers(3, dayCount)*10;
        }

        return totalCount;
    }

    public static int getCustomers(Integer tier, Integer dayCount){
        switch(tier){
            case 1:
                return 70+2*(dayCount-1);
            case 2:
                return 35+1*(dayCount-1);
            case 3:
                return 15;
            default:
                return 0;
        }
    }
}
