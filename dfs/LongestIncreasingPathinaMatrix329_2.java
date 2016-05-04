package qiang.dfs;

public class LongestIncreasingPathinaMatrix329_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]matrix =  {{3,4,5},
		  {3,2,6},
		  {2,2,1}};
		LongestIncreasingPathinaMatrix329_2 sb = new LongestIncreasingPathinaMatrix329_2();
		System.out.println(sb.longestIncreasingPath(matrix));
	}
	int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
    	if(matrix == null ) return 0;
    	int m = matrix.length;
    	if(m ==0)return 0;
    	int n = matrix[0].length;
    	if(n==0)return 0;
    	int [][]cache= new int[m][n];
    	int max = -1;
    	for(int i = 0 ;i < m;i++)
    		for(int j = 0;j< n;j++){
    			int one = dfs(i, j,  matrix[i][j], cache, m, n, matrix);
    			max = max > one? max:one;
    		}
    	return max;
    }
    /**
     * i j 是当前dfs开始的位置，curLen 是当前已经走了多少步，
     * flag是标记走过了哪里，last是上一个数值，cache是记录走过的位置的最大路径长度
     * @param i
     * @param j
     * @param curLen
     * @param flag
     * @param lastPoiNum
     * @param cache
     * @return
     */
    int dfs(int i ,int j,int lastPoiNum,int [][]cache,int m,int n,int [][]matrix){
    	
    	if(i<0 || j <0 || i >m-1 || j > n-1)return 0;
    	if(cache[i][j] > 0){
    		return cache[i][j];
    	}
    	// 四个方向
    	int max = 0;
    	for(int di = 0;di<4;di++){
    		int newi = i + dir[di][0];
    		int newj = j + dir[di][1];
	    	if(newi >-1 && newi < m && newj>-1 && newj< n  && matrix[newi][newj] > lastPoiNum){
	    		int one = dfs(newi, newj, matrix[newi][newj], cache, m, n,matrix);
	    		cache[newi][newj] = one;
	    		max = max > one?max:one;
	    	}
    	}
    	cache[i][j] = max+1;
    	return max+1;
    }
    
    
    
}
