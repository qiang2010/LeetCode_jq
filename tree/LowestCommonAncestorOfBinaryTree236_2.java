package qiang.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class LowestCommonAncestorOfBinaryTree236_2 {

	
	/**
	 * 记录从根到p和q的路径，然后从根往下依次判断就可以了。
	 * 找到从根到一个节点的路径：
	 * 使用一个栈，模拟先根遍历，遍历的过程中，当找到该节点的时候，栈中的节点就是相应的路径。
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return null;
		if(p == null || q == null) return null;
		LinkedList<TreeNode> pPath = getPath(root,p);
		LinkedList<TreeNode> qPath = getPath(root,q);
		
		printList(pPath);
		System.out.println();
		printList(qPath);
		
		
		TreeNode ans = null;
		while(!pPath.isEmpty() && !qPath.isEmpty() && pPath.getFirst() == qPath.getFirst()){
			ans = pPath.getFirst();
			pPath.removeFirst();
			qPath.removeFirst();
		}
		return ans;
	}
	
	static LinkedList<TreeNode>  getPath(TreeNode rootNode,TreeNode q){ 
		LinkedList<TreeNode> p = new LinkedList<TreeNode>();
		getPathDFS(rootNode,q,p);
		return p;
	}
	
	static boolean getPathDFS(TreeNode root,TreeNode target,LinkedList<TreeNode> path){
		if(root == null) return false;
		path.addLast(root);
		if(root == target) return true;
//		if(root.val == target.val) return true;
		
		if(getPathDFS(root.left,target,path)) return true;
		if(getPathDFS(root.right,target,path)) return true;
		path.removeLast();
		return false;
	}
	static void printList(LinkedList<TreeNode> li){
		
		for(TreeNode n:li){
			System.out.print(n.val+"\t");
		}
		
	}
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeAlg.getTreeExample();
		TreeAlg.preOrder(root);
		TreeNode p = new TreeNode();
		p.val = 98;
		//System.out.println(containsNode(root,p));
		TreeNode q = new TreeNode();
		q.val = 98;
		System.out.println();
//		LinkedList<TreeNode> reLinkedList = getReversePath(root, q);
//		System.out.println(q.val);
//		for(TreeNode temp:reLinkedList){
//			System.out.print(temp.val+" ");
//		}
		System.out.println(lowestCommonAncestor1(root,p,q).val);
	}

}
