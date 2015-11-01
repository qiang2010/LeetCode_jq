package qiang.leetcode;

import java.util.ArrayList;
import java.util.Iterator;

public class PeekingIterator284 implements Iterator<Integer> {

	public static void main(String[] args) {
		
		ArrayList<Integer> as = new ArrayList<>();
		as.add(1);
		as.add(2);
		as.add(3);
		as.add(4);
		
		PeekingIterator284 pi = new PeekingIterator284(as.iterator());

		System.out.println(pi.hasNext());
	
		System.out.println(pi.peek());
		System.out.println(pi.peek());
		
		System.out.println(pi.next());//1
		System.out.println(pi.next());//2
		
		System.out.println(pi.peek());
		System.out.println(pi.peek());
		
		System.out.println(pi.next());
	
	}
	
	Iterator<Integer> it;
	int cur;
	boolean first = true;
	boolean nextNeed = true;
	public PeekingIterator284(Iterator<Integer> iterator) {

		this.it = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(first){
        	cur = it.next();
        	first = false;
        	nextNeed = true;
        	return cur;
        }
        return cur;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if(!first && nextNeed){
			nextNeed = false;
			return cur;
		}else{
			first = false;
			nextNeed = false;
		}
		
		cur = it.next();
		return cur;
	}

	@Override
	public boolean hasNext() {
	    return it.hasNext();
	}
}