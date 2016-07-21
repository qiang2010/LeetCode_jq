package qiang.leetcode5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class PascalsTriangle119 {
    public static  List<List<Integer>> generate(int numRows) {
    	
    	LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
    	if(numRows == 0) return ans;
    	List<Integer> row = new ArrayList<>(),lastRow;
    	row.add(1);
    	ans.addLast(row);
    	if(numRows == 1) return ans;
    	for(int i =1 ; i < numRows; i++){
    		row = new ArrayList<Integer>();
    		row.add(1);
    		lastRow = ans.get(i-1);
    		for(int j = 1; j < i;j++){
    			row.add(lastRow.get(j-1)+lastRow.get(j));
    		}
    		row.add(1);
    		ans.add(row);
    	}
    	return ans;
    }
	public static void main(String[] args) {
		
		PrintUtil.print2DList(generate(14));
	}

}
