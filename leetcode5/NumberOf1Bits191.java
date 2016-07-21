package qiang.leetcode5;

public class NumberOf1Bits191 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingWeight(3));
	}
    public static int hammingWeight(int n) {
        int count = 0 ;
       for(int i = 0; i<32;i++){
        	//if((n&1) == 1)count++; // 注意加上括号
        	count+=(n&1); // 注意加上括号
        	n =  n >> 1;
        }
        return count;
    }
}
