package qiang.leetcode;

import java.util.LinkedList;
import java.util.List;

public class GrayCode89 {

	
	
	/**
	 *  二进制 和 Gray Code  之间的转换
	 *  　1011 = 1（照写第一位）, 1(第一位与第二位异或 1^0 = 1), 
	 *  1(第二位异或第三位， 0^1=1), 0 (1^1 =0) = 1110
	 *  其实就等于 (1011 >> 1) ^ 1011 = 1110
	 * @param n
	 * @return
	 */
    public List<Integer> grayCode(int n) {
        
    	List<Integer> ans = new LinkedList<>();
    	int size = 1<<n;
    	for(int i = 0 ; i <size ;i++){
    		ans.add((i>>1)^i);
    	}
    	return ans;

    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
