package ContestProblem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class nineteeneightyfour {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("src/ContestProblem2/input.dat"));
        Integer numProblems = Integer.parseInt(input.nextLine());
        for(int i = 0; i<numProblems; i++){
            String replaceWord = input.next();
            String newWord = input.next();
            input.nextLine();
            String str = input.nextLine();

            
            System.out.println(replace(str, replaceWord, newWord));
        }
    }

    public static String replace(String str, String replaceWord, String newWord){
        
        String notAllowed = "abcdefghijklmnopqrstuvwxyz";
        notAllowed+=notAllowed.toUpperCase();
        int rLen = replaceWord.length();
        int i = 0;
        
        while(i<=str.length()-rLen){
            if((str.substring(i, i+rLen).toUpperCase()).equals(replaceWord.toUpperCase())){
                
                if((i!=0&&notAllowed.contains(str.substring(i-1, i)))||(i+rLen<str.length()&&notAllowed.contains(str.substring(i+rLen, i+rLen+1)))){

                }else{
                    str = str.substring(0, i)+newWord+str.substring(i+rLen);
                }
            }
            i++;
        }

        return str;
    }
}
