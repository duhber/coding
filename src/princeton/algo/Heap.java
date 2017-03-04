package princeton.algo;

public interface Heap {
	void sink(int k);
	void swim(int k);
	boolean insert(int key);
	int deleteTop();
}
