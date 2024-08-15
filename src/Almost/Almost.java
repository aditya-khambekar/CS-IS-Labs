package Almost;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Almost {
    public static void main(String[]Args) throws FileNotFoundException{
        File file = new File("almost.dat");
        Scanner kb = new Scanner(file);
        //Scanner kb = new Scanner(System.in);
        int numGames = Integer.parseInt(kb.nextLine());
        for(int i = 0; i<numGames; i++){
            gameBoard g = new gameBoard(kb.nextLine(), kb.nextLine(), kb.nextLine());
            System.out.println(g.findWinner());
        }        
    }

    public static class gameBoard{
        private gameTile[][] board = new gameTile[3][3];

        public gameBoard(String row1, String row2, String row3){
            String s = row1;
            int i = 0;
            board[i][0]= new gameTile(s.substring(0, 1), i, 0, board);
            board[i][1]= new gameTile(s.substring(1, 2), i, 1, board);
            board[i][2]= new gameTile(s.substring(2), i, 2, board);

            s = row2;
            i = 1;
            board[i][0]= new gameTile(s.substring(0, 1), i, 0, board);
            board[i][1]= new gameTile(s.substring(1, 2), i, 1, board);
            board[i][2]= new gameTile(s.substring(2), i, 2, board);

            s = row3;
            i = 2;
            board[i][0]= new gameTile(s.substring(0, 1), i, 0, board);
            board[i][1]= new gameTile(s.substring(1, 2), i, 1, board);
            board[i][2]= new gameTile(s.substring(2), i, 2, board);
        }

        public String findWinner(){
            HashSet<gameTile> empties = new HashSet<gameTile>();
            for(gameTile t: gameTile.all){
                if(t.s.equals(" ")){
                    empties.add(t);
                }
            }

            for(gameTile t:empties){
                t.s = "X";
                if(t.partOfWinner()){
                    return (t.r+1)+" "+(t.c+1);
                }
                t.s = " ";
            }
            return null;
        }

        public static class gameTile{
            public static HashSet<gameTile> all = new HashSet<gameTile>();

            public String s;
            public int r;
            public int c;
            public gameTile[][] board;

            public gameTile(String s, int r, int c, gameTile[][] board){
                this.s = s;
                this.r = r;
                this.c = c;
                this.board = board;
                all.add(this);
            }

            

            public void safeAdd(ArrayList<gameTile> row, int r, int c){
                if(r<0||c<0){

                }else{
                    try {
                        row.add(board[r][c]);
                    } catch (Exception e) {
                        //System.out.println("could not add "+ r + " "+ c);
                    }
                }
            }

            public boolean partOfWinner(){
                ArrayList<gameTile> verticalRow = new ArrayList<gameTile>();
                    verticalRow.add(board[0][c]);
                    verticalRow.add(board[1][c]);
                    verticalRow.add(board[2][c]);
                ArrayList<gameTile> horizontalRow = new ArrayList<gameTile>();
                    horizontalRow.add(board[r][0]);
                    horizontalRow.add(board[r][1]);
                    horizontalRow.add(board[r][2]);
                ArrayList<gameTile> diagonalPosRow = new ArrayList<gameTile>();
                    safeAdd(diagonalPosRow, r+2, c+2);
                    safeAdd(diagonalPosRow, r+1, c+1);
                    safeAdd(diagonalPosRow, r, c);
                    safeAdd(diagonalPosRow, r-1, c-1);
                    safeAdd(diagonalPosRow, r-2, c-2);
                ArrayList<gameTile> diagonalNegRow = new ArrayList<gameTile>();
                    safeAdd(diagonalNegRow, r+2, c-2);
                    safeAdd(diagonalNegRow, r+1, c-1);
                    safeAdd(diagonalNegRow, r, c);
                    safeAdd(diagonalNegRow, r-1, c+1);
                    safeAdd(diagonalNegRow, r-2, c+2);

                return checkList(verticalRow, "v")||checkList(horizontalRow, "h")||checkList(diagonalPosRow, "dP")||checkList(diagonalNegRow, "dN");
            }

            public boolean checkList(ArrayList<gameTile> list, String s){
                if(list.size()!=3){
                    return false;
                }
                for(gameTile g:list){
                    if(!g.s.equals("X")){
                        return false;
                    }
                }

                //System.out.println("_______ \n"+s);
                for(gameTile[] r: board){
                    for(gameTile g:r){
                        //System.out.print(g.s);
                    }
                    //System.out.println();
                }
                return true;
            }
        }
    }
}
