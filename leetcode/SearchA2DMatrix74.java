package qiang.leetcode;

public class SearchA2DMatrix74 {

	
    public static boolean searchMatrix(int[][] matrix, int target) {
     
    	int row = matrix.length;
    	int col = matrix[0].length;
 
    	int []firstCol = new int[row+2];
    	// 将第一列拿出。
    	firstCol[0] = Integer.MIN_VALUE;
    	for(int i =1 ;i < row; i++){
    		firstCol[i] = matrix[i][0];
    	}
   		firstCol[row] = Integer.MAX_VALUE;

   		int rowPos = binarySearch(firstCol, target);
 
    	if(firstCol[rowPos] == target)
    		return true;
    	int colPos = binarySearch(matrix[rowPos-1], target);
    	if(colPos >= col ) return false;
    	if((matrix[rowPos-1][colPos] == target)) return true;	
    	return false;
    	
    }
    
    
    // 如果找到当前值就返回当前值的位置，否则就返回刚好比它大的位置。
    private static  int binarySearch(int[]input,int target){
    	int s = 0;
    	int e = input.length-1;

    	int mid ;
    	while( s <= e){
    		mid = (s + e )/2;
    		if(input[mid] == target)
    			return mid;
    		
    		if(target < input[mid]){
    			e = mid-1;
    		}else{
    			s = mid+1;
    		}
    	}
    	 return s;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] a = {{1}};//,3,5,7},{10,11,16},{23,30,34
		System.out.println(searchMatrix(a, 2));
		//System.out.println(binarySearch(a[0], 8));
	}

}
