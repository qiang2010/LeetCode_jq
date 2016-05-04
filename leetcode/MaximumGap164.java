package qiang.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class MaximumGap164 {
	  
	
	public int maximumGap(int[] nums) {
		
		if(nums == null || nums.length <2) return 0;
		
		if(nums.length ==2) return Math.abs(nums[0]-nums[1]);
		int bucketSize ;
		int bucketNum;
		int maxNum = max(nums,0,nums.length-1);
		int minNum = min(nums,0,nums.length-1);
		int ans = 0;
		bucketSize = (int)Math.ceil((maxNum - minNum)*1.0/(nums.length));
		if(bucketSize == 0)return 0;
		bucketNum = (maxNum - minNum)/bucketSize+1;
		
		ArrayList<ArrayList<Integer> >  buckets = new ArrayList<ArrayList<Integer> >();
		for(int i = 0 ; i < bucketNum; i++){
			buckets.add(null);
		}
		
		ArrayList<Integer> tempB;
		for(int i = 0 ; i < nums.length; i++){
			int buck = (nums[i]- minNum)/bucketSize;
			if((tempB  = buckets.get(buck))==null){
				tempB = new ArrayList<Integer>();
				buckets.set(buck, tempB);
			} 
			tempB.add(nums[i]);
		}
		ArrayList<Integer> lastBuctket = buckets.get(0);
		ArrayList<Integer> cur;
		for(int i = 1; i <bucketNum;i++){
			cur = buckets.get(i);
			while(cur == null && ++i < bucketNum){
				cur = buckets.get(i);
			}
			if(cur == null) break;
			int tempMax = Collections.max(lastBuctket);
			int tempMin = Collections.min(cur);
			if(tempMin- tempMax > ans){
				ans = tempMin- tempMax;
			}
			lastBuctket  = cur;
		}
		return ans;
	}
	
	int max(int []nums,int begin,int end){
		int ans = nums[begin];
		for(int i =begin+1;i <end+1;i++){
			if(nums[i] > ans){
				ans = nums[i];
			}
		}
		return ans;
	}
	int min(int []nums,int begin,int end){
		int ans = nums[begin];
		for(int i =begin+1;i <end+1;i++){
			if(nums[i] < ans){
				ans = nums[i];
			}
		}
		return ans;
	}
	
	public int maximumGap2(int[] nums){
		
		if(nums == null || nums.length <2) return 0;
		
		if(nums.length ==2) return Math.abs(nums[0]-nums[1]);
		int bucketSize ;
		int bucketNum;
		int maxNum = max(nums,0,nums.length-1);
		int minNum = min(nums,0,nums.length-1);
		int ans = 0;
		bucketSize = (int)Math.ceil((maxNum - minNum)*1.0/(nums.length));
		if(bucketSize == 0)return 0;
		bucketNum = (maxNum - minNum)/bucketSize+1;
		
		int maxB[] = new int[bucketNum];
		int minB[] = new int[bucketNum];
		for(int i = 0 ; i < bucketNum; i++){
			 maxB[i] = Integer.MIN_VALUE;
			 minB[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0 ; i < nums.length; i++){
			int buck = (nums[i]- minNum)/bucketSize;
			maxB[buck] = nums[i] > maxB[buck]  ? nums[i]:maxB[buck] ;
			minB[buck] = nums[i] > minB[buck]? minB[buck]: nums[i];
		}
		int lastMax = maxB[0];
//		int lastMin = minB[0];
		int curMax,curMin;
		for(int i = 1; i <bucketNum;i++){
			curMax = maxB[i];
			curMin = minB[i];
			while(curMax == Integer.MIN_VALUE && ++i < bucketNum){
				curMax = maxB[i];
				curMin = minB[i];
			}
			if(i > bucketNum-1) break;
 
			if(curMin - lastMax > ans){
				ans = curMin - lastMax;
			}
			lastMax = curMax;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		
		int []nums={1,1,1,1};
		System.out.println(new MaximumGap164().maximumGap2(nums));
		
	}
}
