package qiang.segTree;

import java.util.Scanner;

public class BillBoard_segTree {

	public static void main(String[] args) {
		
		BillBoard_segTree dadf = new BillBoard_segTree();
		dadf.billboard();
	}
	
	int h,w,n;
	void billboard(){
		
		
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()){
			h = in.nextInt();
			w = in.nextInt();
			n = in.nextInt();
			
			if( h > n)h = n;
			segTree = new int[h<<2];
			this.build(1, h, 1);
			int cur ;
			while(n > 0 ){
				cur = in.nextInt();
				if(segTree[1] < cur) System.out.println(-1);
				else{
					System.out.println(this.query(1, h, 1, cur));
				}
				n--;
			}
		}
		
		in.close();
	}
	int []segTree;
	void build(int begin,int end,int root){
		segTree[root] = this.w;
		if(begin == end) return;
		int m = begin + ((end - begin)>>1);
		build(begin,m,root<<1);
		build(m+1,end,(root<<1)|1);
	}
	// 找个查询，实际上就是修改，将某个的值减去target
	int query(int begin,int end,int root,int target){
		if (begin == end){
			segTree[root] -= target;
			return begin;
		}
		int re;
		int m = begin + ((end-begin)>>1) ;
		if(segTree[root<<1] >= target){
			re = this.query(begin, m, root<<1, target);
		}else re = this.query(m+1, end, root<<1 |1 , target);
		segTree[root] = Math.max(segTree[root<<1], segTree[root<<1 |1]);
		return re;
	}
	
}
