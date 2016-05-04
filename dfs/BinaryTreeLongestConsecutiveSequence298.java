package qiang.dfs;

import qiang.tree.TreeNode;

public class BinaryTreeLongestConsecutiveSequence298 {

	 public int longestConsecutive(TreeNode root) {  
		 if(root == null) return 0;
		 dfs(root,1);
		 return max;
	 }
	 int max = Integer.MIN_VALUE;
	 void dfs(TreeNode root,int maxIn){
		 max = max > maxIn? max:maxIn;
		 if(root.left!=null){
			 if( root.val+1 == root.left.val)
				 dfs(root.left,maxIn+1);
			 else{
				 dfs(root.left,1);
			 }
		 }
		 if(root.right != null){
			 if(root.right.val == root.val+1){
				 dfs(root.right,maxIn+1);
			 }else{
				 dfs(root.right,1);
			 }
		 }
	 }
}
