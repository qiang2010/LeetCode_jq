package qiang.leetcode6;

public class Find3NumberMoreThanQuarter {

	public static void main(String[] args) {
		
		Find3NumberMoreThanQuarter ff = new Find3NumberMoreThanQuarter();
		int []nums= {5,1,1,1,1,2,2,2,2,33333,3,6,7,6,6,6,6};
		ff.find(nums);
	}
	/**
	 * 
	 * 题目的意思是，给一个数组，数组中有三个元素出现的次数超过 1/4，找到这三个元素。
	 * 
	 * @param nums
	 */
	void find(int []nums){
		Integer []cand = new Integer[3];
		int []count = new int[3];
		count[0] = count[1] = count[2] = 0;
		cand[0] = cand[1] = cand[2] = null;
		boolean zeroFlag = false;
		boolean sameFlag = false;
		for(int i =0; i < nums.length;i++){
			// 判断是否已经存在
			sameFlag = false;
			for(int j = 0 ; j < 3;j++){
				if(cand[j]!=null && cand[j] ==nums[i]){
					count[j]++;
					sameFlag = true;
					break;
				}
			}
			// 如果没有相同的
			if(!sameFlag){
				// 将其中一个计数为0的替换了。
				zeroFlag = false;
				for(int j =0;j<3;j++){
					if(count[j]==0){
						count[j] =1;
						cand[j] = nums[i];
						zeroFlag = true;
						break;
					}
				}
				// 如果不存在计数为0的
				if(!zeroFlag){
					for(int j =0;j<3;j++) count[j]--;
				}
			}
		}
		for(int j =0;j<3;j++)System.out.println(cand[j]);
	}
	
}
