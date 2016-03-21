package qiang.list;

public class OddEvenLinkedList328 {

	
	public static void main(String[] args) {
		
		int []nums = {1,2,3,4,5,6};
		ListNode.printList(oddEvenList(ListNode.getListByNums(nums)));
		
	}   
	
	public ListNode oddEvenList2(ListNode head) {
	    if(head!=null){
	        ListNode odd = head;
	        ListNode even = head.next;
	        ListNode p = even;

	        while(odd.next!=null && even.next!=null){
	            odd.next = even.next;
	            odd = odd.next;
	            even.next = odd.next;
	            even = even.next;
	        }
	        odd.next = p;
	    }
	    return head;
	} 
	
	public  static ListNode oddEvenList(ListNode head) {
	     
		if(head == null || head.next ==null)return head;
		
		ListNode oddGuard = new ListNode(-1);
		ListNode evenGuard = new ListNode(-1);
		   
		ListNode tempOddHead = oddGuard;
		ListNode tempEvenHead = evenGuard;
	
		boolean flag = true;
		while(head!=null){
			if(flag){
				oddGuard.next = head;
				oddGuard = head;
			}else{
				evenGuard.next = head;
				evenGuard = head;
			}
			head = head.next;
			flag = !flag;
		}
		evenGuard.next = null;
		oddGuard.next = tempEvenHead.next;
		return tempOddHead.next;
	}
}
