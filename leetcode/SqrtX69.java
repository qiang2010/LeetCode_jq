package qiang.leetcode;

public class SqrtX69 {

	
	
    public static  int mySqrt(int x) {
     
    	if(x==0) return 0;
    	double pre=0;
    	double cur =1;
    	while(Math.abs(cur-pre) > 0.0001){
    		pre = cur;
    		cur = x/(2*pre)+ pre/2.0;
    	}
    	return (int)cur;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt(5));
	}

}
