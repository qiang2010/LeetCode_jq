package qiang.leetcode;

import java.util.HashMap;

public class LRUCache146 {
	
	HashMap<Integer,Integer> lru;
	HashMap<Integer,Integer> lruCount;
	int capa;
	
	
    public LRUCache146(int capacity) {
    	this.capa = capacity;
        lru = new HashMap<>(capacity);
        lruCount = new HashMap<>(capacity);
    }
    
    public int get(int key) {
    	if(lru.containsKey(key)){
    		return lru.get(key);
    	}
    	return -1;
    }
    
    public void set(int key, int value) {
        if(lru.containsKey(key)){
        	for(int k:lruCount.keySet()){
    			lruCount.put(k, lruCount.get(k)+1);
    		}
        	lruCount.put(key, 0);
        }else{
        	// 还有空间
        	if(lru.size() < capa){
        		lru.put(key, value);
        		// 
        		for(int k:lruCount.keySet()){
        			lruCount.put(k, lruCount.get(k)+1);
        		}
        		lruCount.put(key, 0);
        	}else{
        		// 没有空间了，找到count最大的key，删除他们。
        		int max = -1,maxKey=-1;
        		for(int k:lruCount.keySet()){
        			if(lruCount.get(k) > max){
        				max = lruCount.get(k);
        				maxKey = k;
        			}
        			lruCount.put(k, lruCount.get(k)+1);
        		}
        		lru.remove(new Integer(maxKey));
        		lru.put(key, value);
        		lruCount.remove(new Integer(maxKey));
        		lruCount.put(key, 0);
            }
        }
    }
    
    public void print(){
    	for(int k:lru.keySet()){
    		System.out.print(k+":"+ lru.get(k)+" ");
    	}
    	System.out.println();
    }
    public static void main(String[] args) {
    	LRUCache146 lru = new LRUCache146(4);
    	lru.set(0, 0);
    	lru.set(1, 0);
    	lru.set(2, 0);
    	lru.set(3, 0);
    	lru.set(0, 0);
    	lru.set(12, 0);
    	
    	lru.print();
    }
}
