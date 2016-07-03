package qiang.dfs;

public class AndroidUnlockPatterns351 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AndroidUnlockPatterns351 dds = new AndroidUnlockPatterns351();
		System.out.println(dds.numberOfPatterns(1, 2));
		
		AndroidUnlockPatterns351_2 dds2 = new AndroidUnlockPatterns351_2();
		System.out.println(dds2.numberOfPatterns(1, 2));
		
	}
	private int countAll = 0;
	public int numberOfPatterns(int m, int n) {
		if(m > n) return 0;
		if( m < 0 || n < 0 ) return 0;
		if(m > 9 || n> 9) return 0;
		this.countAll = 0;
		// 这里对所有的位置都dfs了，其实由于 四个角是对称的，从这个四个位置得到的解的数量应该是一样的
		// 同时 四条边的中点的位置也是对称的，还有一个就是从中间出发。于是就可以三次dfs就可以了。
		for(int i =0;i< 3;i++)
			for(int j = 0 ; j < 3;j++)
			{
				boolean [][]flag =new boolean[3][3];
//				flag[i][j] = true;
				int f = this.countAll;
				dfs(flag, i, j, 1, m, n);
				System.out.println(i+"\t"+j+"\t"+(this.countAll - f));
			}
		// 
		
		return this.countAll;
	}
	void dfs(boolean [][]boardFlag,int curX,int curY, int curLen,int m,int n){
	
		if(curLen > m-1 && curLen < n+1){
			this.countAll++;
		}
		if (curLen == n){
			return;
		}

		boardFlag[curX][curY] = true;
		// 继续
		for(int i =0;i<3;i++){
			for(int j = 0 ; j < 3;j++){
				if(this.isValid(boardFlag, i, j, curX, curY)){
					boardFlag[i][j] = true;
					this.dfs(boardFlag, i, j, curLen+1, m, n);
					boardFlag[i][j] = false;
				}
			}
		}
		boardFlag[curX][curY] = false;
	}
	boolean isValid(boolean [][]flag,int x,int y,int lastX,int lastY){
		if(x == lastX && y == lastY) return false;
		if(flag[x][y]) return false;
		// 同一行 
		if(x == lastX){
			if(Math.abs(lastY-y)==1)return true;
			return flag[x][1];
		}
		// 同一列
		if( y == lastY){
			if(Math.abs(lastX-x)==1)return true;
			return flag[1][y];
		}
		// 对角线
		if(Math.abs(lastY-y)==Math.abs(lastX-x) && Math.abs(lastY-y)>1){
			return flag[1][1];
		}
		return true;
	}
	
}
