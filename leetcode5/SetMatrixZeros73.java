package qiang.leetcode5;

import java.util.Arrays;
import java.util.HashSet;

import qiang.leetcode.util.PrintUtil;

public class SetMatrixZeros73 {

	
	
    public  static void setZeroes(int[][] matrix) {
     
    	if(matrix == null || 0 == matrix.length) return; 
    	
    	HashSet<Integer> rowZero = new HashSet<>();
    	HashSet<Integer> colZero = new HashSet<>();
    	
    	int row = matrix.length;
    	int col = matrix[0].length;
    	for(int i =0; i < row ; i++){
   			for(int j = 0 ; j < col; j++){
   				if(matrix[i][j]==0){
   					rowZero.add(i);
   					colZero.add(j);
   				}
   			}
    	}
    	for(int i:rowZero){
    		for(int k =0;k <col; k++)
    			matrix[i][k] =0;
    	}
    	for(int j:colZero){
			for(int k=0; k < row; k++)
				matrix[k][j]=0;
		}
    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] m = {{1,2,3},{0,0,0},{1,2,3}};
		setZeroes(m);
		//System.out.println(Arrays.toString(m));
		PrintUtil.printArray(m);
	}

}
