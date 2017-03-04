package leetcode;

import java.util.Hashtable;

public class LRUCache {
	
	private Hashtable<Integer, QueueNode> cacheTable; 
	private Integer size;
	private CacheQueue cacheQueue;
    public LRUCache(int capacity) {
    	this.size=capacity;
        cacheTable = new Hashtable<>(capacity);
        cacheQueue = new CacheQueue();
    }
    
    public int get(int key) {
        int val = -1;
        if(cacheTable.containsKey(key)){
        	QueueNode node = cacheTable.get(key);
        	val = node.val;
        	cacheQueue.moveFront(node);
        }
        
    	return val; 
    }
    private boolean isFull(){
    	return cacheTable.size()==this.size?true:false;
    }
    private void evictLRU(){
    	cacheTable.remove(cacheQueue.last.key);
    	cacheQueue.removeLast();
    }
    
    public void put(int key, int value) {
    	QueueNode node = null;
    	if(cacheTable.containsKey(key)){
    		node = cacheTable.get(key);
    		cacheQueue.removeNode(node);
    	}
    	else if(isFull()){
    		evictLRU();
    	}
    	node = new QueueNode(key, value);
    	cacheQueue.addFront(node);
    	cacheTable.put(key, node);
    }

    public void printCacheItems(){
    	QueueNode node = cacheQueue.front;
    	while(node!=null){
    		System.out.print(node.key +"  ");
    		node=node.next;
    	}
    	System.out.println();
    }
}

class QueueNode{
	int key;
    int val;
    QueueNode next;
    QueueNode prev;
    QueueNode(int key, int val) {
    	
    	this.key = key;
    	this.val = val;
    	this.prev=null;
    	this.next=null;
    }
}

class CacheQueue{
	public QueueNode front;
	public QueueNode last;
	
	public CacheQueue(){
		front = null;
		last = null;
	}
	public void addFront(QueueNode node){
		node.next=front;
		node.prev=null;
		if(front==null){
			last = node;
		}
		else{
			front.prev=node;
		}
		front=node;
	}
	public void removeLast(){
		detach(last);
	}
	public void removeNode(QueueNode node){
		detach(node);
		node=null;
	}
	
	private void detach(QueueNode node){
		QueueNode prevNode = node.prev;
		QueueNode nextNode = node.next;
		if(front==last){
			front = null;
			last = null;
		}
		
		else if(last==node){
			last=prevNode;
		}
		else if(front==node){
			front=nextNode;
		}
		node.prev=null;
		node.next=null;
		if(prevNode!=null){
			prevNode.next=nextNode;
		}
		if(nextNode!=null){
			nextNode.prev=prevNode;
		}
		
	}
	
	public void moveFront(QueueNode node){
		detach(node);
		addFront(node);
	}
	
}