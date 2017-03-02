package princeton.algo;

public class MaxHeap implements Heap{
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

	@Override
	public void sink(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swim(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean insert(int key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteTop() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	
}
