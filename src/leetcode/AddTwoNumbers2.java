package leetcode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers2 {
	public static void main(String[]args){
		int []a1={6,1,9};
		int []a2={0};
		
		ListNode node = null;
		ListNode listNode1 = null;
		ListNode listNode2 = null;
		
		for(int i=0;i<a1.length;i++){
			System.out.println(a1[i]);
			node = new ListNode(a1[i]);
			node.next = listNode1;
			listNode1 = node;
		}
		printListNode(listNode1);
		for(int i=0;i<a2.length;i++){
			System.out.println(a2[i]);
			node = new ListNode(a2[i]);
			node.next = listNode2;
			listNode2 = node;
		}
		printListNode(listNode2);
		ListNode result = addTwoNumbers(listNode1, listNode2);
		printListNode(result);
	}
	
	public static void printListNode(ListNode node){
		while(node!=null){
			System.out.print(node.val+"  ");
			node=node.next;
		}
		System.out.println();
	}


    private static ListNode reverse(ListNode node){
    	ListNode start = null;
        if(node.next!=null){
            ListNode tail = node.next;
            start=reverse(tail);
            tail.next=node;
            node.next=null;
            
        }
        else{
        	System.out.println("   val "+node.val);
            start=node;
        }
        return start;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode startNode1 = null;
        ListNode startNode2 = null;
        int inHand = 0;
        ListNode result = null;
        ListNode node = null;
        
        startNode1=reverse(l1);
        printListNode(l1);
        printListNode(startNode1);
        System.out.println("start node "+startNode1.val);
        startNode2=reverse(l2);
        while(startNode1!=null && startNode2!=null){
            
            int val = (startNode1.val + startNode2.val +  inHand)%10;
            inHand = (startNode1.val + startNode2.val+inHand)/10;
            
            node = new ListNode(val);
            node.next = result;
            result = node;
            System.out.println(val);
            startNode1 = startNode1.next;
            startNode2 = startNode2.next;
            
        }
        
        while(startNode1!=null){
        	System.out.println(startNode1.val);
            int val = (startNode1.val + inHand)%10;
            inHand = (startNode1.val +inHand)/10;
            node = new ListNode(val);
            node.next = result;
            result = node;
            startNode1=startNode1.next;
        }
        
        while(startNode2!=null){
            int val = (startNode2.val + inHand)%10;
            inHand = (startNode2.val +inHand)/10;
            node = new ListNode(val);
            node.next = result;
            result = node;
            startNode2=startNode2.next;
        }
        if(inHand!=0){
            node = new ListNode(inHand);
            node.next = result;
            result = node;
        }
        
        return result;
        
        
    }
}
