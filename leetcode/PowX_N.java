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
	
	public double myPow2(double x, int n) {
		if(n==0) return 1.0;
		 double ans =1.0;
		 
		 
		 
		return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowX_N p = new PowX_N();
		System.out.println(p.myPow2(2.0, 4));
	}

}
