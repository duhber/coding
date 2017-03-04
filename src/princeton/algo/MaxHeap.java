package princeton.algo;

public class MaxHeap {
	private int [] data;
	private int N;
	MaxHeap(){
		N=0;
		data = new int[100];
	}
	
	private int less(int i, int j){
		return data[i]<data[j]?i:j;
	}

	private void exchange(int i, int j){
		int temp = data[i];
		data[i]=data[j];
		data[j]=temp;
	}
}
