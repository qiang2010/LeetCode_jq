package qiang.list;

public class ReverseLinkedList206 {

	
	
	/**
	 *  head 是当前要被拿下来的节点。
	 *  cur是未被处理的链表开头部分。
	 * @param head
	 * @return
	 */
    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode cur;
        while(head != null){
        	cur = head.next;
        	head.next = newHead;
        	newHead = head;
        	head = cur;
        }
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
		ListNode.printList(ReverseLinkedList206.reverseList(head));
		
		
		
	}
}
