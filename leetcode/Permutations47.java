package qiang.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations47 {

 
    
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
  Set<String> allPer = new HashSet<String>();
  public void perm(List<List<Integer>> ans,int []nums, int b ,int e){
	  if(b == e){
		  // 当只有一个数的时候
		  List<Integer> list = new ArrayList<Integer>();
		  StringBuilder key = new StringBuilder();
		  for(int i = 0 ; i < nums.length ; i++){
			  list.add(nums[i]);
			  key.append(list.get(i));
//			  System.out.print(nums[i]+" ");
		  }
		 
		  if(!allPer.contains(key.toString())){
			  ans.add(list);
			  allPer.add(key.toString());
			  System.out.println(list.toString());
		  }
	 }else{
		 int k = nums[b];
		 for(int j = b; j < e+1; j++){
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
		Permutations47 pp = new Permutations47();
		int []nums = {1,1,3};
		pp.permute22(nums);
		
	}
	
	
}
