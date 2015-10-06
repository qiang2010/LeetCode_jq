package qiang.randomList;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer138 {

	
	
    public RandomListNode copyRandomList2(RandomListNode head) {
    	
    	if(head == null) return null;
    	RandomListNode tempHead = head,newList,tempNode;
    	while(tempHead != null){
    		tempNode = new RandomListNode(tempHead.label);
    		tempNode.next = tempHead.next;
    		tempHead.next = tempNode;
    		tempHead = tempNode.next;
    	}
    	// 设置random
    	tempHead = head;
    	while(tempHead != null){
    		if(tempHead.random !=null){
    			tempHead.next.random = tempHead.random.next;
    		}
    		tempHead = tempHead.next.next;
    	}
    	// 将结点取 出
    	newList  = new RandomListNode(-1);
    	RandomListNode newHead = newList;
    	tempHead = head;
    	while(tempHead != null){
    		newList.next = tempHead.next;
    		tempHead.next = tempHead.next.next;
    		newList = newList.next;
    		tempHead = tempHead.next;
    	}
    	return newHead.next;
    	
    }
	
	/**
	 * 
	 * 使用额外的map记录新旧结点之间的对应关系。
	 * 
	 * @param head
	 * @return
	 */
    public RandomListNode copyRandomList(RandomListNode head) {
        
    	if(head == null) return null;
    	Map<RandomListNode,RandomListNode> oldNewMap = new HashMap<>();
    	RandomListNode newList = new RandomListNode(-1),tempHead = head,tempNode;
    	RandomListNode lastNew=newList;
    	while(tempHead!=null){
    		tempNode = new RandomListNode(tempHead.label);
    		oldNewMap.put(tempHead, tempNode);
    		lastNew.next = tempNode;
    		lastNew = tempNode;
    		tempHead = tempHead.next;
    	}
    	lastNew = newList.next;
    	tempHead = head;
    	while(tempHead!=null){
    		if(tempHead.random!=null){
    			lastNew.random = oldNewMap.get(tempHead.random);
    		}
    		tempHead = tempHead.next;
    		lastNew = lastNew.next;
    	}
    	return newList.next;
    }
    
    public static void main(String[] args) {
		
    	
    	
	}
	
}
