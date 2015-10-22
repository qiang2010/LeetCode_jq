package qiang.leetcode;

public class AddDigits258 {
	  
	
	public int addDigits(int num) {
		if(num ==0)return 0;
		int ans = num%9;
		return ans ==0? 9:ans;
	}
}
