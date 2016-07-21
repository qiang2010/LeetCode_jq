package qiang.leetcode5;

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
	
		System.out.println(pi.peek());//1
		System.out.println(pi.peek());//1
		
		System.out.println(pi.next());//1
		System.out.println(pi.next());//2
		
		System.out.println(pi.peek());//3
		System.out.println(pi.peek());//3
		
		System.out.println(pi.next());//3
		System.out.println(pi.peek());//4
		System.out.println(pi.hasNext());//4
		System.out.println(pi.next());//4
		System.out.println(pi.hasNext());//4
	}
	
	Iterator<Integer> it;
	int top;
	boolean first = true;
	boolean second = true;
	public PeekingIterator284(Iterator<Integer> iterator) {
		this.it = iterator;
		if(it.hasNext()){
			top = it.next();
		}
	}
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return top;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		int cur = top;
		if(it.hasNext())
			top = it.next();
		else {
			first = false;
		}
	
		return cur;
 
	}

	@Override
	public boolean hasNext() {
		return  first;
	}
}

