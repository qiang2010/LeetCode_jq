package qiang.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII47 {

 
    
  public List<List<Integer>> permute22(int[] nums) {
      
	    
  	List<List<Integer>> ans = new ArrayList<List<Integer>>();
  	perm(ans,nums,0,nums.length-1);
  	return ans;
  
  }
  
  /**
   *  采用递归， 依次减小规模。
   *  
   * @param nums
   */
  public void perm(List<List<Integer>> ans,int []nums, int b ,int e){
	  if(b == e){
		  // 当只有一个数的时候
		  List<Integer> list = new ArrayList<Integer>();
		  for(int i = 0 ; i < nums.length ; i++){
			  list.add(nums[i]);
			  System.out.print(nums[i]+" ");
		  }
		  ans.add(list);
		  //System.out.println();
		 
	 }else{
		 int k = nums[b];
		 int mn;
		 boolean flagMn = false;
		 for(int j = b; j < e+1; j++){
			 flagMn = false;
			 for(  mn  = b; mn< j;mn++){
				 if(nums[mn] == nums[j]){
					 flagMn = true;
					 break;
				 }
			 }
			 if(flagMn)continue;
			 nums[b] = nums[j];
			 nums[j] = k;
			 perm(ans,nums,b+1,e);
			 //交换过来以后，在和下一个位置去交换
			 nums[j] = nums[b];
			 nums[b] = k;
		 }
	 }
  }
  
	
	public static void main(String []args){
		PermutationsII47 pp = new PermutationsII47();
		int []nums = {1};
		pp.permute22(nums);
		
	}
	
	
}
