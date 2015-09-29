package qiang.list;

public class LinkedListCycle141 {
   
	
	public boolean hasCycle(ListNode head) {
    
		if(head == null){
			return false;
		}
		ListNode first = head,second = head;
		while(second!=null && second.next!=null){
			second = second.next.next;
			first = first.next;
			if(second == first ){
				return true;
			}
		}
		return false;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
