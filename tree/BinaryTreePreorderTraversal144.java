package qiang.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 extends TreeAlg{

	/**
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreePreorderTraversal144 ins = new BinaryTreePreorderTraversal144();
		TreeNode root = ins.getTreeExample();
		System.out.println(ins.preorderTraversal(root).toString());
		System.out.println(ins.inorderTraversal(root).toString());
	}
	
	// Given a binary tree, return the preorder traversal of its nodes' values.
	// Note: Recursive solution is trivial, could you do it iteratively?
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null ) return null;
        ArrayList<Integer> preOrder = new ArrayList<Integer>();
        Stack<TreeNode> preStack = new Stack<TreeNode>();
       // preStack.add(root);
        //preOrder.add(root.val);
        TreeNode temp = root;
        
        while(temp!=null || !preStack.isEmpty()){
//        	temp  = preStack.pop();
        	while(temp !=null){
        		preStack.add(temp);
        		preOrder.add(temp.val);
        		temp = temp.left;
        	}
        	temp = preStack.pop();
        	temp = temp.right;
        	//if(temp!=null) preOrder.add(temp.val);
        }
        
        return preOrder;
    }
    /**
     * Given a binary tree, return the inorder traversal of its nodes' values.
     * Note: Recursive solution is trivial, could you do it iteratively?
     * @param root
     * @return
     */
    
    
   public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> inorderTravel = new ArrayList<Integer>();
        if(root == null)  return inorderTravel; 
        Stack<TreeNode> inOrder = new Stack<TreeNode>();
        TreeNode temp = root;
        while(temp!=null || !inOrder.isEmpty()){
        	
        	while(temp!=null){
        		inOrder.add(temp);
        		temp = temp.left;
        	}
        	
        	temp = inOrder.pop();
        	inorderTravel.add(temp.val);
        	temp = temp.right;
        	
        }
        return inorderTravel;
    }
    
}
