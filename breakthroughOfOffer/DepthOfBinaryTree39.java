package qiang.breakthroughOfOffer;

import qiang.tree.TreeAlg;
import qiang.tree.TreeNode;

public class DepthOfBinaryTree39 {

	public static void main(String[] args) {
		
		TreeNode root = TreeAlg.getTreeForSerialized("12##4");
		System.out.println(depth(root));
		isBalanceTree(root);
		System.out.println(isBal);
	}
	
	static int depth(TreeNode root){
		
		if(root == null) return 0;
		int left = depth(root.left);
		int right = depth(root.right);
		if(left > right){
			return left+1;
		}
		return right+1;
	}
	
	
	
	static boolean isBal = true;
	static int isBalanceTree(TreeNode root){
		
		if(root == null) return 0;
		int left = isBalanceTree(root.left);
		
		if(left == Integer.MAX_VALUE)return Integer.MAX_VALUE;
		int right = isBalanceTree(root.right);
		if(right == Integer.MAX_VALUE) return Integer.MAX_VALUE;
		
		if(left - right >1 || right - left >1){
			isBal = false;
			return Integer.MAX_VALUE;
		}
		return left > right? left+1:right+1;
	}
}
