package leetcode;

public class Ezetap {
	
	public static void main(String[] args){
		
		
		int num [] = {3,5,3,5,5,11,5};
		
		int i=0;
		int j=num.length-1;
		int X=5;
		
		while(i<j){
			while(num[j]!=X){
				j--;
			}
			
			if(num[i]!=X){
				num[j]=num[i];
			}
			num[i]=1;
			i++;
		}
		
		
		for(i=0;i<num.length;i++){
			System.out.println(num[i]);
		}
		
	}

}
