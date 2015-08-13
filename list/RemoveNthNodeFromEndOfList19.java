package qiang.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 *    After removing the second node from the end, the linked list becomes 1->2->3->5.
 *    Note:
 *    Given n will always be valid.
 *    Try to do this in one pass.
 * @author jq
 * 
 *
 */
public class RemoveNthNodeFromEndOfList19 {
    
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
		Map<Integer,ListNode> allNode = new HashMap<Integer,ListNode>();
		int i = 0 ; 
        ListNode next = head;
		while(next!= null){
        	allNode.put(i++, next);
        	next = next.next;
//        	i++;
        }
		// 如果要删除的节点是head
		if(i==n){
			head = head.next;
			return head;
		}
		// 找到要删除节点的前一个节点
        ListNode beforeDele = allNode.get(i-n-1);
		beforeDele.next = beforeDele.next.next; 
		return head;
    }
	
	public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head == null) return null;
        ListNode p = head,q = head;
        for(int i = 0 ; i < n-1; i++){
        	p= p.next;
        }
        ListNode beforeDele = q;
        while(p.next!=null){
        	beforeDele = q;
        	q = q.next;
        	p=p.next;
        }
        if(q == head){
        	head = head.next;
        }
        else
        	beforeDele.next = beforeDele.next.next;
        return head;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = ListNode.getAnExampleList();
		ListNode.printList(head);
		
		removeNthFromEnd2(head, 2);
		System.out.println();
		ListNode.printList(head);
		
	}

}
