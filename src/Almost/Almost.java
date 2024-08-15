package Almost;

import java.util.Scanner;

public class Almost {
    public static void main(String[]Args){
        Scanner kb = new Scanner(System.in);
        int numGames = Integer.parseInt(kb.nextLine());
        for(int i = 0; i<numGames; i++){

        }        
    }

    public static class gameBoard{
        private String[][] board = new String[3][3];

        public gameBoard(String row1, String row2, String row3){
            String s = row1;
            int i = 0;
            board[i][0]= s.substring(0, 1);
            board[i][1]= s.substring(1, 2);
            board[i][2]= s.substring(2);

            s = row2;
            i = 1;
            board[i][0]= s.substring(0, 1);
            board[i][1]= s.substring(1, 2);
            board[i][2]= s.substring(2);

            s = row3;
            i = 2;
            board[i][0]= s.substring(0, 1);
            board[i][1]= s.substring(1, 2);
            board[i][2]= s.substring(2);
        }

        public int[] findAnswer(){
            //horizontal rows
            
        }

        public int[] findByRow(int r, int c, int dR, int dC){
            ArrayList<String> 
        }

        /*public String get(int r, int c, int dir){
            try {
                switch(dir){
                    case 1:
                        return board[r-1][c];
                    case 2:
                        return board[r][c+1];
                    case 3:
                        return board[r+1][c];
                    case 4:
                        return board[r][c-1];
                    case 5:
                        return board[r-1][c+1];
                    case 6:
                        return board[r+1][c+1];
                    case 7:
                        return board[r+1][c-1];
                    case 8:
                        return board[r-1][c-1];
                    default:
                        return board[r][c];
                }
            } catch (Exception e) {
                return null;
            }
        }

        public int[] getRandomCoord(){
            return new int[] {(int)(Math.random()*3), (int)(Math.random()*3)};
        }

        public int[] findAnswer(){
            Boolean found = false;
            while(!found){
                int[] random = getRandomCoord();
                
            }
        }

        public void getRow(int[] coord){

        }*/

        

        


    }
}
