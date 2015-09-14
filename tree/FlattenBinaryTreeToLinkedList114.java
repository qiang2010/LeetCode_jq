package qiang.tree;

import java.util.LinkedList;

public class FlattenBinaryTreeToLinkedList114 {

	
	
	
	LinkedList<TreeNode> ans;
	public void flatten(TreeNode root) {
		if(root == null) return ;
		ans = new LinkedList<>();
		preOrder(root);
		TreeNode tempNode = root;
		tempNode.left =null;
		int size = ans.size();
		ans.removeFirst();
		for(int i = 1 ; i < size; i++){
			tempNode.right = ans.getFirst();
			tempNode.left = null;
			ans.removeFirst();
			tempNode = tempNode.right;
		}
		
	}
	public void preOrder(TreeNode root){
		if(root == null) return;
		ans.addLast(root);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	
	
	 TreeNode newRoot;
	 public void flatten2(TreeNode root) {
		 
		 if(root == null)return ;
		 newRoot = new TreeNode();
		 preOrder2(root);
	 }
	public void preOrder2(TreeNode root){
		if(root == null) return ;
		TreeNode rightNode = root.right;  // 这里需要先把右子树保存下来，不然下面会覆盖。
		newRoot.right = root;
		newRoot = root;
		preOrder2(root.left);
		root.left = null;
		preOrder2(rightNode);
		//root.left =null;
	}
	
	
	// 错误解法：
//	static TreeNode newRoot;
//	
//	 public void flatten(TreeNode root) {
//		 
//		 if(root == null)return ;
//		 newRoot = new TreeNode();
//		 preOrder(root);
//	 }
//	public void preOrder(TreeNode root){
//		if(root == null) return ;
//		newRoot.right = root;
//		newRoot = root;
//		preOrder(root.left);
//		//root.left = null;
//		preOrder(root.right);
//		//root.left =null;
//	}
//	
	
	public static void main(String[] args) {
		TreeNode ro = TreeAlg.getTreeForSerialized("123456");
		FlattenBinaryTreeToLinkedList114 ee =
		new FlattenBinaryTreeToLinkedList114();
		ee.flatten2(ro);
		while(ro!=null){
			System.out.println(ro.val);
			ro = ro.right;
		}
	}

}
