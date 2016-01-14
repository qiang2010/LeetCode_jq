package qiang.list;


public class SortList148 {

	public static void main(String[] args) {
		
		int []nums = {2,4,1};
		ListNode head = ListNode.getListByNums(nums);
		ListNode newHead = new SortList148().sortList(head);
		ListNode.printList(newHead);
	}
	
	
	public ListNode sortList(ListNode head) {
	
		if(head == null || head.next == null) return head;
		ListNode slow,fast;
		
		int len = 0;
		ListNode tempHead = head;
		while(tempHead != null){
			len++;
			tempHead = tempHead.next;
		}
		ListNode ans = new ListNode(-1);
		ans.next = head;
		slow = fast = head;
		ListNode pre = ans;
		for(int i = 1; i < len+1;i*=2 ){
			
			pre = ans;
			fast = pre.next;// 都是头部
			slow = pre.next;
				
			while(fast != null || slow !=null){
				
				int fv = 0;
				int sv = 0 ;
				while(fv < i && fast!=null){
					fv++;
					fast = fast.next;
				}
				
				fv = sv = 0;
				
				while(fv<i && sv < i && fast!=null && slow != null){
					if(fast.val < slow.val){
						pre.next = fast;
						pre = fast;
						fast = fast.next;
						fv++;
					}else{
						
						pre.next = slow;
						pre = slow;
						slow = slow.next;
						sv++;
					}
					
				}
				while(fv<i && fast!= null){
					pre.next = fast;
					pre = fast;
					fast = fast.next;
					fv++;
				}
				while(sv < i && slow != null){
					pre.next = slow;
					pre = slow;
					slow = slow.next;
					sv++;
				}
				pre.next = fast;
				slow = fast;
			}
			
		}
		
		
		return ans.next;
		
	}	
 
}
