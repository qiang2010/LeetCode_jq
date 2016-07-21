package qiang.interview.goolge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import qiang.util.FileUtil;

public class CountryLeaderA {

	public static void main(String[] args) {
		String path = "E:\\googlejam\\";
		int aNun = 3;
		String sm = "A-small-attempt0.in";
		String big = "A-large.in";
		int base= 1000000007 ;
		String test = "1.txt";
		FileUtil file = new FileUtil(path+big);
//		FileUtil file = new FileUtil(path+test);
//		FileUtil file = new FileUtil(path+sm);
		FileUtil ansFile = new FileUtil(path+"Alarget.out");
//		FileUtil ansFile = new FileUtil(path+"sma.out");
//		Scanner in = new Scanner(System.in);
		int size = Integer.parseInt(file.readLine());
//		int size = in.nextInt();
		for(int i = 0 ;i< size;i++){
			int wn = Integer.parseInt(file.readLine());
			Map<Integer,ArrayList<String>> allw= new HashMap<>();
			int max = -1;
			for(int j = 0 ; j < wn;j++){
				String curw = file.readLine();
				boolean []dd= new boolean[26];
				int co=0;
				for(char c: curw.toCharArray()){
					if( c <'A' || c>'Z') continue;
					if(!dd[c-'A']) {
						co++;
						dd[c-'A']=true;
					}
				}
				if(co > max) max = co;
				if(allw.containsKey(co)){
					allw.get(co).add(curw);
				}else{
					allw.put(co,new ArrayList<String>());
					allw.get(co).add(curw);
				}
			}
			ArrayList<String> ccc = allw.get(max);
			if(ccc.size() == 1){
				ansFile.writeLine("Case #"+(i+1)+": "+ccc.get(0));	
			}else{
				Collections.sort(ccc);
				ansFile.writeLine("Case #"+(i+1)+": "+ccc.get(0));
			}
			System.out.println("Case #"+(i+1)+": "+ccc.get(0));
		}
//		in.close();
	}
	public static long curWrodProces(int [][]curl,int N,int K){
		
		int count = 0;
		int c1,c2,c3;
		for(int i1 = 0;i1<N;i1++){
			c1 = curl[0][i1];
			for(int i2 = 0;i2<N;i2++){
				c2 = curl[1][i2];
				for(int i3 = 0;i3<N;i3++){
					c3 = curl[2][i3];
					for(int i4 = 0;i4<N;i4++){
						if((c1 ^ c2 ^ c3 ^ curl[3][i4])==K )count++;
					}
				}
			}
		}
		return count;
	}
	
}
