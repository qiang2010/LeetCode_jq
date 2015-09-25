package qiang.list;

public class InsertionSortList147 {

	
	
	
	   
	public ListNode insertionSortList(ListNode head) {
	        
		if(head == null || head.next ==null) return head; 
	
		// 哨兵节点
		ListNode newHead = new ListNode(Integer.MIN_VALUE);
		ListNode cur,tempHead,last;
		
		while(head != null){
			cur = head.next;
			head.next =null;
			tempHead = newHead;
			
			last = tempHead;
			
			while(tempHead != null && tempHead.val < head.val ){
				last = tempHead;
				tempHead = tempHead.next;
			}
			if(tempHead == null){
				last.next = head;
			}else{
				tempHead = last.next;
				last.next = head;
				head.next = tempHead;
			}
			head = cur;
		}
		return newHead.next;
	}	
	
	
	public static void main(String[] args) {

		int []nums = {5,5};
		ListNode head = ListNode.getListByNums(nums);
		ListNode.printList(new InsertionSortList147().insertionSortList(head));
		
		
		
	}

}
