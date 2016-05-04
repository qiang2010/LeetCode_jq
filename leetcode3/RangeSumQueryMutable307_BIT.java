package qiang.leetcode3;

public class RangeSumQueryMutable307_BIT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {7,2,7,2,0};
		RangeSumQueryMutable307_BIT rr = new RangeSumQueryMutable307_BIT(nums);
		rr.update(4, 6);
		rr.update(0, 2);
		rr.update(0, 9);
		rr.update(1, 2);
		System.out.println(rr.sumRange(0, 2));
	}


    /**
     *  这里采用树状数组来求解。
     * 
     * */ 
     int []BIT;
     int size;
	int nums[];
	public RangeSumQueryMutable307_BIT(int[] nums) {
        if(nums ==null || nums.length == 0)return;
        BIT = new int[nums.length+1];
        this.nums = nums;
        size = nums.length;
        // 构建树状数组
        for(int i = 1;i<size+1;i++){
            int low = i - lowbit(i);
            BIT[i] = nums[i-1];
            for(int j = i-1;j>low;j--) BIT[i]+=nums[j-1];
        }
	}

    int lowbit(int x){
        return x&(-x);
    }
    void update(int i, int val) {
    	
        int change = val - nums[i];
        nums[i] = val;
        int k = i+1;
         while( k < size+1){
             BIT[k] +=  change;
             k+=lowbit(k);
         }  
    }

    public int sumRange(int i, int j) {
        return sumFrom0(j) - sumFrom0(i-1); // 我去，这里应该是-1
    }
    int sumFrom0(int i){
        int ans = 0;
        int k = i+1;
        while(k > 0){
            ans += BIT[k];
            k -= lowbit(k);
        }
        return ans;
    }
}
