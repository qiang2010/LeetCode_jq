package qiang.leetcode;

public class MedianofTwoSortedArrays4 {

	
/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be 
 * 
 * 			O(log (m+n)).
 * 
 *   当样本数为奇数时,中位数=(N+1)/2 ; 
 *   当样本数为偶数时,中位数为N/2与1+N/2的均值 
 * 	
 */
	
    public  static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int size1 = nums1.length;
    	int size2 = nums2.length;
    	int len = size1 + size2;
    	double medianSum = 0;
    	boolean odd = false;
//    	int count = 0;
    	if(len % 2 == 0 ) {
    		odd = true;
    	}
    	
    	for( int i = 0 , j = 0 ;i< size1 &&  j< size2 ;){
    		if( nums1[i] < nums2[j]){
    			i++;
    		}else j++;
    		//if(i + j = )
    	}
    return 0.0;	
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
