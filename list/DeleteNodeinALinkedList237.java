package qiang.list;

public class DeleteNodeinALinkedList237 {

	
	
    public void deleteNode(ListNode node) {
     
    	if(node == null || node.next == null) return;
    	ListNode temp = node.next;
    	node.val = temp.val;
    	node.next = temp.next;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode example = ListNode.getAnExampleList();
		
	}

}
