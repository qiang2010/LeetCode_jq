package qiang.list;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergekSortedLists23 {

	/*
	 * 直接合并，一个接一个的。
	 */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return new ListNode(-1); 
    	ListNode head = null;
        for(int i = 0 ; i < lists.length ;i ++){
    		head = MergeTwoSortedLists21.mergeTwoLists(lists[i], head);
    	}
        return head;
    }	
    
    
    
    public ListNode mergeKLists3(ListNode[] lists){
    	if(lists == null || lists.length == 0 ) return null;
    	return mergeKListsRecur(lists,0,lists.length-1);
    }
    
	/**
	 *  递归两两合并
	 * @param lists
	 * @return
	 */
    public ListNode mergeKListsRecur(ListNode[] lists,int i ,int j) {
    	int k = j-i;
    	//if(lists.length-1 < j) return null;
    	if(k<0) return null;
        if(lists == null)return null;
        if(k == 0) return lists[i]; 
        if(k==1){ 
        	return MergeTwoSortedLists21.mergeTwoLists(lists[i],lists[j]);
        }
        
        ListNode left = mergeKListsRecur(lists,i, i+k/2);
        ListNode right = mergeKListsRecur(lists,i+k/2+1,j);
        return MergeTwoSortedLists21.mergeTwoLists(left, right);
        
    }
    
    /**
     * 使用优先级队列的方式合并k个已经排序的list
     * 具体实现： 1. 将k个list的head中的
     * @param lists
     * @return
     */
    public ListNode mergeKLists_PriorityQueue(ListNode[] lists){
    	Comparator<ListNode> com = new Comparator<ListNode>() {

			@Override
			public int compare(ListNode l1, ListNode l2) {
				// TODO Auto-generated method stub
				return l1.val - l2.val;
				
			}
		};
    	Queue<ListNode> pq = new PriorityQueue<ListNode>(com);
    	// 初始化将所有list的第一个节点放入到优先级队列中。
    	for(int i = 0 ; i < lists.length ; i++){
    		if(lists[i]!= null){
    			pq.add(lists[i]);
    		}else System.out.println("null");
    	}
    	System.out.println(pq.peek().val);
    	ListNode head = new ListNode(-1);
    	ListNode next = head;
    	while(!pq.isEmpty()){
    		
    		next.next = pq.poll();
    		System.out.println(next.val);
    		next = next.next; 
    		if(next.next != null ){
    			pq.add(next.next);
    		}
    	}
    	return head.next;
    }
    
	public static void main(String[]args){
		MergekSortedLists23 ms = new MergekSortedLists23();
		// ,{4},{-8},{},{-9,-6,-5,-4,-2,2,3},{-3,-3,-2,-1,0}
		int [][]nums = {{-10,-9,-9,-3,-1,-1,0},{-5}};
		ListNode [] lists = new ListNode[nums.length];
		for(int i = 0 ; i < nums.length ;i++){
			lists[i] = ListNode.getListByNums(nums[i]);
			ListNode.printList(lists[i]);
			System.out.println();
		}
	//	ListNode.printList(ms.mergeKLists3(lists));
 //		System.out.println();
		ListNode.printList(ms.mergeKLists_PriorityQueue(lists));
		
	}
}
