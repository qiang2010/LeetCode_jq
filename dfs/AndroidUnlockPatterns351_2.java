package qiang.dfs;

public class AndroidUnlockPatterns351_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AndroidUnlockPatterns351_2 dds = new AndroidUnlockPatterns351_2();
		System.out.println(dds.numberOfPatterns(1, 2));
	}
	public int numberOfPatterns(int m, int n) {
		if(m > n) return 0;
		if( m < 0 || n < 0 ) return 0;
		if(m > 9 || n> 9) return 0;
		// 这里对所有的位置都dfs了，其实由于 四个角是对称的，从这个四个位置得到的解的数量应该是一样的
		// 同时 四条边的中点的位置也是对称的，还有一个就是从中间出发。于是就可以三次dfs就可以了。
		int [][]col = new int[10][10];
		col[1][3] = col[3][1] = 2;
		col[1][7] = col[7][1] = 4;
		col[9][3] = col[3][9] = 6;
		col[9][7] = col[7][9] = 8;
		col[4][6] = col[6][4] = 5;
		col[2][8] = col[8][2] = 5;
		col[1][9] = col[9][1] = 5;
		col[3][7] = col[7][3] = 5;
		
		boolean visited[] = new boolean[10];
		visited[0] = true;
		int a = this.dfs(visited, col, 1, 1, m, n);
		System.out.println(a);
		int b = this.dfs(visited, col, 2, 1, m, n);
		System.out.println(b);
		int c = this.dfs(visited, col, 5, 1, m, n);
		System.out.println(c);
		return a* 4 +b*4+c;
	}
	int dfs(boolean []visited,int [][]col,int curP, int curLen,int m,int n){ 
		int coun = 0 ;
		if(curLen > m-1 && curLen < n+1) coun++;
		if(++curLen > n) return coun;
		visited[curP] = true;
		for(int i = 1;i <10;i++){
			if(!visited[i] && visited[col[curP][i]]){
//				visited[i] = true;
				coun += dfs(visited, col, i, curLen, m, n);
//				visited[i] = false;
			}
		}
		visited[curP] = false;
		return coun;
	}
	
	 
	
}
