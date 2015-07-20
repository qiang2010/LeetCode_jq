package qiang.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeAlg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String first = "abdegcfh";
		String mid = "dbgeafhc";
		//TreeAlg  treeAlg = new TreeAlg();
		TreeNode root = TreeAlg.buildTree(first, 0, first.length()-1, mid, 0, mid.length()-1);
		TreeAlg.postOrder(root);
		System.out.println();
		TreeAlg.preOrder(root);
		System.out.println();
		TreeAlg.minOrder(root);
		System.out.println();
		TreeAlg.levelOrder(TreeAlg.getCompleteTree());
	}

	public static TreeNode getTreeExample(){
		String first = "abdegcbh";
		String mid = "dbgeabhc";
		//TreeAlg  treeAlg = new TreeAlg();
		TreeNode root = TreeAlg.buildTree(first, 0, first.length()-1, mid, 0, mid.length()-1);
		return root;
	}
	
	/**
	 * 根据先根、中根遍历构建二叉树
	 *  
	 * @param list
	 * @return
	 */
	public static  TreeNode buildTree(String first,int fb,int fe, String mid,int mf,int me){
		if(fb>fe || mf> me) return null;
		char rootCont = first.charAt(fb);
		// 在中根遍历中，查找当前根
		int rootIndex = 0;
		for(int k = mf; k <= me ;k++){
			if(rootCont == mid.charAt(k)){
				rootIndex = k;
				break;
			}
		}
		// 
		TreeNode rootTreeNode = new TreeNode();
		rootTreeNode.val = rootCont;
		int leftSize = rootIndex - mf;
		rootTreeNode.left = buildTree(first,fb+1,fb+leftSize,mid,mf,rootIndex-1);
		rootTreeNode.right = buildTree(first,fb+1+leftSize,fe,mid,rootIndex+1,me);
		//System.out.println("depth");
		return rootTreeNode;
	}
	
	public static void postOrder(TreeNode root){
		if(root == null ) return ;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val+" ");
	} 
	public static void preOrder(TreeNode root){
		if(root == null) return;
		System.out.print(root.val+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void  minOrder(TreeNode root){
		if(root == null)  return ;
		minOrder(root.left);
		System.out.print(root.val+" ");
		minOrder(root.right);
	}
	
	public static void levelOrder(TreeNode root){
		if(root == null) return;
		Queue<TreeNode> level = new  LinkedList<TreeNode>();
		level.add(root);
//		System.out.print(root.val);
		TreeNode temp;
		while(level.isEmpty()==false){
			temp = level.poll();   
			System.out.print(temp.val +" ");
			if(temp.left  != null ) level.add(temp.left);
			if(temp.right != null ) level.add(temp.right);
			
		}
	}
	
	// return an example of complete tree
	public static  TreeNode getCompleteTree(){
		String first = "12453";
		String mid = "42513";
		//TreeAlg  treeAlg = new TreeAlg();
		return  TreeAlg.buildTree(first, 0, first.length()-1, mid, 0, mid.length()-1);
		
	}
	
	
}
//class TreeNode {
//	TreeNode left,right;
//	int  val;
//	TreeNode(){
//		left = right = null;
//		val = -1;
//	}
//	
//}
