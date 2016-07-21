package qiang.indeedTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 int R = in.nextInt();
		 int C = in.nextInt();
		 StringBuilder sb = new StringBuilder();
		 for(int i =0;i<R;i++) sb.append(in.next());
		List<StringBuilder> allSb = new ArrayList<>();
		StringBuilder curSB = sb;
		allSb.add(curSB);
		int att = 0;
		LinkedList<Integer> allp= new LinkedList<>();
		for(int i =0;i<curSB.length();i++) if(curSB.charAt(i)=='?') allp.add(i);
		int attSize = allp.size();
		while(allp.isEmpty()==false){
			att = allp.getFirst();
			allp.removeFirst();
			List<StringBuilder> currr = new ArrayList<>();
			for(int i =0;i<allSb.size();i++){
				StringBuilder c = allSb.get(i);
				StringBuilder sbs = new StringBuilder(c);
				c.setCharAt(att, 'R');
				sbs.setCharAt(att, 'C');
				currr.add(c);
				currr.add(sbs);
			}
			allSb = currr;
		}		
		// allSb 是所有的可能
		double sum =0;
		for(StringBuilder ssb : allSb){
			int ccc = oneTable(R, C, ssb);
			sum+= ccc;
		}
		System.out.println((sum/Math.pow(2,attSize)));
	}
	static int oneTable(int R,int C,StringBuilder cur){
		int ans = 0;
		boolean [][]flag = new boolean[R][C];
		for(int i =0;i<R;i++){
			for(int j = 0 ; j < C;j++){
				if(!flag[i][j]){
					ans++;
					dfs(i, j, R, C, cur, flag);
				}
			}
		}
		return ans;
	}
	static void dfs(int i,int j,int R,int C, StringBuilder cur, boolean[][]flag){
		if(i==R)return;		
		if(j==C)return; // 这里写错了
		if(flag[i][j])return;
		flag[i][j] = true;
		int pos = i*C+j;
		char c = cur.charAt(pos);
		if(c=='R'){
			dfs(i, j+1, R, C, cur, flag);
		}else{
			dfs(i+1, j, R, C, cur, flag);
		}
	}
}
