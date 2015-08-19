package qiang.leetcode;



/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 * @author jq
 *
 */
public class DivideTwoInteger29 {

	
	/**
	 * 
	 *  要注意的是： 在数值前面加上负号，表示对所有位取反加一。
	 *  因此对于最小的负数， MIN_VALUE，全部取反加一以后还是MIN_VALUE
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
    public static int divide(int dividend, int divisor) {
    	long ans = 0 ;
    	if(dividend ==0) return 0;
       if(divisor == 0 ) return 0;
       if(divisor == 1) return dividend;
       if(divisor == -1) {
    	   ans -=  dividend;
    	   System.out.println("ll"+((long)0-Integer.MIN_VALUE));
    	   if(ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
    	   return (int)ans;
       }
       
        
       long a = dividend < 0 ?  (long)0-dividend: dividend;
       long b = divisor  < 0 ?  (long)0-divisor : divisor;
       //System.out.println(Integer.MIN_VALUE);
      // System.out.println(Integer.MAX_VALUE);
       while(a >=b){
    	   
    	   // 防止在移位过程中发生溢出问题
    	   long c = b;
    	   
    	   for(int i = 0 ; a >=c; i++, c<<=1){
    		   a-=c;
    		   ans += 1<<i;
    	   }
    	   
       }
       
       System.out.println(Integer.toBinaryString(divisor>>31));
       System.out.println(Integer.toBinaryString((divisor ^ dividend)>>31));
       System.out.println(Integer.toBinaryString(dividend>>31));
       if(divisor < 0 && dividend > 0 || divisor > 0 && dividend < 0)
    	   return (int) -ans;
    	return (int)ans;
    }	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DivideTwoInteger29.divide(-2147483648, 2));
	}

}
