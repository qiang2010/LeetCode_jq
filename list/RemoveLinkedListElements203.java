package qiang.list;

public class RemoveLinkedListElements203 {
    
	
	/**
	 *  从链表中删除节点，为了简化操作
	 *  1. 可以增加一个头部哨兵节点
	 *  2. 最后一个节点单独处理。
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements(ListNode head, int val) {
		if(head == null) return head;
		ListNode newHead = new ListNode(val+2);
		newHead.next = head;
		ListNode cur = head,last = newHead;
		while(cur.next !=null){
			if(cur.val == val){
				last.next = cur.next;
				cur = cur.next;
			}else{
				last = cur;
				cur = cur.next;
			}
		}
		if(cur.val==val){
			last.next=null;
		}
		return newHead.next;
	}
	public static void main(String[] args) {
		
		int []nums={};
		
		ListNode head = ListNode.getListByNums(nums);
		head = new RemoveLinkedListElements203().removeElements(head, 1);
		ListNode.printList(head);
	}
}
