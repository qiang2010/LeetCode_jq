package qiang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {

	
     public static List<String> summaryRanges(int[] nums) {
	        int size = nums.length;
	        ArrayList<String> res = new ArrayList<String>();
	        int j=0;
	        for(int i = 0 ; i < size; i++){
	        	j=i;
	        	while(i < size-1 && nums[i]==nums[i+1]-1) i++;
	        	if(i==j){
	        		res.add(nums[i]+"");
	        	}else{
	        		res.add(nums[j]+"->"+nums[i]);
	        	}
	        	
	        }
	        for(String t:res){
	        	System.out.print(t+"  ");
	        }
	        return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums ={1,2,3,5,7,8,9,11};
		summaryRanges(nums);
		
	}

}
