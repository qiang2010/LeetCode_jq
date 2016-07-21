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
	
	
	/**
	 * 充分利用这个是链表的例子
	 * @param head
	 * @return
	 */
	public ListNode insertionSortList2(ListNode head) {
		
		if(head == null || head.next ==null ) return head;
		ListNode sortedHead = head;
		ListNode sortedTail = head;
		head = head.next;
		sortedTail.next = null;
		while(head != null){
			ListNode cur  = head;
			head  = head.next ;
			cur.next = null;
			if(cur.val <= sortedHead.val){
				cur.next = sortedHead;
				sortedHead = cur;
			}else{
				if(cur.val >= sortedTail.val){
					sortedTail.next = cur;
					sortedTail = cur;
				}else{
					ListNode th = sortedHead;
					while(th.next !=null && th.next.val < cur.val)th = th.next;
					cur.next = th.next;
					th.next = cur;
				}
			}
		}
		return sortedHead;
		
		
	}
	
	public static void main(String[] args) {

		int []nums = {5,5};
		ListNode head = ListNode.getListByNums(nums);
		ListNode.printList(new InsertionSortList147().insertionSortList2(head));
	}

}
