package qiang.list;

public class ReverseLinkedList206 {

	
 
	
	/**
	 * 
	 * 这里递归来反转链表
	 * 	将反转规模缩小，ListNode newHeadListNode = reverseList_re(next);
	 * 将next为头结点的链表反转，然后next就到了链表结束，然后将next的next置为head。搞定。
	 * 
	 * @param head
	 * @return
	 */
	  public static ListNode reverseList_re(ListNode head) {
		  
		  if(head == null) return null;
		  if(head.next ==null)
			  return head;
		  ListNode next = head.next;
		  head.next = null;
		  ListNode newHeadListNode = reverseList_re(next);
		  next.next = head;
		  return newHeadListNode;
	  }
	
	
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
		ListNode.printList(ReverseLinkedList206.reverseList_re(head));

	}
}
