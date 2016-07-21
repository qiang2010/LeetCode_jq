package qiang.tree;

import java.util.LinkedList;

public class FlattenBinaryTreeToLinkedList114_2 {

	
 
 
    public void flatten(TreeNode root) {
        preOrder(root);
    }
    TreeNode curNode = new TreeNode(-1);
    void preOrder(TreeNode root){

     if(root == null ) return;
     curNode.right = root;
     curNode = root; 
     TreeNode right = root.right;
     preOrder(root.left);
     root.left = null;
     preOrder(right);
}
	
	
 
 
	
	public static void main(String[] args) {
 
	}

}
