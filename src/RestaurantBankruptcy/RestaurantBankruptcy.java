package RestaurantBankruptcy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class RestaurantBankruptcy {
    public static void main(String[]args) throws FileNotFoundException{
        Scanner input = new Scanner(new File("RestaurantBankrupcy/Judges Input.txt"));
        int numProblems = Integer.parseInt(input.nextLine());
        for(int i = 0; i<numProblems; i++){
            System.out.println(solve(Integer.parseInt(input.nextLine())));
        }
    }

    public static int solve(int budget){
        int totalCount = 1;
        int dayCount = 1;

        int originalBudget = budget;

        while(budget>=originalBudget*0.5){
            budget -= 1000;
            budget += getCustomers(1, dayCount)*10;
            dayCount++;
            totalCount++;
        }

        dayCount = 1;

        while(budget>=originalBudget*0.25){
            budget -= 500;
            budget += getCustomers(2, dayCount)*10;
            dayCount++;
            totalCount++;
        }

        dayCount = 1;

        while(budget>0){
            budget -= 200;
            if(getCustomers(3, dayCount)>=20){
                return -1;
            }else{
                budget += getCustomers(3, dayCount)*10;
            }
            dayCount++;
            totalCount++;
        }

        return totalCount;
    }

    public static int getCustomers(Integer tier, Integer dayCount){
        switch(tier){
            case 1:
                return 70+2*(dayCount-1);
            case 2:
                return 32+2*(dayCount-1);
            case 3:
                return 15+2*(dayCount-1);
            default:
                return 0;
        }
    }
}
