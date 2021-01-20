import java.util.Scanner;
import java.io.*;
class Minesweeper{
   int[][] mines;
   int[][] tiles;
   int numMines;
   
   
   public Minesweeper(int size){
      mines = new int[size][size];
      tiles = new int[size][size];
      }//Minesweeper constructor
   
   
   
   public void fillMines(int num){
      int numx;
      int numy;
      numMines = num;
      int size = mines.length;
      for(int i = 0; i < num; i++){
         numx = (int)Math.round(Math.random()* (size-1));
         numy = (int)Math.round(Math.random()* (size-1));
         
         if(mines[numx][numy]==9){
            i--;
         }//if
         else{
            
            mines[numx][numy] = 9;
         }//else
         
         }//for i
      
      }//fillMines
   
   public void calculateClues(){
      for(int y = 0; y < mines.length; y ++){
            for(int x = 0; x < mines[0].length; x ++){
               if(mines[y][x] != 9){
                  for(int i = (y-1); i <= (y+1); i++){
                     for(int j = (x-1); j <= (x+1); j++){
                        if((i < mines.length && j < mines.length) && (i >= 0 && j >=0)){
                           if(mines[i][j] == 9){
                              mines[y][x]++;
                              }//if   
                           }//if
                        }//for j
                     }//for i
                  }//if 
               }//for x                
            }//for y
   }//calculateClues
   
   public void markTile(int y, int x, int status){
      if(status==2 && tiles[y][x]==2){
         tiles[y][x] = 0;
      }
      else{
      tiles[y][x] = status;
      }
      
   }//markTile
   
   public int getTileStatus(int y, int x){
      return tiles[y][x];
   }//getTileStatus
   
   public void displayBoard(){
      System.out.print("  ");
      for(int i = 0; i < mines.length; i++){
         System.out.print(" " + (i+1) + " ");
      }//for i
      System.out.println();
      for(int y = 0; y < tiles.length; y++){
         System.out.print(y + 1 + " ");
         for(int x = 0; x < tiles.length; x++){
            if(tiles[y][x] == 0){
               System.out.print("[ ]");
            }//if
            else 
               if(tiles[y][x] == 2 ){
                  System.out.print("[" + "#" + "]");
                  }//if
                  else{
                     System.out.print("[" + mines[y][x] + "]");
                     }//else
            }//for x
         System.out.println();
      }//for y
   }//displayBoard
   
   public boolean gameWon(){
      boolean gameWon = false;
      boolean openMine = false;
      int count = 0;
      for(int y = 0; y < mines.length; y ++){
         for(int x = 0; x < mines[0].length; x++){
            if(tiles[y][x] == 1){
               count+=1;
            }//if
            if((mines[y][x] == 9) && (tiles[y][x] == 1)){
               openMine = true;
               System.out.println("You've opened a mine. You lose");
               for(int i = 0; i< mines.length; i++){
                  for(int j = 0; j < mines.length; j++){
                     tiles[i][j] = 1;
                  }//for j
               }//for i
               displayBoard();
               System.exit(0);
            }//if       
         }//for x         
      }//for y
      if(count == ((mines.length*mines.length) - numMines)){
         gameWon = true;
      }//if
      if(openMine == true){
         gameWon = false;
      }//if
      return gameWon;     
   
   }//gameWon
   


}//Minesweeper
   