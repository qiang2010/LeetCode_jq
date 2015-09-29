package qiang.leetcode;

import java.util.HashMap;

public class LRUCache146_2 {
 
	class Node{
		Node next = null;
		Node before = null;
		int key;
		int value;
	}
	Node head,tail;
	int capa;
	int cursize;
	HashMap<Integer,Node> keyValueMap ;
    public LRUCache146_2(int capacity) {
    	this.capa = capacity;
    	keyValueMap = new HashMap<>(capacity);
    	head  = new Node();  // 哨兵节点。
    	tail  = new Node();  // 哨兵节点。
    	head.next = tail;
    	head.before = null;
    	tail.before = head;
    	tail.next = null;
    }
    // 在双向链表头部插入一个节点
    private void insertBeforeHead(Node in){
    	Node temp = head.next;
    	head.next = in;
    	in.before = head;
    	in.next = temp;
    	temp.before  = in;
    }
    // delete a node
    private void deleteOneNode(Node del){
    	del.before.next  = del.next;  
    	del.next.before = del.before;
    }
    private void deleteTailNode(){
    	tail.before.before.next = tail;
    	tail.before = tail.before.before;
    }
    
    public int get(int key) {
    	if(keyValueMap.containsKey(key)){
    		Node temp = keyValueMap.get(key);
    		deleteOneNode(temp);
    		insertBeforeHead(temp);
    		return temp.value;
    	}
    	return -1;
    }
    
    public void set(int key, int value) {
    	if(keyValueMap.containsKey(key)){
    		Node temp = keyValueMap.get(key);
    		temp.value = value;
    		deleteOneNode(temp);
    		
    		insertBeforeHead(temp);
    		return;
    	}
    	// 已经满了，那么就删除最后一个节点，然后将新的节点插入到头部，注意keyValueMap做相同的处理
		Node tt = new Node();
		tt.key = key;
		tt.value = capa;
    	if(cursize == capa){
    		keyValueMap.remove(new Integer(tail.before.key));
    		deleteTailNode();
    	}else{
    		cursize++;
    	}
    	insertBeforeHead(tt);
		keyValueMap.put(key, tt);
    }
    
    public void print(){ }
    public static void main(String[] args) {
    	LRUCache146_2 lru = new LRUCache146_2(4);
    	lru.set(0, 0);
    	lru.set(1, 0);
    	lru.set(2, 0);
    	lru.set(3, 0);
    	lru.set(0, 0);
    	lru.set(12, 0);
    	
    	lru.print();
    }
}
