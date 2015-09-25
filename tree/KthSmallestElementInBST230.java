package qiang.tree;

public class KthSmallestElementInBST230 {

	
	   
	
	public int kthSmallest(TreeNode root, int k) {
		
		count = 1;
		inOrder(root,k);
		return ans;
	}
	int count =1;
	int ans = 0;
	public void inOrder(TreeNode root,int k){
		
		
		if(root == null) return;
		inOrder(root.left, k);
		
		if( k == count && root !=null){
			ans = root.val;
			count++;
			return;
		}else{
			count++;
		}
		inOrder(root.right, k);
		
	}
	public static void main(String[] args) {
		KthSmallestElementInBST230 kth = new KthSmallestElementInBST230();
		
		TreeNode root = TreeAlg.getTreeForSerialized("4381#79");
		int k = 1;
		System.out.println(kth.kthSmallest(root, k));
		
	}
	
	
	
	
}
