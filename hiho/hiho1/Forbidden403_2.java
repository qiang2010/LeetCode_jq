package qiang.hiho.hiho1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

/**
 * 微软笔试题目 20160406
 * @author jq
 *
 */
public class Forbidden403_2 {

	public static void main(String[] args) {
		
		Forbidden403_2 s  = new Forbidden403_2();
		s.buildTree();
		
	}
 
	int N,M;
	
	// 读取数据，构建树
	void buildTree(){
		try {
			int masks [] = new int[8];
			for(int i =7;i>-1;i--){
				masks[7-i] = 1<<i;
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String []nm = in.readLine().split("\\s+");
			N = Integer.parseInt(nm[0]);
//			System.out.println(N);
			M = Integer.parseInt(nm[1]);
			boolean[][] conditions = new boolean[N][];
			boolean []con = new boolean[N];
			for(int i =0;i< N;i++){
				String line = in.readLine();
				if(line.charAt(0) == 'a'){
					con[i]= true;
				}
//				System.out.println(line);
				String ip = line.substring(5);
//				System.out.println(ip);
				int mask = 32;
				String []ips;
				if(ip.contains("/")){
					String [] sp = ip.split("/");
					mask = Integer.parseInt(sp[1]);
					ips = sp[0].split("\\."); 
				}else{
					ips = ip.split("\\.");
				}
				int j =0,ipNu=0;
				boolean ones []= new boolean[mask];
				while(j < mask && ipNu < 4){
					int oneIp = Integer.parseInt(ips[ipNu++].trim());
					int m = 0;
					while(m < 8 && j <mask){
						ones[j++] = (oneIp&masks[m++])!=0;
					}
				}
				conditions[i] = ones;
			}
			for(int i =0;i< M;i++){
				String line;
				line = in.readLine();
				String []ips  = line.split("\\.");
				boolean ones []= new boolean[32];
				int ipNu = 0,j=0;
				while(ipNu < 4){
					int oneIp = Integer.parseInt(ips[ipNu++]);
					int m = 0;
					while(m < 8){
						ones[j++] = (oneIp&masks[m++])!=0;
					}
				}
				isfilter(conditions,con,ones);
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 void isfilter(boolean[][]conditions, boolean []con,boolean[] ones){
		 for(int i =0;i< N;i++){
			 boolean is = isMatch(conditions[i],ones);
//			 System.out.println(is);
			 if(is){
				if(con[i]){
					System.out.println("Yes");
				}else{
					System.out.println("No");
				}
				return;
			 }
		 }
		 System.out.println("Yes");
	}
	boolean isMatch(boolean []con,boolean []ones){
		int len = con.length;
		int len2 = ones.length;
		if(len  == 0) return true;
		int i =0,j=0;
		while(i< len && j < len2){
			if((con[i++] != ones[j++])){
				return false;
			}
		}
		return true;
	}
}
