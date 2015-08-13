package qiang.list;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * @author jq
 *
 */

public class MergeTwoSortedLists21 {

	
	
    public static  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode cur = head;
        while(l1!=null && l2!=null){
        	if(l1.val < l2.val){
        		cur.next = l1;
        		l1= l1.next;
        	}else{
        		cur.next = l2;
        		l2 = l2.next;
        	}
        	cur = cur.next;
        }
        if(l1 != null){
        	cur.next = l1;
        }else{
        	cur.next= l2;
        }
        return head.next;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums1 = {1,3,5,7};
		int []nums2 = {2,4,6,7,8};
		ListNode l1 = ListNode.getListByNums(nums1);
		ListNode l2 = ListNode.getListByNums(nums2);
		ListNode.printList(MergeTwoSortedLists21.mergeTwoLists(l1, l2));
	}

}
