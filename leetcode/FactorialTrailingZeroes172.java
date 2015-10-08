package qiang.leetcode;

public class FactorialTrailingZeroes172 {

	
	
	 public int trailingZeroes2(int n) {
		  	
		 
		 if(n<5)return 0;
		 int count = 0 ;
		 while( n != 0){
			 count += n/5;
			// n/=base;
			 n/=5;
		 }
		 
		 return count;
	 }
	
	 public int trailingZeroes3(int n) {
		  	
		 
		 if(n<5)return 0;
		 int count = 0 ;
		 long base = 5;
		 while( n/base > 0){
			 count += n/base;
			// n/=base;
			 base*=5;
 
		 }
		 return count;
	 }
    public int trailingZeroes(int n) {
        
    	if(n<5)return 0;
    	
    	int fiveCount=0;
    	int twoCount = 0;
    
    	for(int i = 2; i < n+1; i++){
    		int j = i ;
    		while(j%10 ==0){
    			fiveCount++;
    			twoCount++;
    			j /=10;
    		}
    		if(j % 2 == 0){
    			twoCount++;
    			j /= 2;
    			while( j %2 ==0){
    				twoCount++;
        			j /= 2;	
    			}
    		}else{
    			while(j%5==0){
    				fiveCount++;
    				j /=5;
    			}
    		}
    	}
    	return fiveCount > twoCount ? twoCount:fiveCount;
    }
    public static void main(String[] args) {
		
    	System.out.println(new FactorialTrailingZeroes172().trailingZeroes2(1808548329));
    	System.out.println(new FactorialTrailingZeroes172().trailingZeroes3(1808548329));
	}
    
}
