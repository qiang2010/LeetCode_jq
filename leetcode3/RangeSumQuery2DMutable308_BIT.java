package qiang.leetcode3;

public class RangeSumQuery2DMutable308_BIT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]nums = {{3, 0, 1, 4, 2},
			      {5, 6, 3, 2, 1},
			      {1, 2, 0, 1, 5},
			      {4, 1, 0, 1, 7},
			      {1, 0, 3, 0, 5}};
		RangeSumQuery2DMutable308_BIT rr = new RangeSumQuery2DMutable308_BIT(nums);
		System.out.println(rr.sumRange(2, 1, 4, 3));
	}


    /**
     *  这里采用树状数组来求解。二维BIT
     * 
     * */ 
     int [][]BIT;
     int row,col;
	int nums[][];
	public RangeSumQuery2DMutable308_BIT(int[][] nums) {
        if(nums ==null || nums.length == 0)return;
        
        row = nums.length;
        col = nums[0].length;
        BIT = new int[row+1][col+1];
        this.nums = new int[row][col];
        // 构建树状数组
        for(int i = 0;i<row;i++){
        	for(int j = 0;j<col;j++)
        		update(i,j,nums[i][j]);
        }
	}
    int lowbit(int x){
        return x&(-x);
    }
    void update(int i,int j, int val) {
    	
        int change = val - nums[i][j];
        nums[i][j] = val;
        for(int n = i+1;n<row+1;n+=lowbit(n)){
        	for(int m = j+1;m < col+1;m+=lowbit(m)){
        		BIT[n][m]+= change;
        	}
        }
    }

    public int sumRange(int row1, int col1, int row2, int col2) {
    
    	return sumFrom00(row2,col2) - sumFrom00(row2,col1-1)-sumFrom00(row1-1,col2)+ sumFrom00(row1-1,col1-1);
    }
    int sumFrom00(int i,int j){
        int ans = 0;
        for(int n = i+1;n>0 ;n-=lowbit(n)){
        	for(int m = j+1;m >0;m-=lowbit(m)){
        		ans+= BIT[n][m];
        	}
        }
        return ans;
    }
}
