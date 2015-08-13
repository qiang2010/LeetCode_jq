package qiang.list;

import java.util.HashSet;

public class RemoveDuplicatesfromSortedList84 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = ListNode.getAnExampleList();
		ListNode.printList(head); 
		deleteDuplicates(head);
		System.out.println();
		ListNode.printList(head);
	}

	/**
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.
	 * Given 1->1->2, return 1->2.
	 * 
	 * @param head
	 * @return
	 */
    public  static ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> allVals = new HashSet<Integer>();
    	ListNode temp = head;
    	ListNode before = head;
    	ListNode next = head;
    	while(temp!=null){
    		if(allVals.contains(temp.val)){
    			before.next = next; // delete current node 
    			if(next == null ) return head;
    			temp = next;
    			next = temp.next;
    		}else{
    			
    			allVals.add(temp.val);
    			before = temp;
        		temp  = next;
        		if(temp == null ) return head;
        		next =next.next;
    		}

    		
    	}
    	return head;
    }
    
}
