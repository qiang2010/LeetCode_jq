package qiang.leetcode;

import java.util.LinkedList;
import java.util.List;

public class MajorityElementII229 {
    public static void main(String[] args) {
    	//{2,5,2,5,8,2,8,8,8,8,8};//{2,2,2,56,1};
    	
    

    	int[] nums =  {3,3};
    	List<Integer> ans =new MajorityElementII229().majorityElement(nums) ;
    	System.out.println(ans.get(0));
    	System.out.println(ans.get(1));
    }
	public List<Integer> majorityElement(int[] nums) {
	        
		  List<Integer> ans = new LinkedList<>();
		  if(nums == null || nums.length==0) return ans;
		  if(nums.length==1){
			  ans.add(nums[0]);
			  return ans;
		  }
		  int n1 = nums[0];
		  int cn1 =0;
		  while(cn1<nums.length && n1 ==nums[cn1]){
			  cn1++;
		  }
		  if(cn1 == nums.length){
			  ans.add(n1);
			  return ans;
		  }
		  int n2 = nums[cn1];
		  int cn2 = 1;
		  int i =cn1+1;
		  for(;i<nums.length;i++){
			  
			  int temp = nums[i];
			  if(n1 == temp){
				 cn1++; 
			  }else{
				  if(n2==temp){
					  cn2++;
				  }else{
					  if(cn1==0){
						  n1 = temp;
						  cn1=1;
					  }else{
						  if(cn2 ==0){
							  cn2=1;
							  n2 = temp;
						  }else{
							  cn1--;cn2--;
						  }
					  }
				  }
			  }
			  
		  }
		  cn1=0;cn2=0;
		  for(int a:nums){
			  if(a == n1)cn1++;
			  else if(a == n2)cn2++;
		  }
	
		  if(cn1 > nums.length/3) ans.add(n1);
		  if(cn2 > nums.length/3) ans.add(n2);
		  return ans;
	}
 

   
}
