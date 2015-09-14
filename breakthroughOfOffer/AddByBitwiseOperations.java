package qiang.breakthroughOfOffer;

public class AddByBitwiseOperations {

	
	
	/**
	 *  加法，不使用加减乘除
	 * @param a
	 * @param b
	 * @return
	 */
	public static int add(int a,int b){
		
		int c = a & b;
		int ans = a^b;
		while(c != 0){
			c = c<<1;
			ans = ans^c;
			c = ans&c;
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(add(2, 1004));
	}
}
