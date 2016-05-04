package qiang.leetcode3;

public class SpiralMatrixII59 {

    public int[][] generateMatrix(int n) {
     
    	int [][] ans = new int[n][n];
    	int co = 1;
    	
    	int x = 0,y=0,s= n-1;
    	while(s >=0){
    		if(s==0){
    			ans[x][y] = co;
    		}
    		for( int i =0;i < s; i++){
    			ans[x][y++] = co;
    			co++;
    		}
    		
    		for( int i =0;i < s; i++){
    			ans[x++][y] = co;
    			co++;
    		}
    		for( int i =0;i < s; i++){
    			ans[x][y--] = co;
    			co++;
    		}
    		for( int i =0;i < s; i++){
    			ans[x--][y] = co;
    			co++;
    		}
    		s-=2;
    		x++;
    		y++;
    	}
    	return ans;
    }
    	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrixII59 sm = new SpiralMatrixII59();
		int n = 4;
		int [][] ans = sm.generateMatrix(n);
		
		for( int i =0; i < n ; i ++){
			for( int j =0; j < n ; j++){
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}

}
