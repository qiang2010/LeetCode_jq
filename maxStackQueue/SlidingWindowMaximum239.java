package qiang.maxStackQueue;

public class SlidingWindowMaximum239 {

	
	/**
	 *  下面这种方法超时了。。。
	 * @param nums
	 * @param k
	 * @return
	 */
    public static int[] maxSlidingWindow(int[] nums, int k) {
    		if(nums.length==0 || k==0)return new  int[0];
    		if(k> nums.length) return new int[0];
    	    int res[] = new int[nums.length-k+1];
	        MaxQueue maxQueue = new MaxQueue();
	        for(int i = 0 ; i < k;i++){
	        	maxQueue.push(nums[i]);
	        }
	        
	        res[0] = maxQueue.max();
	        for(int i=k; i< nums.length;i++){
	        	maxQueue.pop();
	        	maxQueue.push(nums[i]);
	        	res[i-k+1] = maxQueue.max();
	        }
	        return res;
	}
	
 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]={1,3,1,2,0,5};
		int []res = maxSlidingWindow(nums,3);
		for(int x:res){
			System.out.print(x+" ");
		}
	}

}
