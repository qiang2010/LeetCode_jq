package qiang.list;

public class SwapNodesInPairs24 {

	
	
    public static  ListNode swapPairs(ListNode head) {
    
    	if(head == null || head.next== null) return head;
    	// 拿出两个节点
    	
    	ListNode newHead,done;
    	ListNode first = head;
    	ListNode second = head.next;
    	ListNode undone = second.next;
    	second.next = first;
    	first.next = undone;
    	newHead = second;
    	done = first;
    	while(undone !=null && undone.next != null){
    		first = undone;
    		second = undone.next;
    		undone = second.next;
    		done.next = second;
    		second.next = first;
    		first.next = undone;
    		done = first;
    	}
    	return newHead;
    	
    }	
 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = ListNode.getAnExampleList();
		ListNode.printList(head);
		System.out.println();
		ListNode.printList(SwapNodesInPairs24.swapPairs(head));
	}

}
