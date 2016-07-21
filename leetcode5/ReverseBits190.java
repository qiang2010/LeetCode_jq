package qiang.leetcode5;

public class ReverseBits190 {

	
	private static int []base = new int[32];
	static {
		int b = 1;
		for(int i =0;i < 32;i++){
			base[i] = b;
			b*=2;
		}
	}
	
	public int reverseBits(int n) {
	       
		if( n==0) return n;
 
		int tempN = n;
		int ans =0;
		for(int i =0;i <32; i++){
			if( (tempN & 1)==1){
				ans = ans | base[31-i];
			}
			tempN>>>=1; 
		}
		return ans;
	}
	public static void main(String[] args) {
		
		System.out.println(new ReverseBits190().reverseBits(2));
		
	}
}
