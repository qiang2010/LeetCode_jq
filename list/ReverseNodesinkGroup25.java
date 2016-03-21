package qiang.list;

import java.util.LinkedList;

public class ReverseNodesinkGroup25 {

	public static void main(String[] args) {
		
		int []nums = {1,2,3,4,5};
		ListNode head = ListNode.getListByNums(nums);
		ListNode.printList(reverseKGroup2(head, 3));
	}

	
	
	
	
	/**
	 * 先判断是否有k个点，然后再反转
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode reverseKGroup2(ListNode head, int k) {
    
		if(head == null || k <=1)return head;
		
		ListNode tempHead ,ansHead = new ListNode(-1);
		tempHead = ansHead; 
		tempHead.next = head;
		ListNode undoBegin;
		while(true){
			undoBegin = head;
			for(int i =0;i<k;i++){
				if(head == null){
					return ansHead.next;
				}
				head = head.next;
			}
			ListNode ne = undoBegin.next,nene,done = undoBegin;
			undoBegin.next = head;
			for(int i =1;i<k;i++){
				nene = ne.next;
				ne.next = undoBegin;
				undoBegin = ne;
				ne = nene;
			}
			tempHead.next = undoBegin;
			tempHead = done;
		}
		
    }

	/**
	 * 首先使用一个栈，存放k个节点
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode reverseKGroup(ListNode head, int k) {
    
		if(head == null || k <=1)return head;
		
		ListNode tempHead ,ansHead = new ListNode(-1);
		tempHead = ansHead; 
//		tempHead.next = head;
		LinkedList<ListNode> stack = new LinkedList<>();
		ListNode tempListNode;
		while(true){
			tempListNode = head;
			for(int i =0;i<k;i++){
				if(head == null){
					tempHead.next = tempListNode;
					return ansHead.next;
				}
				stack.addLast(head);
				head = head.next;
			}
			while(!stack.isEmpty()){
				tempListNode = stack.getLast();
				stack.removeLast();
				tempHead.next = tempListNode;
				tempHead = tempListNode;
			}
		}
		
    }

	
}
