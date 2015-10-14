package qiang.list;

public class IntersectionOfTwoLinkedLists131 {
    
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    
		if(headA == null || headB == null) return null;
		
		int aSize = 1 ; 
		int bSize = 1 ;
		ListNode tempAhead = headA,tempBhead = headB;
		
		while(tempAhead.next != null){
			aSize++;
			tempAhead = tempAhead.next;
		}
		while(tempBhead.next != null){
			bSize++;
			tempBhead = tempBhead.next;
		}
		if(tempAhead != tempBhead ) return null;
		
		int diff = aSize - bSize;
		// 保证tempAhead 是较长的链表
		if(diff < 0){
			tempAhead = headB;
			tempBhead = headA;
			diff = -diff;
		}else{
			tempAhead = headA;
			tempBhead = headB;
		}
		while(tempAhead != null && diff > 0 ){
			tempAhead = tempAhead.next;
			diff--;
		}
		while(tempAhead !=null && tempBhead !=null && tempAhead != tempBhead){
			tempAhead = tempAhead.next;
			tempBhead = tempBhead.next;
		}
		return tempAhead;
    }
    public static void main(String[] args) {
		
    	int nums[]={1,2,3};
    	ListNode headA = ListNode.getListByNums(nums);
    	ListNode headB = ListNode.getListByNums(nums);
    	System.out.println(new IntersectionOfTwoLinkedLists131().getIntersectionNode(headA, headB));
    	
	}
    
    
}
