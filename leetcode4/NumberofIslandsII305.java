package qiang.leetcode4;

import java.util.LinkedList;
import java.util.List;

public class NumberofIslandsII305 { 
	
	
	public static void main(String[] args) {
		
		NumberofIslandsII305 nsss = new NumberofIslandsII305();
		int m =3;
		int n = 3;
		int[][]positions = {{0,0},{0,1},{1,2},{2,1}};
		System.out.println(nsss.numIslands2(m, n, positions));
	}
	 int []uniset ;
	 int []weight ;
	 public List<Integer> numIslands2(int m, int n, int[][] positions) {
		 List<Integer> ans = new LinkedList<>();
		 if(m == 0 || n==0) return ans;
		 int size = m*n;
		 uniset = new int[m*n];
		 weight = new int[m*n]; // 用于记录每个树中节点的数量
		 
		 for(int i =0;i<size;i++){
			 uniset[i] = i; // 每个节点初始都是孤立的
		 }
		 int [][]dirs = {{1,0},{-1,0},{0,-1},{0,1}};
		 int count = 0;
		 for(int []pos:positions){// 处理每个节点
			 int index = pos[0]*n + pos[1];
			 // index已经在集合中，无序处理了，这个可能是有重复的输入造成的。
			 if(uniset[index] != index){
				 ans.add(count);
				 continue;
			 }
			 // 如果输入没有重复，那么每次新加入的点都是一个新的island，需要和其上下左右合并
			 // 首先count++，weight[index]++; 表明这是一棵新树。
			 count++;  
			 weight[index]++;
			 for(int []oneDir:dirs){
				 int newx = pos[0] + oneDir[0];
				 int newy = pos[1] + oneDir[1];
				 if(newx < 0 || newy< 0 || newx > m-1 || newy > n-1)continue;
				 int newindex = newx*n + newy;
				 if(weight[newindex] < 1)continue;  // 这一句忘了。只有当weight大于0的时候，说明这棵树是已经存在的。
				 if(!isConnected(newindex,index)){// 集合不相交
					union(newindex,index);
					count--;
				 }
			 }
			 ans.add(count);
		 }
		 return ans;
	 }
	 
	 // 合并两个集合
	 void union(int x,int y){
		 int fx = findFather(x);
		 int fy = findFather(y); 
		 if(fx == fy ) return;
		 if(weight[fx] < weight[fy]){
			 uniset[fx] = fy;
			 weight[fy]+= weight[fx];
		 }else{
			 uniset[fy] = fx;
			 weight[fx] += weight[fy];
		 }
	 }
	 boolean isConnected(int x,int y){
		 return findFather(x) == findFather(y);
	 }
	 // 带压缩,这里使用递归，也可以首先找到根，然后重新遍历一遍，重置其为根。
	 int findFather(int x){
		 if(uniset[x] == x) return x;
		 uniset[x] = findFather(uniset[x]);
		 return uniset[x];
	 }
	 
}
