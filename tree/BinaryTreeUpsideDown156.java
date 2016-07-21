package qiang.tree;

import java.util.LinkedList;

public class BinaryTreeUpsideDown156 {

	public static void main(String[] args) {
		BinaryTreeUpsideDown156 bi = new BinaryTreeUpsideDown156();
		TreeNode root = TreeAlg.getTreeForSerialized("12345");
		root = bi.UpsideDownBinaryTree3(root);
		TreeAlg.preOrder(root);
		System.out.println();
		TreeAlg.inOrder(root);
	}
	 
	public TreeNode UpsideDownBinaryTree(TreeNode root) {  
		if(root == null) return root;
		if(root.left==null ) return root;
		LinkedList<TreeNode> stack = new LinkedList<>();
		while(root != null){
			stack.addLast(root);
			root = root.left;
		}
		TreeNode newRoot = stack.getLast(); stack.removeLast();
		TreeNode next = stack.getLast(); stack.removeLast();
		newRoot.left = next.right;
		next.right = null;next.left = null;
		newRoot.right = next;
		TreeNode cur;
		while(stack.isEmpty()==false){
			cur  = stack.getLast(); stack.removeLast();
			next.left = cur.right;
			next.right = cur;
			if(stack.isEmpty())
				cur.right = null;cur.left= null;
			next = cur;
		}
		return newRoot;
	}
	public TreeNode UpsideDownBinaryTree2(TreeNode root) {  
		if(root == null) return root;
		if(root.left==null ) return root;
		LinkedList<TreeNode> stack = new LinkedList<>();
		while(root != null){
			stack.addLast(root);
			root = root.left;
		}
		TreeNode newRoot = stack.getLast(); stack.removeLast();
		TreeNode cur = newRoot;
		TreeNode next;
		while(stack.isEmpty()==false){
			next  = stack.getLast(); stack.removeLast();
			cur.left = next.right;
			cur.right = next;
			if(stack.isEmpty())
				next.right = null;next.left= null;
			cur = next;
		}
		return newRoot;
	}
	/**
	 * 这里递归来做。
	 * @param root
	 * @return
	 */
	public TreeNode UpsideDownBinaryTree3(TreeNode root) {  
		if(root == null) return root;
		if(root.left ==null && root.right ==null) return root;
		TreeNode reLeft = this.UpsideDownBinaryTree3(root.left);
//		TreeNode reRight = this.UpsideDownBinaryTree3(root.right);
		// 将root接到反正后的之问题上。
		TreeNode la = reLeft;
		while(la.right !=null) la = la.right;
		la.right = root;
		la.left = root.right;
		root.right = null;
		root.left =null;
		return reLeft;
	}
}
