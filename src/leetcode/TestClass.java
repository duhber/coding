package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//["LRUCache","put","put","get","get","put","get","get","get"]
		//[[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]


		List<String> listA = new ArrayList<String>();
		listA.add("A1");

		List<String> listB = new ArrayList<String>();
		listB.add("B1");
		listB.add("B2");
		
		List<String> listC = new ArrayList<String>();
		listB.add("C1");
		listB.add("C2");
		listA.addAll(listB);
		listA.addAll(listC);

		List<String> listFinal = new ArrayList<String>();
		listFinal.addAll(listA);
		listFinal.addAll(listB);

		//same result
		//List<String> listFinal = new ArrayList<String>(listA);
		//listFinal.addAll(listB);

		System.out.println("listA : " + listA);
		System.out.println("listB : " + listB);
		System.out.println("listFinal : " + listFinal);
	}

}
