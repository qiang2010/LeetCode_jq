package qiang.list;

import java.util.LinkedList;

public class PartitionList86 {

    public static ListNode partition(ListNode head, int x) {
     if(head == null) return head;
     
     ListNode less = new ListNode(-1);
     ListNode greatOrE = new ListNode(-1);
    
     ListNode tempLess = less,tempGreat = greatOrE;
     ListNode lastLess=head;
     while(head !=null){
    	// next = head.next;
    	 if(head.val < x){
    		 lastLess = tempLess;
    		 tempLess.next = head;
    		 tempLess =  tempLess.next;
    	 }else{
    		
    		 tempGreat.next = head;
    		 tempGreat = tempGreat.next;
    	 }
    	 head = head.next;
     }
     tempGreat.next = null;
     tempLess.next = greatOrE.next;
     return less.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,7,9,10,2,3,4,5,6,2};
		ListNode head = ListNode.getListByNums(nums);
		ListNode.printList(head);
		System.out.println();
		head = partition(head, 3);
		ListNode.printList(head);
	}

}
