package leetcode;

public class SpiralMatrix {
	
	public static void main(String [] args){
		
		int n=4;
		int matrix [][] = new int[n][n];
		
		int c0=0;
		int cn=n-1;
		int r0=0;
		int rn = n-1;
		
		int size=n;
		int entry=1;
		while(size>0){
			//System.out.println(c0+" "+cn);
			for(int i=c0;i<=cn;i++){
				matrix[r0][i] = entry;
				entry++;
			}
			
			for(int i=r0+1;i<rn;i++){
				matrix[i][cn]=entry;
				entry++;
			}
			
			for(int i=cn;i>c0;i--){
				matrix[rn][i]=entry;
				entry++;
				
			}
			for(int i=rn;i>r0;i--){
				matrix[i][c0]=entry;
				entry++;
			}
			c0=c0+1;
			r0=r0+1;
			rn=rn-1;
			cn=cn-1;
			size=size-2;
		}
		
		for(int i=0;i<n;i++){
			System.out.print("{");
			for(int j=0;j<n;j++){
				System.out.print(matrix[i][j]+",");
				
			}
			System.out.println("}");
		}
	}
}
