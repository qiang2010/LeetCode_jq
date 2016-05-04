package qiang.tree;

import java.util.LinkedList;
import java.util.List;

public class ValidateBinarySearchTree98 {
	
	
	/**
	 * 一边中根遍历，一边判断
	 * @param root
	 * @return
	 */
	TreeNode pre = null;
	public   boolean isValidBST3(TreeNode root) {
		
		if(root == null) return true;
		
		if(! isValidBST(root.left)) return false;
		if(pre != null && pre.val >root.val) return false;
		pre = root;
		return isValidBST(root.right);
	}
	
	
	/**
	 * 这里使用保守的先中根遍历，在判断 
	 * @param root
	 * @return
	 */
	static List<Integer> vals = new LinkedList<>();
	public static  boolean isValidBST(TreeNode root) {
		vals.clear();
		inOrder(root);
		int s = vals.size();
		for(int i=1; i < s; i++){
			if(vals.get(i-1) >= vals.get(i)) return false;
		}
		return true;
	}
	
	public static  void inOrder(TreeNode root){
		if(root == null) return;
		inOrder(root.left);
		vals.add(root.val);
		inOrder(root.right);
	}
	
	/**
	 * 这里递归判断，一个二叉搜索树的左右子树都是二叉排序树
	 * [10,5,15,null,null,6,20]
	 * 下面是错误的
	 * @param root
	 * @return
	 */
	public static  boolean isValidBST2(TreeNode root) {
		
		if(root == null) return true;

		boolean left = isValidBST(root.left);	
		boolean right = isValidBST(root.right);	

		
		
		if(root.left != null && root.right != null){
			return root.left.val < root.val && root.right.val > root.val && left && right;
		}
		if(root.left == null && root.right != null){
			return root.right.val > root.val && left && right;
		}
		if(root.left != null && root.right == null)
			return root.left.val < root.val && left &&right;
		return true;
	}
	/**
	 * 这里使用BST节点的范围判断
	 * @param root
	 * @return
	 */
	public   boolean isValidBST4(TreeNode root) {
		return isBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
	}
	boolean isBST(TreeNode root ,long low,long upper){
		
		if(root == null) return true;
		if(root.val > low && root.val < upper){
			boolean left = isBST(root.left,low,root.val);
			if(!left)return false;
			boolean right = isBST(root.right,root.val,upper);
			if(right) return true;
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeAlg.getTreeForSerialized("1#32");
		System.out.println(isValidBST(root));
	}

}
