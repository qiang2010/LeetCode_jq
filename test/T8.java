package qiang.test;

import java.util.LinkedList;

public class T8 {

	
	public static void main(String[] args) {
		
		String str = "abc";
		System.out.println("sub:"+str.substring(0,0));
		System.out.println("sub:"+str.substring(0,1));
		System.out.println("sub:"+str.substring(0,2));
		System.out.println("sub:"+str.substring(0,3));
		System.out.println("sub:"+str.substring(1));
	
		LinkedList<Integer> ass = new LinkedList<>();
		ass.toArray();
		
		System.out.println( 3 + (4>>1));
		System.out.println( 3<<2|1);
		
	}
}