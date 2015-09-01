package qiang.leetcode;

import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class Combinations77 {

	
	
	
    public static  List<List<Integer>> combine(int n, int k) {
      
    	
    	
    	List<List<Integer>> ans = new LinkedList<List<Integer>>();
    	if(k > n) return ans;
    	List<Integer> tempAns;
    	int [] tempPos = new int[k];
    	for(int i =0 ; i < k; i++){
    		tempPos[i] = i;
    	}
    	
    	while(true){
    		tempAns = new LinkedList<Integer>();
    		for(int j :tempPos){
    			tempAns.add(j+1);
    		}
    		ans.add(tempAns);
    		
    		
    		int m = k-1;
    		int mP = n-1;
    		while(m>-1 && mP >-1 && tempPos[m] == mP ){
    			m--;
    			mP--;
    		}
    		if(m == -1)return ans;
    		tempPos[m]++;
    		for(int mk = m+1; mk < k ;mk++){
    			tempPos[mk] = tempPos[mk-1]+1;
    		}
    		
    	}
    }	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrintUtil.print2DList(combine(5, 4));
		}

}
