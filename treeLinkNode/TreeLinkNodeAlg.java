package qiang.treeLinkNode;

import qiang.tree.TreeNode;

public class TreeLinkNodeAlg {

	
	public static void printTree(TreeNode root){
		
		if(root == null) return ;
		TreeNode tempNode = root;
		while(root != null){
			tempNode = root;
			while(root != null){
				System.out.print(root.val + " ");
				root = root.next;
			}
			System.out.println();
			root = tempNode.left;
		}
	}
}
