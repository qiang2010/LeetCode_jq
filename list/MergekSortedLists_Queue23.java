package qiang.list;

import java.util.LinkedList;

public class MergekSortedLists_Queue23 {

	/*
	 * 
	 * 使用队列来存放结果，这样就避免了递归。
	 * 
	 */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null; 
    	LinkedList<ListNode> queue = new LinkedList<>();
    	for(ListNode l:lists){
    		queue.add(l);
    	}
    	ListNode temp1,temp2;
    	while(queue.size()>1){
    		temp1 = queue.getFirst();
    		queue.removeFirst();
    		temp2  = queue.getFirst();
    		queue.removeFirst();
    		queue.addLast(MergeTwoSortedLists21.mergeTwoLists(temp1, temp2));
    	}
        return queue.getFirst();
    }	
    
    
    
	public static void main(String[]args){
		// ,{4},{-8},{},{-9,-6,-5,-4,-2,2,3},{-3,-3,-2,-1,0}
		MergekSortedLists_Queue23 mq = new MergekSortedLists_Queue23();
		int [][]nums = {{-10,-9,-9,-3,-1,-1,0},{-5}};
		ListNode [] lists = new ListNode[nums.length];
		for(int i = 0 ; i < nums.length ;i++){
			lists[i] = ListNode.getListByNums(nums[i]);
			ListNode.printList(lists[i]);
			System.out.println();
		}
		ListNode.printList(mq.mergeKLists(lists));
 
	}
}
