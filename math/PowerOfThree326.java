package qiang.math;

public class PowerOfThree326 {

	public static void main(String[] args) {
		
		System.out.println(isPowerOfThree(243));
	}
	   
	public static  boolean isPowerOfThree(int n) {
		if(n < 1)return false;
		if(n ==1)return true;
		double a = Math.log(n)/Math.log(3);
		int b = (int)(a+0.5);
		System.out.println(a+"\t"+b);
		if(Math.abs(a-b)<Math.pow(10, -10))return true;
		return false;
		
	}
	
}
