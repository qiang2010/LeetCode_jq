package qiang.tree;

import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class BinaryTreeInorderTraversal94 {
	 
	public static void main(String[] args) {
		
		BinaryTreeInorderTraversal94 br = new BinaryTreeInorderTraversal94();
		
		TreeNode root = TreeAlg.getTreeForSerialized("123#4");
		List<Integer> ans = br.inorderTraversal(root);
		PrintUtil.printList(ans);
		
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
	        
		List<Integer>  inorderAns = new LinkedList<>(); 
	
		LinkedList<TreeNode> stack = new LinkedList<>();
		
		TreeNode tempNode = root;
		while(tempNode != null || !stack.isEmpty()){
			
			while(tempNode!= null){
				stack.addLast(tempNode);
				tempNode = tempNode.left;
			}
			tempNode = stack.getLast();
			stack.removeLast();
			inorderAns.add(tempNode.val);
			tempNode = tempNode.right;
			
		}
		return inorderAns;
	}
}
