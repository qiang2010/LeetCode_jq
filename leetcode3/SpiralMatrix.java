package qiang.leetcode3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    
	
	public static  List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new LinkedList<>();
		if(matrix == null || matrix.length == 0 || matrix[0].length==0) return ans; 
		int x =0, y=0;
		int len =matrix.length, width=matrix[0].length;
		while( len > 0 && width >0 ){
			
			if(len == 1){
				for(int i = 0 ; i < width;i++){
					ans.add(matrix[x][y++]);
				}
				break;
			}else{
				if(width == 1){
					for(int j=0;j<len;j++){
						ans.add(matrix[x++][y]);
					}
					break;
				}
			}
			
			for(int i = 0 ; i < width-1; i++){
				ans.add(matrix[x][y++]);
			}
			
			for(int i = 0  ; i < len-1  ; i++){
				ans.add(matrix[x++][y]);
			}
		
			for(int j = 0 ; j < width-1 ; j++ ){
				ans.add(matrix[x][y--]);
			}
			
			for(int j = 0 ; j < len-1 ; j++ ){
				ans.add(matrix[x--][y]);
			}
			x++;
			y++;
			len-=2;
			width-=2;
		}
    	return ans;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     int [][]matrix = {{1},{2},{3}};
		
		List<Integer> ans = spiralOrder(matrix);
		System.out.println(ans.toString());
	}

}
