package qiang.list;

public class ReorderList143 {
	  
	
	public void reorderList(ListNode head) {
	        
		if(head == null) return;
		if(head.next == null || head.next.next==null) return;
		ListNode center =reverseList( getCenter(head));
		ListNode guardNode = new ListNode(-1);
		while(center != null && head !=null){
			guardNode.next = head;
			head = head.next;
			guardNode.next.next = center;
			center = center.next;
			guardNode = guardNode.next.next;
		}
		if(center !=null){
			guardNode.next = center;
		}
		if(head!=null){
			guardNode.next = head;
		}
	}
	
	// 找到链表中心。
	public ListNode getCenter(ListNode head){
		
		ListNode first,second,beforeFirst;
		beforeFirst = second = first = head;
		
		while(second != null && second.next != null){
			second = second.next.next;
			beforeFirst = first;
			first = first.next;
		}
		beforeFirst .next = null;
		return first;	
	}
	
	// reverse a list
	public ListNode reverseList(ListNode head){
		
		ListNode newHead = null,cur;
		while(head !=null){
			cur = head.next;
			head.next = newHead;
			newHead = head;
			head = cur;
		}
		return newHead;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []nums = {1,2,3,4,5};
		ListNode  head = ListNode.getListByNums(nums);
		new ReorderList143().reorderList(head);
		ListNode.printList(head);
	}

}
