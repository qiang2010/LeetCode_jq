package qiang.leetcode6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class GCD {
	public static void main(String[] args) {
		
		int [] nums = {6,5,5};
		GCD dd=new GCD();
		System.out.println(dd.majorityElement(nums));
	}

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        if(nums ==null || nums.length == 0) return ans;
        if(nums.length == 1){
            ans.add(nums[0]);
            return ans;
        }
        Integer []cand = new Integer[2];
        int []count = new int[2];
        for(int i =0;i < nums.length; i++){
             boolean find= false;
             for(int j =0; j < 2;j++){
                  if(cand[j] != null && cand[j] == nums[i]) {
                       count[j]++;
                       find = true;
                       break;
                  }
             }
             boolean zero = false;
             if( !find){
               for(int j =0; j < 2;j++){
                  if(count[j]==0){
                       cand[j] = nums[i];
                       count[j] =1;
                       zero = true;
                       break;
                  }
               }
               if(!zero){
                  for(int j =0;j <2;j++) count[j]--;
              }
             }
           
        }   
        // 
        System.out.println(cand[0]+"\t"+cand[1]);
        if(cand[0] == null){
            cand[0] = cand[1]+1;
        }
        if(cand[1]==null)cand[1] = cand[0]+1;
        count[0] = count[1] = 0;
        for(int a : nums){
            if(a == cand[0])count[0]++;
            else if(a == cand[1]) count[1]++;
        }
        System.out.println(count[0]+"\t"+count[1]);
        System.out.println(cand[0]+"\t"+cand[1]);
        if(count[0]> nums.length /3) ans.add(cand[0]);
        if(count[1]> nums.length /3) ans.add(cand[1]);
        return ans;
    }
        
            
    

}
