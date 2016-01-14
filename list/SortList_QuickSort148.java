package qiang.list;


public class SortList_QuickSort148 {

	public static void main(String[] args) {
		
		int []nums = {2,4,1};
		ListNode head = ListNode.getListByNums(nums);
		ListNode.printList(head);
		ListNode newHead = new SortList_QuickSort148().sortList(head);
		ListNode.printList(newHead);
	}
	
	
	public ListNode sortList(ListNode head) {
	
		if(head == null || head.next == null) return head;
		return sortListQuickSort(head, null);
	}	
 
	/**
	 * 
	 * end 是head到哪里结尾。
	 * 
	 * @param head
	 * @param end
	 * @return
	 */
	public ListNode sortListQuickSort(ListNode head,ListNode end){
		
		if(head == null || head == end||head.next==end){
			return head;
		}
		
		ListNode left = new ListNode(-1);
		ListNode mid = new ListNode(-1);
		ListNode right = new ListNode(-1);
		ListNode l = left,r = right,m = mid;
		int target = head.val;
		while(head != end){
			if(head.val == target){
				m.next = head;
				m = m.next;
			}else{
				if(head.val<target){
					l.next = head;
					l = l.next;
				}else{
					r.next = head;
					r = r.next;
				}
			}
			head = head.next;
		}
		
		// 右侧的结尾标志还是end
		r.next = end;//  忘了这一句了，因为不知道最后的节点是哪个，所以要接上。
		right = sortListQuickSort(right.next, end);
		m.next = right;
		l.next = mid.next;// 注意哨兵节点。
		return sortListQuickSort(left.next, l.next);
	}
	
}
