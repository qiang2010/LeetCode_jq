package qiang.leetcode2;

public class UglyNumber263 {
	 
	public static void main(String[] args) {
		System.out.println(new UglyNumber263().nthUglyNumber(14));
	}
	   
	public int nthUglyNumber(int n) {
	        
		int ans = 1;
		int [] ugly = new int[n];
		ugly[0]=1;
		int i2 =0,i3=0,i5=0;
		
		for(int i=1 ;i < n; i++){
			ans = Math.min(ugly[i2]*2, ugly[i3]*3);
			ans = Math.min(ans, ugly[i5]*5);
			ugly[i] = ans;
			if(ugly[i2]*2 == ans) i2++;
			if(ugly[i3]*3 == ans) i3++;
			if(ugly[i5]*5 == ans) i5++;
		}
	
		return ans;
	}
}
