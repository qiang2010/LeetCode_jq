package qiang.list;

public class RemoveDuplicatesfromSortedListII82 {
   
	
	public static ListNode deleteDuplicates(ListNode head) {
       
		if(head == null) return null;
    	
		ListNode newHead = new ListNode(-1),nextNode,curNode=newHead;
		boolean notDu = true;
		while(head!=null){
			nextNode = head.next;
			if(nextNode == null){
					curNode.next = head;
				break;
			}
			notDu = true;
			while(nextNode!= null && nextNode.val == head.val){
				nextNode = nextNode.next;
				notDu= false;
			}
			if(notDu){
				curNode.next = head;
				curNode = curNode.next;
				curNode.next =null;
			}else{
				if(nextNode == null)
					break;
			}
			head = nextNode;
		}
    	return newHead.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {1,4,4,4,4,4};
		ListNode head = ListNode.getListByNums(nums);
		head = deleteDuplicates(head);
		ListNode.printList(head);
	}

}
