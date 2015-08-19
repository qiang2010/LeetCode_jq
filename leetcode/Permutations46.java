package qiang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {

	
    public  List<List<Integer>> permute(int[] nums) {
    
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	per2(ans,new ArrayList<Integer>(), nums);
    	return ans;
    }
    public void per(List<List<Integer>> ans ,List<Integer> one, int []nums){
    	
    	// 一个排列已经形成
    	if(one.size() == nums.length){
    		List<Integer> list = new ArrayList<>();
    		list.addAll(one);
    		ans.add(list);
    		System.out.println(one.toString());
    		return ;
    	}
    	for(int i = 0 ; i < nums.length ; i++){
    		if(!one.contains(nums[i])){
    			one.add(nums[i]);
    			per(ans, one, nums);
    			//for(int j = i ; j<one.size() ; j++)
    			one.remove(one.lastIndexOf(nums[i]));
    		}
    	}
    }
    
    /**
     *  上面的per不能处理 nums中有重复数字的情况
     *  修改后的per2可以解决这种情况
     * @param ans
     * @param one
     * @param nums
     */
  public void per2(List<List<Integer>> ans ,List<Integer> one, int []nums){
    	
    	// 一个排列已经形成
    	if(one.size() == nums.length){
    		List<Integer> list = new ArrayList<>();
    		for(int i = 0 ; i < one.size();i++){
    			list.add(nums[one.get(i)]);	
    		}
    		ans.add(list);
    		System.out.println(list.toString());
    		return ;
    	}
    	for(int i = 0 ; i < nums.length ; i++){
    		if(!one.contains(i)){
    			one.add(i);
    			per2(ans, one, nums);
    			//for(int j = i ; j<one.size() ; j++)
    			one.remove(new Integer(i));
    		}
    	}
    }
  
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
//			  System.out.print(nums[i]+" ");
		  }
		  ans.add(list);
		  System.out.println(list.toString());
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
		Permutations46 pp = new Permutations46();
		int []nums = {1,2,3,4};
		pp.permute22(nums);
		
	}
	
	
}
