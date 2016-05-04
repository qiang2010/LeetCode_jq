package qiang.leetcode3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Triangle120 {

	
	public static int minimumTotal(List<List<Integer>> triangle) {
	
		if(triangle == null) return 0;
		int row = triangle.size();
		if(row == 0) return 0;
		int []last = new int[row];
		int tempSize;
		List<Integer > tempRow;
		last[0] = triangle.get(0).get(0);
		for(int i=1;i<row;i++){
			tempRow = triangle.get(i);
			tempSize = tempRow.size();
			// 最后一个
			last[tempSize-1] = tempRow.get(tempSize-1) + last[tempSize-2];
			// 中间的部分 j j-1  => j
			for(int j=tempSize-2;j > 0;j--){
				last[j] =(last[j-1] > last[j]) ? last[j]+ tempRow.get(j):last[j-1]+tempRow.get(j);
			}
			// 最后一个数 前提是 tempSize >1
			last[0]+=tempRow.get(0);
		}
		int min=Integer.MAX_VALUE;
		for(int i =0;i<row;i++){
			min = min > last[i]? last[i]:min;
		}
			
		return min;
	}
	
	public static void main(String[] args) {
		
		List<List<Integer>> triangle  = new LinkedList<List<Integer>>();
		int []nums0 = {1};
		int []nums1 = {2,3};
		List<Integer> row0 = new ArrayList<>();
		row0.add(1);
		
		List<Integer> row1 = new ArrayList<>();
		row1.add(2);
		row1.add(3);
		triangle.add(row0);
		triangle.add(row1);
		System.out.println(minimumTotal(triangle));
		
		
	}

}
