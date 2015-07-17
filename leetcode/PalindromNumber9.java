package qiang.leetcode;

public class PalindromNumber9 {

	
    public  static boolean isPalindrome(int x) {
     
    	int base = 1;
    	int tempX = x/10;
    	boolean flag = true;
    	int len = 1;  //由于tempX ＝ x/10;所以这里len初始化为1，否则出错
    	if(x < 0) return false;
    	if( x < 10) return true;
    	
    	while( tempX != 0){
    	   tempX /=10;
    	   base*=10;
    	   len++;
    	}
    	len /= 2;
    	int left = x;
    	int right = x;
    	System.out.println(base);
    	while(len !=0){
    		//System.out.println(left/base + " " +right%10 );
    		if(left/base != right%10){
    			return false;
    		}else{
    			left = left %base;
    			base /=10;
    			right /=10;
    		//	System.out.println(left + " "+ right);
    		}
    		len-- ;
    	}
    	return flag;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 12;
		System.out.println(isPalindrome(x));
	}

}
