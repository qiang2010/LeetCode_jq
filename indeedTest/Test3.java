package qiang.indeedTest;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		boolean [][]table = new boolean[6][6];
		int rowCount [] = new int[6];
		int colCount [] = new int[6];
		for(int i = 0 ; i < 6;i++){
			String cur = in.next();
			for(int j = 0 ; j < 6;j++){
				if(cur.charAt(j) == 'o'){
					table[i][j] = true;
					rowCount[i]++;
					colCount[j]++;
				}
			}
		}
		for(int i = 0;i<6;i++){
			if(rowCount[i]>3 || colCount[i] > 3) {
				System.out.println(0);
				return;
			}
		}
		int [][] allPos = allPos();
		// 一行一行的处理
		dfs(allPos, 0, table, rowCount, colCount);
		System.out.println(countAll);
	}
	static int countAll = 0;
	static void dfs(int [][]allPos,int r,boolean [][]table,int []rowCount,int []colCount){
		if(r == 6){
			for(int i =0;i<6;i++){
				if(rowCount[i] !=3 || colCount[i] !=3) return;
			}
			countAll++; return;
		}
		if(rowCount[r] == 3)  {
			dfs(allPos, r+1, table, rowCount, colCount);
			return;
		} // 要处理的一行已经有三个了。
		// 一行选择三个数
		int [] curp ;
		for(int p = 0;p<20;p++){
			curp = allPos[p];
			if(colCount[curp[0]] == 3 &&  !table[r][curp[0]]) continue; 
			if(colCount[curp[1]] == 3 &&  !table[r][curp[1]]) continue; 
			if(colCount[curp[2]] == 3 &&  !table[r][curp[2]]) continue; 
			if(!table[r][curp[0]]){
				rowCount[r]++;
				colCount[curp[0]]++;
			}
			if(!table[r][curp[1]]){
				rowCount[r]++;
				colCount[curp[1]]++;
			}
			if(!table[r][curp[2]]){
				rowCount[r]++;
				colCount[curp[2]]++;
			}
			dfs(allPos, r+1, table, rowCount, colCount);
			if(!table[r][curp[0]]){
				rowCount[r]--;
				colCount[curp[0]]--;
			}
			if(!table[r][curp[1]]){
				rowCount[r]--;
				colCount[curp[1]]--;
			}
			if(!table[r][curp[2]]){
				rowCount[r]--;
				colCount[curp[2]]--;
			}
		}
	}
	
	
	static int[][] allPos(){
		int [][]ans = new int[20][3];
		int c = 0;
		for(int i =0;i<6;i++)
			for(int j = i+1;j<6;j++)
				for(int k = j+1;k<6;k++){
					ans[c][0] = i;
					ans[c][1] = j;
					ans[c][2] = k;
					c++;
				}
		return ans;
	}
	
	
}
