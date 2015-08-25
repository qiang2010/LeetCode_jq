package qiang.leetcode;

public class PowX_N {
    
	
	
	
	public double myPow1(double x, int n) {
		if(n==0) return 1.0;
		double ans = 1;
		boolean flag = false;
		if(n<0){
			flag = true;
			n = -n;
		}
		for(int i =0; i < n; i++){
			ans *=x;
		}
		if(flag)
			return 1/ans;
		return ans;
    }
	
	/**
	 * myPow2 采用分治法
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow2(double x, int n) {
		if(n==0) return 1.0;
		if( n <0){
			// 为了防止 Intege.MIN_VALUE
			return 1.0/(myPowNgreaterThan0(x,-(n+1))*x);
		}
		return myPowNgreaterThan0(x, n);
    }
	// 这个只是计算n>0的情况
	public double myPowNgreaterThan0(double x,int n){
		if(n ==1) return x;
		if(n ==0 ) return 1.0;
		if(n==2) return x*x;
		if(n%2==0)
			return myPowNgreaterThan0(x, n/2)*myPowNgreaterThan0(x, n/2);
		else
			return myPowNgreaterThan0(x, n/2)*myPowNgreaterThan0(x, n/2)*x;
	}
	/**
	 *  上面的分治法也超时，这里使用移位操作
	 *  if it is "10001011", then x^n = x^(1+2+8+128) = x^1 * x^2 * x^8 * x^128.
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow3(double x, int n) {
		
		if(n==0) return 1.0;
		if(n<0){
			if(n == Integer.MIN_VALUE){
				return 1/(myPow3(x, Integer.MAX_VALUE)*x);
			}else{
				return 1/myPow3(x,-n);
			}
		}
		double ans = 1;
		for( ; n >0 ;x*=x, n>>=1){
			if((n&1)==1){
				ans*= x;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowX_N p = new PowX_N();
		System.out.println(p.myPow3(2.0, 10));
	}

}
