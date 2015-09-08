package qiang.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class PascalsTriangleII120 {
	 public static List<Integer> getRow(int rowIndex) {
    	
		 List<Integer> ans = new ArrayList<>(rowIndex);
		// if(rowIndex == 0) return ans;
		 ans.add(1);
		 if(rowIndex == 0) return ans;
		// int []ansNums = new int [rowIndex];
		 for (int i = 1; i < rowIndex+1; i++) {
			//ansNums[i] =1;
			ans.add(1);
			for(int j=i-1; j>0;j--){
			//	ansNums[j] = ansNums[j]+ansNums[j-1];
				ans.set(j, ans.get(j)+ans.get(j-1));
			}
		}
		 return ans;
    }
	public static void main(String[] args) {
		
		 System.out.println(getRow(1));
	}

}
