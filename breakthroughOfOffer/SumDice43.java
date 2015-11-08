package qiang.breakthroughOfOffer;

public class SumDice43 {

	
	public static void main(String[] args) {
		
		new SumDice43().sumDice(2);
		
		
	}
	void sumDice(int n){
		
		if(n < 1) return;
		int size = 5*n+1;
		int []count = new int[size];
		
		dfs(count, n,0,0);
		for(int a:count){
			System.out.println(a);
		}
	}
	void dfs(int []count,int n,int depth,int tempSum){
		
		if(depth == n){
			count[tempSum-n] ++;
			return;
		}
		
		for(int i = 1; i < 7; i ++){
			dfs(count, n, depth+1, tempSum+i);
		}
	}
	
}
