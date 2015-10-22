package qiang.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber202 {

	  
	
	public boolean isHappy(int n) {
		
		if(n ==0) return false;
		Set<Integer> nums = new HashSet<Integer>();
		if(n ==1)return true;
		while(n!=1){
			n = decode(n);
			if(nums.contains(n)) return false;
			nums.add(n);
		}
		return true;
	
	}
	private int decode(int i ){
		if(i <10) return i*i;
		int one;
		int ans =0;
		while( i !=0){
			one = i %10;
			i/=10;
			ans += one*one;
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(new HappyNumber202().isHappy(0));
		
	}
	
}
