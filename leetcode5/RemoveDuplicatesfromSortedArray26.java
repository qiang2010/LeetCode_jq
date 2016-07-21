package qiang.leetcode5;

public class RemoveDuplicatesfromSortedArray26 {

	
	public static int removeDuplicates(int[] nums) {
	    int res=0;
	    int j = 0 ;
	    int size = nums.length;
	    for(int i=0;i<size;){
			j=i+1;
			while(j < size && nums[j] == nums[i] ) j++;
			res++;	
			if(j==size)break;
				nums[res] = nums[j];
			
			i=j;
		}
//	    for(int x:nums){
//	    	System.out.print(x+" ");
//	    }
//	    System.out.println();
		return res;
    }
	
	public static int removeDuplicates2(int[] nums) {
	    int res=0;
	    int j = 0 ;
		for(int i=0;i<nums.length;){
			j=i+1;
			while(j < nums.length && nums[j] == nums[i] ) j++;
			res++;
			i=j;
		}
		return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int []nums ={1,2,3,4,5,5,5,5,5,6,7,8,9,9,9,10};
		int []nums={1,1,1,1,1,1,1,2,3};
		System.out.println(removeDuplicates(nums));
	}

}
