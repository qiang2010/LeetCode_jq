package qiang.heapSort;

public class MaxHeapSort {

	public static void main(String[] args) {
		MaxHeapSort maxs = new MaxHeapSort();
		int []nums = {6,5,2,4,3,1};
		maxs.heapSort(nums);
		for(int a:nums)System.out.println(a);
	}
	
	void heapSort(int nums[]){
		int size = nums.length;
		this.buildHeap(nums, 0,size-1);
		for(int a:nums)System.out.print(a+"\t");
		System.out.println();
		for(int i = size-1;i>0;i--){
			swap(nums, i, 0);
			this.adjust(nums, 0, i-1);
			for(int a:nums)System.out.print(a+"\t");
			System.out.println();
		}
	}
	void swap(int []nums, int i ,int j){
		int t = nums[i];
		nums[i] = nums[j];
		nums[j]= t;
	}
	
	/**
	 * 将 nums中从begin到end的元素构建成堆，end是最后一个元素
	 * @param nums
	 * @param begin
	 * @param end
	 */
	void buildHeap(int []nums, int begin,int end){
		int lastIn = (end-1)/2;
		while(lastIn >= begin){
			this.adjust(nums, lastIn--, end);
		}
	}
	
	/**
	 * 
	 * @param nums
	 * @param begin   要调整的起始位置
	 * @param end	  要调整的结束位置，包括end
	 */
	void adjust(int [] nums,int begin, int end){
		int len = nums.length;
		if(begin < 0 || end <0 || begin> len-1 || end > len-1 || begin > end) return;
		while(begin < end){
			int left = begin*2+1;
			int right = left+1;
			if(left > end) return;
			// 先找到left 和right 之间较大的，以及index
//			int large = nums[left]; // 开始的时候这里使用了一个large，结果下面在判断时候，
			// 用了nums[begin] < nums[large]，导致出错了，不细心
			int largeIndex = left;  
			if(right <= end && nums[right] > nums[left]){
//				large = nums[right];
				largeIndex = right;
			}
			if(nums[begin] < nums[largeIndex]){
				int b = nums[begin];
				nums[begin] = nums[largeIndex];
				nums[largeIndex] = b;
				begin = largeIndex;
			}else return;
		}
		
	}
	
}
