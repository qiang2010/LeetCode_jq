package qiang.leetcode5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q3Sum15 {

   public static List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> ans = new ArrayList< List<Integer>>();
       Set<Integer> removeDup = new HashSet<Integer>();
       if(nums == null || nums.length < 3 ) return ans;
	   int size = nums.length;
	   for( int i = 0 ; i < size; i++){
		   for(int j = i+1 ; j < size; j++){
			   for( int k = j+1; k< size; k++){
				   if(nums[i] + nums[j]+ nums[k] == 0){
					   List<Integer> li = new ArrayList<Integer>();
					   li.add(nums[i]);
					   li.add(nums[j]);
					   li.add(nums[k]);
					   Collections.sort(li);
					   int key = li.get(0)*100 + li.get(1)*10 + li.get(2); 
					   if(!removeDup.contains(key)){
						   ans.add(li);
						   removeDup.add(key);
					   }
				   }
			   }
		   }
	   }
	   return ans;
   }	
   /**
    * 1.将数组排序，升序排列
    * 2.a 遍历 数组a[0]....a[n-1];    
    * 3.当 a=a[i]  时   后面的问题 就是 :  a[i+1] 到 a[n-1]中  b+c =-a  （编程之美 2.12 快速寻找满足条件的两个数  ）      
    * 记 b=a[j]=a[i-1]     c=a[k]=a[n-1]   
    * 若 b+c  < -a ，j++;   说明需要b+c更大一些，由于是按照升序排列，所以j++，这样a[j]就会更大
    * b+c > -a  ，k--;     说明需要b+c更小一些，由于是按照升序排列，所以k--，这样a[k]就会变小  
    * b+c=-a 记录下来，并i++;
    * 4.还有一个问题 就是unique triplet,   所以 a=a[i] 要判断是否和a[i-1]相等，若相等，子问题已经解答。
    *  也要判断 b和c  是否和之前的相同，若相同，就已经判断过了。
    * @param nums
    * @return
    */
   public static List<List<Integer>> threeSum2(int[] nums) {
       List<List<Integer>> ans = new ArrayList< List<Integer>>();
       if(nums == null || nums.length < 3 ) return ans;
	   int size = nums.length;
	   int j,k;
	   int cur,partSum;
	   Arrays.sort(nums);
	   ArrayList<Integer> list ;
	   for( int i = 0 ; i < size; i++){
		   cur = -nums[i];
		   j = i+1;
		   k=size-1;
		   if(i!=0 && nums[i]==nums[i-1]){
			   continue;
		   }
		   while(j<k){
			   partSum = nums[j]+nums[k];
			   if(partSum == cur){
				   list = new ArrayList<Integer>();
				   list.add(nums[i]);
				   list.add(nums[j]);
				   list.add(nums[k]);
				   System.out.println(nums[i]+" "+nums[j]+" "+nums[k]+" ");
				   ans.add(list); 
				   j++;
				   if(nums[j]==nums[j-1])continue;
				   //break;   // 找到一个匹配，其他的肯定不会在匹配上了
			   }else{
				   if(partSum < cur ) j++;
				   else k--;
			   }
		   }
	   }
	   return ans;
   }	
   
   
   /**
    *  上面 threeSum2 中的bug修改
    * @param nums
    * @return
    */
   
   public static List<List<Integer>> threeSum3(int[] nums) {
       List<List<Integer>> ans = new ArrayList< List<Integer>>();
       Set<Integer> removeDup = new HashSet<Integer>();
       if(nums == null || nums.length < 3 ) return ans;
	   int size = nums.length;
	   int j,k;
	   int cur,partSum;
	   Arrays.sort(nums);
	   ArrayList<Integer> list ;
	   for( int i = 0 ; i < size; i++){
		   cur = -nums[i];
		   j = i+1;
		   k=size-1;
		   if(i!=0 && nums[i]==nums[i-1]){
			   continue;
		   }
		   while(j<k){
			   while(j-1>i&& j<k && nums[j] == nums[j-1])j++;
			   while(k+1<size-1 && j<k && nums[k] == nums[k+1]) k--;
			   if(j ==k )break; // 这个时候j和k的值可能会越界
			   partSum = nums[j]+nums[k];
			   if(partSum == cur){
				   list = new ArrayList<Integer>();
				   list.add(nums[i]);
				   list.add(nums[j]);
				   list.add(nums[k]);
				   System.out.println(nums[i]+" "+nums[j]+" "+nums[k]+" ");
				   ans.add(list); 
				   j++;
				   //if(nums[j]==nums[j-1])continue;
				   //break;   // 找到一个匹配，其他的肯定不会在匹配上了
			   }else{
				   if(partSum < cur ) j++;
				   else k--;
			   }
		   }
	   }
	   return ans;
   }
   
   /**
    *  上面threeSum3 提交后仍然超时。。下面继续修改。
    * @param nums
    * @return
    */
   public static List<List<Integer>> threeSum4(int[] nums) {
       List<List<Integer>> ans = new ArrayList< List<Integer>>();
       Set<Integer> removeDup = new HashSet<Integer>();
       if(nums == null || nums.length < 3 ) return ans;
	   int size = nums.length;
	   int j,k;
	   int cur,partSum;
	   Arrays.sort(nums);
	   ArrayList<Integer> list ;
	   for( int i = 0 ; i < size; i++){
		   cur = -nums[i];
		   j = i+1;
		   k=size-1;
		   if(i!=0 && nums[i]==nums[i-1]){
			   continue;
		   }
		   while(j<k){
			   
			   if(j-1>i && nums[j] == nums[j-1]){
				   j++;
				   continue;
			   }
			   if(k+1<size-1 && nums[k] == nums[k+1]) {
				   k--;
				   continue;
			   }
//			   if(j ==k )break; // 这个时候j和k的值可能会越界
			   partSum = nums[j]+nums[k];
			   if(partSum == cur){
				   list = new ArrayList<Integer>();
				   list.add(nums[i]);
				   list.add(nums[j]);
				   list.add(nums[k]);
				   System.out.println(nums[i]+" "+nums[j]+" "+nums[k]+" ");
				   ans.add(list); 
				   j++;
				   //if(nums[j]==nums[j-1])continue;
				   //break;   // 找到一个匹配，其他的肯定不会在匹配上了
			   }else{
				   if(partSum < cur ) j++;
				   else k--;
			   }
		   }
	   }
	   return ans;
   }
   /*
    * threeSum2是target为0，3是给定target
    * 在nums数组从begin开始到end位置之间（不包括end）的3 sum问题。
    * 输入的数组是已经排序好的。
    */
   public static List<List<Integer>> threeSum5(int[] nums,int begin ,int end,int target) {
       List<List<Integer>> ans = new ArrayList< List<Integer>>();
       if(nums == null || nums.length < 3 ) return ans;
	   int j,k;
	   int cur,partSum;
//	   Arrays.sort(nums);
	   ArrayList<Integer> list ;
	   for( int i = begin ; i < end; i++){
		   cur = target-nums[i];
		   j = i+1;
		   k=end-1;
		   if(i!=begin && nums[i]==nums[i-1]){
			   continue;
		   }
		   while(j<k){
			   
			   if(j-1>i && nums[j] == nums[j-1]){
				   j++;
				   continue;
			   }
			   if(k+1<end-1 && nums[k] == nums[k+1]) {
				   k--;
				   continue;
			   }
//			   if(j ==k )break; // 这个时候j和k的值可能会越界
			   partSum = nums[j]+nums[k];
			   if(partSum == cur){
				   list = new ArrayList<Integer>();
				   list.add(nums[i]);
				   list.add(nums[j]);
				   list.add(nums[k]);
				  // System.out.println(nums[i]+" "+nums[j]+" "+nums[k]+" ");
				   ans.add(list); 
				   j++;
				   //if(nums[j]==nums[j-1])continue;
				   //break;   // 找到一个匹配，其他的肯定不会在匹配上了
			   }else{
				   if(partSum < cur ) j++;
				   else k--;
			   }
		   }
	   }
	   return ans;
   }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int nums[] = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		//int nums[] = {-3,-12,-3,-9,14,4,8,-4,11,4,7,-8,-5,4,7,-12,2,9,6,-12,8,-5,-14,5,3,11,14,-6,-5,10,-8,0,6,5,6,5,-6,-9,-13,12,2,1,-10,13,13,4,-14,0,-2,0,-5,13,10,-12,-5,-9,-15,-13,-8,-13,12,-1,-6,3,11,7,-14,-9,14,10,10,-7,-4,-15,-9,-6,4,-15,2,10,-8,12,0,9,-14,11,-15,8,13,14,10,2,-9,-10,13,-13,12,14,-15,3,1,11,12,12,11,10};
		int nums[]=  {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		Arrays.sort(nums); 
		List< List<Integer>> ans = threeSum5(nums,0,nums.length,0); 
	}

}
