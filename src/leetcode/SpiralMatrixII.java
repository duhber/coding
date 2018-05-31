package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixII {
	
	public static void main(String[] args){
		
		int matrix [][] = {{1,2,3,4},
		{12,13,14,5},
		{11,16,15,6},
		{10,9,8,7}};
		
		int n=matrix.length;
		
		int c0=0;
		int cn=n-1;
		int r0=0;
		int rn = n-1;
		
		int size=n;
		
		List<Integer> result = new ArrayList<>();
		while(size>0){
			//System.out.println(c0+" "+cn);
			for(int i=c0;i<=cn;i++){
				result.add(matrix[r0][i]);
			}
			
			for(int i=r0+1;i<rn;i++){
				result.add(matrix[i][cn]);
			}
			
			for(int i=cn;i>c0;i--){
				result.add(matrix[rn][i]);
				
			}
			for(int i=rn;i>r0;i--){
				result.add(matrix[i][c0]);
			}
			c0=c0+1;
			r0=r0+1;
			rn=rn-1;
			cn=cn-1;
			size=size-2;
		}
		
		for(int i=0;i<result.size();i++){
				System.out.println(result.get(i));
		}
	}

}
