package qiang.breakthroughOfOffer;

import qiang.tree.TreeAlg;
import qiang.tree.TreeNode;

public class BSTtoSortedLinkedList27 {

	
	/**
	 * 最简单的思路就是，中根遍历，每次遍历到一个结点就把该结点插入到结果集中.
	 * 具体使用一个指针每次都指向结果集的最后一个结点。.
	 * 每次遍历到新的结点就加入到该指针的后面，然后更新当前指针为最后一个指针。
	 */
	public static TreeNode ansRoot = null;
	public static void bstToSortedList(TreeNode root){
		
  		if(root == null ) return;
		 bstToSortedList(root.left);
		 if(ansRoot == null){
			  ansRoot = root; 
		 }else {
			ansRoot.right = root;
			root.left = ansRoot;
			ansRoot = root;
		}
		 bstToSortedList(root.right);
	}
	
	
	public static void main(String[] args) {
		TreeNode root = TreeAlg.getTreeForSerialized("428#359");
		 bstToSortedList(root);
		while(ansRoot !=null){
			System.out.println(ansRoot.val);
			ansRoot = ansRoot.left;
		}
	}
}
