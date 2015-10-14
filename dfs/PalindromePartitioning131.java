package qiang.dfs;

import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class PalindromePartitioning131 {

	  
	
	public List<List<String>> partition(String s) {
		
		List<List<String>> ans = new LinkedList<List<String>>();
				
		int size = s.length();
		int [][]flag = new int[size][size];
		for(int i =0;i<size; i++)
			flag[i][i] = 1;
		dfs(ans, new LinkedList<String>(), s, 0, flag);
		return ans;
	}
	private void dfs(List<List<String>> ans,LinkedList<String> partAns,String s,int index,int[][]flag){
		
		if(index > s.length()-1){
			LinkedList<String> temp = new LinkedList<String>();
			temp.addAll(partAns);
			ans.add(temp);
			return ;
		}
		String tempS;
		for(int len = 1; len < s.length()-index+1;len++){
			tempS = s.substring(index,index+len);
			if(flag[index][index+len-1] == 0){
				flag[index][index+len-1] = isPal(tempS);
			}
			if(flag[index][index+len-1] < 0)continue;
			partAns.addLast(tempS);
			dfs(ans, partAns, s, index+len, flag);
			partAns.removeLast();
		}
		
	}
	
	int  isPal(String s){
		if(s == null) return -1;
		if(s.length() ==1) return 1;
		int size = s.length();
		for(int i =0;i < size/2+1; i++){
			if(s.charAt(i) != s.charAt(size-1-i))return -1;
		}
		return 1;
	}
	
	public static void main(String[] args) {
		List<List<String>> ans = 
		new PalindromePartitioning131().partition("aba");
		PrintUtil.print2DList(ans);
	}
}
