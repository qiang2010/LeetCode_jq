package qiang.leetcode;

public class BitwiseANDofNumbersRange201 {

	
	   
	public int rangeBitwiseAnd2(int m, int n) {
		
		if(m == n) return m;
		if(m > n) return 0;
		int gap = n-m+1;
		if(gap == 2) return m&n;
		int ans = 1;
		int tempM = m;
		while(gap>1){
			ans *=2;
			m/=2;
			n/=2;
			gap = n-m+1;
		}
		return tempM&(~(ans-1));
	}
	    
	
	
	public int rangeBitwiseAnd(int m, int n) {
	    
		if(n<m)return 0;
		int ans= m;
		for(int i = m+1; i <n+1; i++){
			ans &=i;
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(new BitwiseANDofNumbersRange201().rangeBitwiseAnd2(5, 8));
		
		
	}   
}
