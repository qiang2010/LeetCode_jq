package qiang.leetcode;

import java.util.ArrayList;
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
    
    /**
     * 递归实现
     * @param n
     * @return
     */
    List<Integer> grayCode3(int n){
    	if(n==0){
    		List<Integer> ans = new LinkedList<>();
    		ans.add(0);
    		return ans;
    	}
    	if(n==1){
    		List<Integer> ans = new LinkedList<>();
    		ans.add(0);
    		ans.add(1);
    		return ans;
    	}
    	// 大于1的时候
    	List<Integer> gr = grayCode3(n-1);
    	// 生成n位的
    	int s = gr.size();
    	int base = 1<<(n-1);
    	List<Integer> an = new ArrayList<>(gr);
    	for(int i = s-1;i>-1;i--){
    		an.add(gr.get(i)+base);
    	}
    	return an;
    }
    
    
    
    public List<Integer> grayCode2(int n) {
        
    	List<Integer> ans = new LinkedList<>();
    	
    	ans.add(0);
    	if(n==0) return ans;
    	ans.add(1);
    	if(n==1)return ans;
    	for(int i = 2 ; i <=n ;i++){
    		int size = ans.size();
    		int base = 1<<(i-1);
    		for(int j =size-1;j>-1;j--){
    			ans.add(ans.get(j)+base);
    		}
    	}
    	return ans;
    }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
