package qiang.leetcode6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ZigzagIterator281 {

	public static void main(String[] args) {
		
		List<Integer> v1 = new ArrayList<>();
		v1.add(1);
		v1.add(2);
		v1.add(3);
		List<Integer> v2 = new ArrayList<>();
		v2.add(4);
		v2.add(6);
		ZigzagIterator281 dd = new ZigzagIterator281(v1,v2);
		System.out.println(dd.next());
		System.out.println(dd.next());
		System.out.println(dd.next());
		System.out.println(dd.next());
		System.out.println(dd.next());
		System.out.println(dd.next());
		int []a = {1,23,4};
		Comparator<Integer> com = new Comparator<Integer>(){
			
			public int compare(Integer a,Integer b){
				return Integer.compare(b, a);
			}
			
		};
		
	}
	
	List<Integer> v1,v2;
	int index1 =0;
	int index2 = 0;
	boolean first = true;
	int s1,s2;
	public ZigzagIterator281(List<Integer> v1, List<Integer> v2) {  

		this.v1  = v1;
		this.v2 = v2;
		index1 = 0;
		index2 = 0;
		first = true;
		s1 = v1.size();
		s2 = v2.size();
	}
	 
	public Integer next() { 
		if(first && index1< s1){
			first = false;
			return v1.get(index1++);
		}else{
			if(index2< s2){
				first = true;
				return v2.get(index2++);
			}
		}
		return null;
	}

	
	public boolean hasNext() { 
		return index1 < s1 || index2< s2;
	}
}
