package qiang.list;

public class LinkedListCycleII142 {

	
	/**
	 * 
	 * 找到环的起始点。
	 * 1. 首先找到快慢指针的相遇处
	 * 2. 相遇处正向距离环的起点的距离，和head距离环的起点的距离是一样的。
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		
		if(head ==null) return null;
		ListNode first = head,second = head;
		ListNode zNode = null;
		while(second!=null && second.next !=null){
			second = second.next.next;
			first = first.next;
			if(first == second){
				zNode = first;
				break;
			}
		}
		
		if(zNode == null) return null;
		// zNode 是快慢指针的相遇点。
		while(zNode != head &&zNode != null && head != null){
			zNode = zNode.next;
			head = head.next;
		}
		return zNode;
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
