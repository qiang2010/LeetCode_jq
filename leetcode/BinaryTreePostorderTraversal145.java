package qiang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import qiang.tree.TreeAlg;
import qiang.tree.TreeNode;

public class BinaryTreePostorderTraversal145 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTreePreorderTraversal144 ins = new BinaryTreePreorderTraversal144();
		TreeNode root = ins.getTreeExample();
		System.out.println(ins.preorderTraversal(root).toString());
		TreeAlg.postOrder(root);
		System.out.println(postorderTraversal(root).toString());
		
	}
    public static  List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> postList = new ArrayList<Integer>();
        if(root == null ) return postList;
        LinkedList<Integer> visited = new  LinkedList<Integer>();
        LinkedList<TreeNode> postOrder = new LinkedList<TreeNode>();
        visited.add(0);
        postOrder.add(root);
        TreeNode tempNode;
        int tempVisited;
        while(postOrder.isEmpty() == false){
        	tempVisited = visited.getLast();
        	visited.removeLast(); 
        	tempNode = postOrder.getLast();
        	postOrder.removeLast();
        	
        	switch (tempVisited) {
			case 0:
				postOrder.addLast(tempNode);
				visited.addLast(1);
				if(tempNode.right != null ) {
					postOrder.addLast(tempNode.right);
					visited.addLast(0);
				}
				if(tempNode.left != null ) {
					postOrder.addLast(tempNode.left);
					visited.addLast(0);
				}
			
				break;
			case 1:
				postOrder.addLast(tempNode);
				visited.addLast(2);
				if(tempNode.right != null) {
					postOrder.addLast(tempNode.right);
					visited.addLast(0);
				}
				break;
			case 2: 
				postList.add(tempNode.val);
				break;
			default:
				break;
			}
        }
    	return postList;
    }
	
}
