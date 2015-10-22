package qiang.leetcode;

public class SearchA2DMatrixII240 {
    public static void main(String[] args) {
		
    	int [][] matrix = {{1, 4,7, 11,15},
    			  {2,   5, 8, 12, 19},
    			  {3,   6,  9, 16, 22},
    			  {10, 13, 14, 17, 24},
    			  {18, 21, 23, 26, 30}};
    	
    	System.out.println(new SearchA2DMatrixII240().searchMatrix(matrix, 3));
    	System.out.println(new SearchA2DMatrixII240().searchMatrix2(matrix, 3));
	}
    
    
    public boolean searchMatrix2(int[][] matrix, int target) {
    
    	if(matrix == null )return false;
		int row = matrix.length;
		if(row == 0) return false;
		int col = matrix[0].length;
    	
		int i =0,j = col-1;
		while(i<row && j>-1){
			if(matrix[i][j] == target) return true;
			if(matrix[i][j] < target){
				i++;
			}else{
				j--;
			}
		}
		return false;
    }
    
	
	public boolean searchMatrix(int[][] matrix, int target) {
     
		if(matrix == null )return false;
		int row = matrix.length;
		if(row == 0) return false;
		int col = matrix[0].length;
		
    	if(search(matrix, 0, col-1, target))return true;
    	return false;
    }
	
	boolean search(int[][]matrix,int i,int j,int target){
		
		if(i> matrix.length-1||j<0)return false;
		if(matrix[i][j] == target) return true;
		if(matrix[i][j] > target){
			if(search(matrix, i, j-1, target))return true;
		}else{
			if(search(matrix, i+1, j, target))return true;
		}
		return false;
	}
}
