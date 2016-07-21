package qiang.leetcode5;

public class RotateImage48 {

	
	
    public void rotate(int[][] matrix) {
    	int size = matrix.length;
    	// 首先上下对折
    	int temp ;
    	for(int i =0; i < size; i++){
    		for(int j =0; j< size/2; j++){
    			temp = matrix[j][i];
    			matrix[j][i] = matrix[size-1-j][i];
    			matrix[size-1-j][i]= temp;
    		}
    	}
    	
    	// 按照对角线对折
    	for(int i =0;i<size; i++){
    		for(int j = i+1 ; j<size; j++ ){
    			temp = matrix[i][j];
    			matrix[i][j] = matrix[j][i];
    			matrix[j][i] = temp;
    		}
    	}
    	
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m[][] = {{1,2},{3,4}};
		RotateImage48 ri = new RotateImage48();
		ri.rotate(m);
		for(int i = 0 ; i < m.length;i++){
			for(int j = 0 ; j < m.length ; j++)
				System.out.print(m[i][j]+" ");
		}
		System.out.println();
	}

}
