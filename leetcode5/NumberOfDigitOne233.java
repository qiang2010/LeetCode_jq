package qiang.leetcode5;

public class NumberOfDigitOne233 {

	
    public static  int countDigitOne(int n) {
    	
    	int t,left = 0;
    	int base = 1;
    	int ans  = 0 ; 
    	while(n>0){
    		t = n%10;
    		n=  n/10;
    		if(t==1){
    			ans += n*base + left +1;
    		}else if (t >1) {
				ans += (n+1)*base;
			}else{
				ans+= n*base;
			}
    		left += t*base;
    		base *= 10;
    	}
    	
    	return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
