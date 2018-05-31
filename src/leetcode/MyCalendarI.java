package leetcode;

import java.util.Comparator;
import java.util.TreeSet;

public class MyCalendarI {
	public static void main(String[] args) {
		MyCalendar calendar = new MyCalendar();
		System.out.println(calendar.book(47, 50));
		System.out.println(calendar.book(33, 41));
		System.out.println(calendar.book(39, 45));
	}
}


class MyCalendar {
	
	private TreeSet<int[]> bookings ;
    public MyCalendar() {
        this.bookings = new TreeSet<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}
		});
    }
    
    public boolean book(int start, int end) {
    	
    	int[] newBooking = {start, end};
    	int[] floor = bookings.floor(newBooking);
    	int [] ceiling = bookings.ceiling(newBooking);
    	if(floor !=null && start<floor[1]){
    		System.out.println("floor "+floor[1]);
    		return false;
    	}
    	if(ceiling !=null && end>ceiling[0]){
    		System.out.println("ceiling "+ceiling[0]);
    		return false;
    	}
    	
    	bookings.add(newBooking);
    	return true;
    }
}