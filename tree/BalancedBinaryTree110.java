package qiang.tree;

public class BalancedBinaryTree110 {

	boolean isBalanced = true;
	
	public boolean isBalanced(TreeNode root) {
		 isBalanced = true;
		balance(root);
		return isBalanced;
	}	
	public int balance(TreeNode root){
		
		if(root == null) return 0;
		int left = balance(root.left);
		if(left == -1) return -1;
		int right = balance(root.right);
		if(right == -1) return -1;
		if(Math.abs(left-right) >1){
			isBalanced = false;
			return -1;
		}
		return left > right? left+1: right+1;
		
	}
	
	public static void main(String[] args) {

		BalancedBinaryTree110 bb = new BalancedBinaryTree110();
		TreeNode root = TreeAlg.getTreeForSerialized("123##4");
		System.out.println(bb.isBalanced(root));
	}

}
