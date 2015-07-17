package qiang.leetcode;

import qiang.tree.TreeNode;

public class InvertBinaryTree226 {

	
	public static void main(String[]args){
		
		BinaryTreePreorderTraversal144 ins = new BinaryTreePreorderTraversal144();
		TreeNode root = ins.getTreeExample();
		System.out.println(ins.preorderTraversal(root).toString());
		invertTree(root);
		System.out.println(ins.preorderTraversal(root).toString());
	}
	
    public static  TreeNode invertTree(TreeNode root) {
    	TreeNode newTree ;
    	if(root ==null ) return null;

    	invertTree(root.left);
    	invertTree(root.right);
    	
    	newTree = root.right;
    	root.right = root.left;
    	root.left = newTree;
    	
    	return root;
    }
	
	
	
}
