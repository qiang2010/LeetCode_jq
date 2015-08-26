package qiang.list;

public class RotateList61 {

	
	/**
	 * 注意有一个情况要考虑，当k大于链表的长度的时候，实际需要反转的是 k%len
	 * 
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
    public ListNode rotateRight(ListNode head, int k) {
        
    	if(head == null ) return null;
    	if(k ==0) return head;
    	ListNode first = head,second = head;
    	
    	int len =0;
    	int fk = k;
    	while( k >0 && first != null){
    		first = first.next;
    		k--;
    		len++;
    	}
    	//
    	// 如果first为null，说明len < k 
    	if(first == null ){
    		
    		if(len ==1) return head;
    		fk = fk % len;
    		if(fk ==0) return head;
    		if(fk == len) return head;
    		first = head;
    		k = fk;
    		while( k >0 && first != null){
    			first = first.next;
    			k--;
    		}
    	}
    	
     	
    	// 一起走完剩下的路
    	ListNode lastSec = second,lastFirst= first;
    	
    	while(second!=null && first !=null){
    		lastSec = second;
    		lastFirst = first;
    		second= second.next;
    		first = first.next;
    	}
    	lastSec.next = null;
    	lastFirst.next = head;
    	return second;
    }	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateList61 rl = new RotateList61();
		int []nums={1,2,3,4,5};
		ListNode head = ListNode.getListByNums(nums);
		ListNode.printList(head);
		System.out.println();
		ListNode.printList(rl.rotateRight(head, 10));
	}

}
