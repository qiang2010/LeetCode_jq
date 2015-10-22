package qiang.leetcode;

public class CountPrimes204 {

	
	 
	
	public int countPrimes(int n) {
	        
		if(n ==0) return 0;
		if(n ==1) return 0;
		if(n == 2) return 0;
		boolean notPrime[] = new boolean[n+1];
		int limit = (int)Math.sqrt(n);
		for(int i =2; i < limit+1; i ++ ){
			if(!notPrime[i])
				for( int j = i*i; j < n+1;j+=i){
					notPrime[j] = true;
				}
		}
		int ans =0;
		for( int j = 2; j < n;j++){
			if(!notPrime[j])ans++;
		}
		return ans;
	}
	public static void main(String[] args) {
		
		System.out.println(new CountPrimes204().countPrimes(6));
	}
}
