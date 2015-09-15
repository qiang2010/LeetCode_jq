package qiang.tree;

public class UniqueBinarySearchTrees96 {
	 
	
	
	
	public int numTrees2(int n){
		if(n ==0) return 0;
		if(n ==1)return 1;
		if(n==2) return 2;
		int []part = new int[n+1];
		part[0]=1;
		part[1]=1;
		part[2]=2;
		for(int i = 3; i <n+1;i++){
			
			for(int j = 0 ; j < i/2;j++){
				part[i] += part[j]*part[i-j-1];
			}
			part[i]= part[i]<<1;
			if(( i & 1)==1){
				part[i]+=part[i/2]*part[i/2];
			}
		}
		return part[n];
		
	}
	
	
	
	/**
	 *  下面的解法超时
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {
	
		return bstNum(1, n);
	}
	
	public int bstNum(int left,int right){
		if(left > right ) return 1;
		if(left == right ) return 1;
		if(left+1 == right) return 2;
		int sum =0;
		for(int i =left; i<1+ right; i++){
			sum += bstNum(left, i-1)*bstNum(i+1, right);
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new UniqueBinarySearchTrees96().numTrees(14));
		System.out.println(new UniqueBinarySearchTrees96().numTrees2(14));
	}

}
