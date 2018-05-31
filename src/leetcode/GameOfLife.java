package leetcode;

public class GameOfLife {
	/*
	 *  According to the Wikipedia's article: "The Game of Life, also known simply as Life,
	 *   is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
Each cell interacts with its eight neighbors (horizontal, vertical, 
diagonal) using the following four rules (taken from the above Wikipedia article):

    Any live cell with fewer than two live neighbors dies, as if caused by under-population.
    Any live cell with two or three live neighbors lives on to the next generation.
    Any live cell with more than three live neighbors dies, as if by over-population..
    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state.

Follow up:

    Could you solve it in-place? Remember that the board needs to be updated at the same time: 
    You cannot update some cells first and then use their updated values to update other cells.
    In this question, we represent the board using a 2D array. In principle, the board is infinite, 
    which would cause problems when the active area encroaches the border of the array. 
    How would you address these problems?

	 * 
	 * 
	 */
	public static void main(String[] args){
		int [][] board = {{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}};
		
		for(int i=0;i<board.length;i++){
			int m = board[i].length;
			
			System.out.println();
			for(int j=0;j<m;j++){
				
				int liveNeighbour = 0;
				
				
				if(i-1>=0){
					liveNeighbour+=(board[i-1][j]&1);
					if(j-1>=0){
						liveNeighbour+=(board[i-1][j-1]&1);
					}
					if(j+1<m){
						liveNeighbour+=(board[i-1][j+1]&1);
					}
				}
				if(j-1>=0){
					liveNeighbour+=(board[i][j-1]&1);
				}
				if(j+1<m){
					liveNeighbour+=(board[i][j+1]&1);
				}
				
				if(i+1<board.length){
					liveNeighbour+=(board[i+1][j]&1);
					if(j-1>=0){
						liveNeighbour+=(board[i+1][j-1]&1);
					}
					if(j+1<m){
						liveNeighbour+=(board[i+1][j+1]&1);
					}
				}

				System.out.print(" "+String.format("(%d,%d)", i,j)+"-"+liveNeighbour);
				
				if((board[i][j]&1)==0 && liveNeighbour==3){
					board[i][j] = 2;
				}else if((board[i][j]&1)==1 && (liveNeighbour<2 || liveNeighbour>3)){
					board[i][j] = 1;
				}else if((board[i][j]&1)==1 && (liveNeighbour>=2 && liveNeighbour<=3)){
					board[i][j] = 3;
				}
				
				
				
				//board[i][j] = liveNeighbour;
			}
			
		}
		
		
		for(int i=0;i<board.length;i++){
			int m = board[i].length;
			System.out.println();
			for(int j=0;j<m;j++){
				System.out.print(" "+(board[i][j]));
				board[i][j]=board[i][j]>>1;
			}
		}
		
		
	}

}
