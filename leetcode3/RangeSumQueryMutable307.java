package qiang.leetcode3;

public class RangeSumQueryMutable307 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {1,4,5};
		RangeSumQueryMutable307 rr = new RangeSumQueryMutable307(nums);
		System.out.println(rr.sumRange(0, 1));
		rr.update(1, 10);
		System.out.println(rr.sumRange(0, 2));
	}

	 
	int []segTree;
	int nums[];
	public RangeSumQueryMutable307(int[] nums) {
		if(nums == null){
			segTree = null;
			return ;
		}
		int len = nums.length;
		if(len ==0){
		     segTree =  new int[0];
		     return ;
		}
		segTree = new int[len << 2];
		this.nums = nums;
		build(0,len-1,1);
	}

	void build(int begin,int end,int root){
		
		if(begin == end){
			segTree[root] = nums[begin];return;
		}
		int mid = (begin+end)>>1;
		build(begin,mid,root<<1);
		build(mid+1,end,root<<1|1);
		segTree[root] = segTree[root<<1] + segTree[root<<1|1]; 
	}
	 
	void update(int i, int val) {
	       
		updateInt(i,val,0,nums.length-1,1);
	 
	}
	void updateInt(int i,int val,int left,int right,int root){
		
		if(left == right){
			segTree[root] = val;return;
		}
		int mid = (left + right ) >>1;
		if(i <= mid){
			updateInt(i,val,left,mid,root<<1);
		}else{
			updateInt(i,val,mid+1,right,root<<1|1);
		}
		segTree[root] = segTree[root<<1] + segTree[root<<1|1]; 
	}

	 
	public int sumRange(int i, int j) {
	        
		return sum(i,j,0,nums.length-1,1);
	 
	}
	int sum(int i ,int j ,int begin,int end,int root){
		
		if(i <= begin && j >= end) return segTree[root];
		int mid = (begin + end) >>1;
		int re=0;
		if(i<=mid){
			re += sum(i,j,begin,mid,root<<1);
		}
		if(j > mid){
			re += sum(i,j,mid+1,end,root <<1|1);
		}
		return re;
	}
}
