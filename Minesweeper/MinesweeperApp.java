import java.util.Scanner;
import java.io.*;
class MinesweeperApp{
   public static void main(String args[]) {
      Scanner input = new Scanner(System.in);
      int size = 2;
      int count = 1;
      boolean check = true;
      int status;
      int x;
      int y;
      String rules = "In the game Minesweeper a player is presented with a two dimensional grid of cells (a minefield) that has a number of mines (bombs) hidden randomly throughout the grid\n. Each of the cells is initially covered by a tile\n. The player must open each tile that does not cover a mine\n. A player wins by opening all of the non-mine tiles\n. A player loses when they open any tile containing a mine\n. The player may open a tile or flag a tile as a mine location\n. When a player opens a tile (that does not contain a mine), a clue is displayed that tells the player the number of neighboring cells adjacent to it that contain mines.";
      System.out.println(rules);
      System.out.println();
      Minesweeper mine = new Minesweeper(size+count);
      mine.fillMines(((count*count) + (4*count))-1);
      mine.calculateClues();
      while(check){
         boolean con = false;
         
         mine.displayBoard();
         boolean valid = false;
         
         System.out.println("enter a row");
         y = (input.nextInt()-1);
         System.out.println("enter a column");
         x = (input.nextInt()-1);
         System.out.println("mark tile Status");
         System.out.println("1 - open");
         System.out.println("2 - flag/unflag");
         status = input.nextInt();
         
         
         mine.markTile(y,x,status);
         mine.gameWon();
         while(mine.gameWon() && !con){
            System.out.println("Congrats, you've won");
            System.out.println("Would you like to play again with an increase in difficulty? Enter yes or no");       
            String reply = input.next();
            if(reply.equals("yes")){
               count++;
               mine.fillMines(((count*count) + (4*count))-1);
               mine.calculateClues();
               con = true;
            }//if
            else{
               if(reply.equals("no")){
               check = false;
               }//if
               else{
                  System.out.println("Invalid input");           
               }//else
            }//else
            }//while
         
         }//while
         
   }//main
}//MinesweeperApp 