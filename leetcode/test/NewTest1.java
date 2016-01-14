package qiang.leetcode.test;

public class NewTest1 {

	public static void main(String[] args) {
		
		System.out.println((Float.NaN == Float.NaN));
		float a = Float.NaN;
		float b = Float.NaN;
		System.out.println(a==b);
		
		System.out.println(Float.NaN == Double.NaN);
		
		System.out.println("FC " + (Double.compare(1,Double.NaN)));
	}
	
}
