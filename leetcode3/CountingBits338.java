package qiang.leetcode3;

import qiang.leetcode.util.PrintUtil;

public class CountingBits338 {

	public static void main(String[] args) {
		int []s = countBits(4);
		for(int a:s)
			System.out.println(a);
	}
	
	
    public static int[] countBits(int num) {
        
    	if(num<0)return new int[0];
    	int []ans = new int[num+1];
    	ans[0]=0;
    	int last=1;
    	int lastBase = 1;
    	for(int i =1;;i++){
    		int next = (1<<i) - 1;
    		while(last<1+next && last <= num){
    			ans[last] = ans[last-lastBase]+1;
    			last++;
    		}
    		if(last==num+1)return ans;
    		lastBase = next+1;
    	}
    }
    
    
}
