package qiang.leetcode4;

public class PoweroFour342 {

	public static void main(String[] args) {

		
	}
	  
	public boolean isPowerOfFour(int num) {
	        
		if(num < 1) return false;
		return ((num-1)&num)==0 && ( num & 0x55555555)!=0;
		
	}
}
