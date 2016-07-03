package qiang.leetcode4;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak343 {
     
	public static void main(String[] args) {
		
		System.out.println(integerBreak(8));
		
	}
	static Map<Integer,Integer> cache = new HashMap<>();
	public static  int integerBreak(int n) {
		if(n ==1 ) return 1;
		if(n==2) return 1;
		if(n==3) return 2;
		if(cache.containsKey(n)) return cache.get(n);
		int max = n-1; // 1*n-1
		int tt;
		for(int i = 1;i<=n/2;i++){
			tt = i*(n-i);
			max = Math.max(tt, max);
			int lef = integerBreak(i);
			int r = integerBreak(n-i);
			max = Math.max(lef*r, max);
			max = Math.max(i*r, max);
			max = Math.max(lef*(n-i), max);
		}
		cache.put(n, max);
		return max;
	}
	public   int integerBreak2(int n) {
		
		if(n ==1 ) return 1;
		if(n==2) return 1;
		if(n==3) return 2;
		
		int bre[] = new int[n+1];
		bre[0] =1;
		bre[1] =1;
		bre [2] =2;
		bre[3] =3;
		bre[4] =4;
		for(int i  = 4;i < n+1;i++){
			bre[i] = bre[i-3]*3;
		}
		return bre[n];
	}
}
