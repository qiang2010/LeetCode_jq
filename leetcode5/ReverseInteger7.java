package qiang.leetcode5;

public class ReverseInteger7 {

	
    public  static int reverse(int x) {
     long re = 0;  // 开始我没有考虑边界问题，使得转换后，超界，这里使用long
     int base  = 10;
     int y = x<0 ? -x:x;
     while(y != 0 ){
    	 re= (y%10)+ re*base;
    	 //base*=10;
    	 y/=10;
     }
     re = x< 0? -re : re;
     if(re > Integer.MAX_VALUE || re < Integer.MIN_VALUE)  return 0;
     return (int) re;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x= -2147483648;
		System.out.println(reverse(x));
	}

}
