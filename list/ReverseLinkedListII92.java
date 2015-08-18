package qiang.list;

public class ReverseLinkedListII92 {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // 首先从head走m个节点
    	ListNode newHead = head;
    	int count = 1; 
    	ListNode beforeHead =null;
    	while(count < m && head != null ){
    		beforeHead = head;
    		head= head.next;
    		count++;
    	}
    	if(head == null ||head.next == null ) return newHead;
    	if(beforeHead !=null )
    		beforeHead.next = reverseList(head, n-m+1);
    	else 
    		return reverseList(head, n-m+1);
    	return newHead;
    }
    
	/**
	 *  head 是当前要被拿下来的节点。
	 *  cur是未被处理的链表开头部分。
	 * @param head
	 * @param num  从head开始的count个节点
	 * @return
	 */
    public static ListNode reverseList(ListNode head,int num) {
        ListNode newHead = null;
        ListNode cur,last = head;
        
        int count = 0;
        while(head != null && count < num){
        	cur = head.next;
        	head.next = newHead;
        	newHead = head;
        	head = cur;
        	count++;
        }
        last.next = head; // 连接上后面的
        return newHead;
    }
    
	public static void main(String[]args){
		ListNode head = ListNode.getAnExampleList();
		ListNode.printList(head);
		System.out.println();
		ListNode.printList(ReverseLinkedListII92.reverseBetween(head,1,2));
		
		
		
	}
}
