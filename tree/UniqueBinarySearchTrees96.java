package qiang.tree;

public class UniqueBinarySearchTrees96 {
	 
	
	
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
		System.out.println(new UniqueBinarySearchTrees96().numTrees(4));
	}

}
