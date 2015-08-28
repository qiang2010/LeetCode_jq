package qiang.leetcode;

import java.util.Arrays;

public class PlusOne66 {

	
	
	
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length==0){
        	int []ans = {1};
        	return ans;
        }
    	
        int size = digits.length;
        digits[size-1]+=1;
        if(digits[size-1] <10) return digits;
        int cay=digits[size-1]/10;
        digits[size-1] = digits[size-1]%10;
        int k =size-2;
        while(k >-1 && cay!=0){
        	digits[k] += cay;
        	cay = digits[k]/10;
        	digits[k] = digits[k]%10;
        	k--;
        }
        if(cay == 0) return digits;
        // cay !=0 说明需申请size+1的数组
        
        int []ans = new int[size+1];
        for(int i =1;i<size+1;i++){
        	ans[i] = digits[i-1];
        }
        ans[0] = cay;
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] digits={9,9,9};
		PlusOne66 po = new PlusOne66();
		digits = po.plusOne(digits);
		System.out.println(Arrays.toString(digits));
	}

}
