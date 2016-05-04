package qiang.leetcode4;

import java.util.ArrayList;

public class PermutationSequence60_2 {

	public static void main(String[] args) {
		getPermutation(3, 5);
	}	
	
	/**
	 * 这里使用数组来实现 
	 * @param n
	 * @param k
	 * @return
	 */
	public static String getPermutation( int n, int k) {
		 
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> numbers = new ArrayList<>();
		int []fn = new int[n];
		fn[0] = 1;
		int f = 1;
		for(int i =1;i< n;i++){
			numbers.add(i);
			fn[i] = i*f;
			f*=i;
		}
		numbers.add(n);
		int left;
		int per = k-1; // 第k个，索引就是k-1；
		for(int j = n;j>1;j--){
			left =  per/fn[j-1];
			per = per % fn[j-1];
			int p= numbers.get(left);
			numbers.remove(left);
			sb.append(p);
		}
		sb.append(numbers.get(0));
		return sb.toString();
	}
}
