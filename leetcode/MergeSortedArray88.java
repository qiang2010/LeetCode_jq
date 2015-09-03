package qiang.leetcode;

public class MergeSortedArray88 {

	
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2 == null) return;
        if(nums1 == null) {
        	nums1 = nums2;
        	return ;
        }
        int sizeNums1 = nums1.length;
        if(m+n <sizeNums1) return;
        
        int lastPos = m+n-1;
        int cur1Pos = m-1;
        int cur2Pos = n-1;
        while(cur1Pos> -1  && cur2Pos >-1){
        	if(nums1[cur1Pos] > nums2[cur2Pos]){
        		nums1[lastPos--] = nums1[cur1Pos--] ;
        	}else{
        		nums1[lastPos--] = nums2[cur2Pos--] ;
        	}
        }
        while(cur1Pos> -1){
        	nums1[lastPos--] = nums1[cur1Pos--] ;
        }
        while(cur2Pos> -1){
        	nums1[lastPos--] = nums2[cur2Pos--] ;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
