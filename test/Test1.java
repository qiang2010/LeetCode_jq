package qiang.test;

import java.util.HashMap;

public class Test1 {

	
	public static void main(String[] args) {
		
		System.out.println("abc".substring(2)); // 为空
		
		int k = Integer.MIN_VALUE;
		System.out.println( k &1);
		System.out.println((1<<31)&1);
		
		String a = "hello2";
		String b = "hello";
		String d = "hello";
		String c = b+2;
		String e = d+2;
		System.out.println(a==c);
		System.out.println(a==e);
		System.out.println(b==d);
		System.out.println(a);
		System.out.println(c);
		System.out.println(e);
		HashMap<Integer,Integer> map ;
	}
	
}
