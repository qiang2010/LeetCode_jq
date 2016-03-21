package qiang.dynamicPromming;

import qiang.leetcode.util.PrintUtil;

public class CreateMaximumNumber321 {

	public static void main(String[] args) {
		
//		int nums1[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		
//		int nums2[]={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int nums1[] = {8,6,9};
		int nums2[]=  {1,7,5};
		CreateMaximumNumber321 ss = new CreateMaximumNumber321();
		System.out.println(nums1.length +"  "+nums2.length);
		int []ans = ss.maxNumber(nums1, nums2,3);
		for(int i:ans)System.out.println(i);
	}
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(nums1 == null && nums2 == null)return new int[0];
    	int size1 = nums1 == null ? 0:nums1.length;
    	int size2 = nums2 == null ? 0: nums2.length;
    	int []ans = new int[k];
    	if(size1 ==0 && size2 >=k){
    		chooseKnums(nums2, k, ans);
    		return ans;
    	}
    	if(size2==0 && size1 >= k){
    		chooseKnums(nums1, k, ans);
    		return ans;
    	}
    	if(size1 +size2 < k){
    		return new int[0];
    	}
    	// OK 了
    	int chooseFrom1[] = new int[k];
    	int chooseFrom2[]= new int[k];
    	int maxAns [] = null;
    	int tempA[];
    	for(int i = 0 ; i < k+1;i++){
    		if(i <= size1 && k-i <= size2){
    			chooseKnums(nums1, i, chooseFrom1);
    			chooseKnums(nums2, k-i, chooseFrom2);
    			tempA = mergerTwoNums(chooseFrom1, i, chooseFrom2, k-i);
    			maxAns = compareTowNums(tempA, maxAns, k);
    		}
    	}
    	return maxAns;
    }
    
    /**
     * 从 nums中选择k个数，构成最大的数
     * @param nums
     * @param k
     * @param choose
     */
    public void chooseKnums(int []nums,int k,int choose[]){
    	int count = 0;
    	if(k==0)return;
    	for(int i = 0 ; i < nums.length;i++){
    		if(count ==0){
    			choose[count++] = nums[i];
    		}else{
    			while(count != 0 && nums[i] > choose[count-1] && (nums.length-i-1) >= (k-count)  ){
    				count--;
    			}
    			if(count < k)
    				choose[count++] = nums[i];
    		}
    	}
    }
    /**
     * 比较两个数组构成的数
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    int [] compareTowNums(int []nums1,int []nums2,int k){
    	if(nums1 == null)return nums2;
    	if(nums2 == null)return nums1;
    	int i =0;
    	while(i<k && nums1[i] == nums2[i]){
    		i++;
    	}
    	if(i ==k)return nums1;
    	return nums1[i] > nums2[i]? nums1:nums2;
    }
    
    /**
     * 合并，比如 6 0 7， 6 8 合并
     * @param chooseFrom1
     * @param s1
     * @param chooseFrom2
     * @param s2
     * @return
     */
    public int [] mergerTwoNums(int[]chooseFrom1,int s1,int[]chooseFrom2,int s2){
    	int k = s1 +s2; // 合并后的大小
    	int i = 0 ,j=0;
    	int count = 0;
    	int []ans = new int[k];
    	while(i < s1 && j < s2){
    		if(chooseFrom1[i] > chooseFrom2[j]){
    			ans[count++] = chooseFrom1[i++];
    		}else{
    			if(chooseFrom1[i] < chooseFrom2[j]){
    				ans[count++] = chooseFrom2[j++];
    			}else{ // 相等。
    				int tempi = i+1,tempj = j+1;
    				while(tempi < s1 && tempj < s2 && chooseFrom1[tempi] == chooseFrom2[tempj]){
    					tempi++;tempj++;
    				}
    				if(tempi == s1){
    					ans[count++] = chooseFrom2[j++];
    					continue;
    				}
    				if(tempj == s2){
    					ans[count++] = chooseFrom1[i++];
    					continue;
    				}
    				if( chooseFrom1[tempi] > chooseFrom2[tempj]){
    					ans[count++] = chooseFrom1[i++];
    				}else{
    					ans[count++] = chooseFrom2[j++];
    				}
    			}
    		}
    	}
    	while(i < s1){
    		ans[count++] = chooseFrom1[i++];
    	}
    	while(j < s2){
    		ans[count++] = chooseFrom2[j++];
    	}
    	return ans;
    }
}
