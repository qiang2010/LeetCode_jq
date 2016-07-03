package qiang.leetcode4;

public class SumofTwoIntegers371 {

	public static void main(String[] args) {

		SumofTwoIntegers371 ss = new SumofTwoIntegers371();
		ss.getSum(5, 1110);
			
	}
    public  int getSum(int a, int b) {
    	int d = a^b;
    	int c = a&b;
//    	System.out.println(a+b);
    	while(c != 0){
    		c = c<<1;
    		b = c^d;
    		a = c&d;
    		c = a;
    		d = b;
    	}
    	System.out.println(c+"\t"+d);
//    	System.out.println(((c<<1)|d));
    	return d;
    }
}
