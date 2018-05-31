package leetcode;

public class ArrayNesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,4,0,3,1,6,2};
		int visited[] = new int[arr.length];
		
		int result = 0;
		
		for(int i=0;i<arr.length;i++){
			
			if(visited[i]==0){
				int currentMax = 1;
				visited[i]=1;
				int start = arr[i];
				int j = arr[i];
				//System.out.println(" start : "+start+" value : "+arr[j]);
				while(arr[j]!=start){
					//System.out.println(" start : "+start+" value : "+arr[j]);
					currentMax++;
					j=arr[j];
					visited[j]=1;
				}
				
				if(currentMax>result){
					result = currentMax;
				}
			}
		}
		System.out.println(result);
		
	}

}
