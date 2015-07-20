package qiang.leetcode;

public class PowerOfTwo231 {
	
	
	/**
	 * 改进版，效率更高
	 * @param n
	 * @return
	 */
	public  static boolean isPowerOfTwo2(int n) {
		return (n>0) && ((n-1)&(n))==0;
	}

	
	public  static boolean isPowerOfTwo(int n) {
		if(n == 0) return false;
		if(n == 1) return true;
	     if(n %2 == 1) return false;
		 while((n&1)==0){
			 n =  n>>1;
		 }
		 n= n>>1;
		 if(n==0) return true;
		 return false;
	}
	
 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfTwo2(1));
	}

}
