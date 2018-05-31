package leetcode;

public class RotateImage {
	
	/*
	 * 
	 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]


	 * 
	 */
	public static void main(String[] args){
		
		int [][] matrix = {{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
		
		
		int size = matrix[0].length;
		int row = 0;
		int col = 0;
		int limit = size-1;
		int n=size;
		
		for(int i=0;i<n;i++){
			System.out.println();
			for(int j=0;j<n;j++){
				System.out.print(" "+matrix[i][j]);
			}
		}
		
		System.out.println();
		while(size>1){
			int i = row;
			for(int j=col;j<limit;j++){
				
				int count =0;
				int oi = i;
				int oj = j;
				
				int temp =matrix[oi][oj];
				
				int ni = 0;
				int nj = 0;
				int swapItem = temp;
				while(count<4){
					
					ni = oj;
					nj = n-(oi+1);
					
					System.out.println(String.format("(%d, %d) -> (%d, %d)", oi, oj, ni,nj));
					
					swapItem = matrix[ni][nj];
					matrix[ni][nj] = temp;
					temp = swapItem;
					
					oi = ni;
					oj = nj;
					count++;
				}
			}
			col++;
			row++;
			limit--;
			size=size-2;
		}
		
		for(int i=0;i<n;i++){
			System.out.println();
			for(int j=0;j<n;j++){
				System.out.print(" "+matrix[i][j]);
			}
		}
		
	}
}
