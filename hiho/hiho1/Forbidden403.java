package qiang.hiho.hiho1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 微软笔试题目 20160406
 * @author jq
 *
 */
public class Forbidden403 {

	public static void main(String[] args) {
		
		Forbidden403 s  = new Forbidden403();
		s.buildTree();
		
	}
	class Node{
		boolean isEnd;
		Node left,right;
		int index;
		Node(){
			isEnd = false;
			index = Integer.MAX_VALUE; // 最小的
		}
	}
	int N,M;
	Node root;
	void insertIntoTrees(boolean []ones,int i){
		Node tempRoot = root;
		Node next =null;
		for(boolean n:ones){
			if(n){
				next = tempRoot.left;
				if(next == null){
					next = new Node();
					tempRoot.left = next;
				}
			}else{
				next = tempRoot.right;
				if(next == null){
					next = new Node();
					tempRoot.right = next;
				}
			}
			tempRoot = next;
		}
		tempRoot.isEnd = true;
		tempRoot.index = Math.min(tempRoot.index, i); 
	}
	boolean isAllowed(boolean []ones,boolean []cons){
		if(root == null)return false;
		Node tempRoot = root,next;
		int minindex = Integer.MAX_VALUE;
		if(root.isEnd){
			minindex = root.index;
		}
		for(boolean n:ones){
			if(n ){
				next = tempRoot.left;
			}else{
				next = tempRoot.right;
			}
			if(next == null){
				break;
			}
			if(next.isEnd) {
				minindex = Math.min(minindex, next.index);
			}
			tempRoot = next;
		}
		if(minindex == Integer.MAX_VALUE){
			return true;
		}
		return cons[minindex];
	}
	
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
			root = new Node();
			boolean [] cons = new boolean[N];
			for(int i =0;i< N;i++){
				String line = in.readLine();
				if(line.charAt(0) == 'a'){
					cons[i] = true;
				}
				String ip = line.substring(5);
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
					int oneIp = Integer.parseInt(ips[ipNu++]);
					int m = 0;
					while(m < 8 && j <mask){
						ones[j++] = (oneIp&masks[m++])!=0;
					}
				}
				insertIntoTrees(ones,i);
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
				if(isAllowed(ones,cons)){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
