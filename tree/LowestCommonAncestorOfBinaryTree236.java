package qiang.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LowestCommonAncestorOfBinaryTree236 {

	
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
		LinkedList<TreeNode> pPath = getReversePath(root, q);
		LinkedList<TreeNode> qPath = getReversePath(root, q);
		int size1 = pPath.size();
		int size2 = qPath.size();
		size1 = size1>size2? size1:size2;
		for(int i = 0 ; i < size1; i++){
			if(pPath.get(i).val == qPath.get(i).val){
				continue;
			}else{
				return pPath.get(i);
			}
		}
		return null;
	}
	
	static LinkedList<TreeNode> getReversePath(TreeNode rootNode,TreeNode q){
		LinkedList<TreeNode> stackLinkedList = new LinkedList<TreeNode>();
		if(rootNode == null) return stackLinkedList;
		TreeNode tempNode = rootNode;
		while(rootNode !=null || !stackLinkedList.isEmpty()){
			while(rootNode!=null){
				stackLinkedList.add(rootNode);
				if(rootNode.val == q.val) return stackLinkedList;
				rootNode = rootNode.left;
			}
			tempNode = stackLinkedList.peek();
			tempNode = tempNode.right;
		}
		return stackLinkedList;
		
	}
	
	 public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	     if(root == null ) return null;
	     if(p==null || q == null)return null;
	     if(p==root && q == root) return root;
		 if(containsNode(root.left, p) && containsNode(root.right, q) || containsNode(root.left, q) && containsNode(root.right, p)){
			 return root;
		 }
	     if(containsNode(root.left, p) && containsNode(root.left, q)||containsNode(root.left, q) && containsNode(root.left, p)){
			 return lowestCommonAncestor(root.left, p, q);
		 }
	     if(containsNode(root.right, p) && containsNode(root.right, q)||containsNode(root.right, q) && containsNode(root.right, p)){
			 return lowestCommonAncestor(root.right, p, q);
		 }
		 return null;  
    }
	/**
	 * 判断节点p是否在根为root的树中。
	 * @param root
	 * @param p
	 * @return
	 */
	 static boolean containsNode(TreeNode root, TreeNode p){
		 if(p == null )return false;
		 if(root == null) return false;
		 if(root.val == p.val ) return true;
		 boolean left = containsNode(root.left,p);
		 if(left) return true;
		 boolean right = containsNode(root.right, p);
		 return right;
	 }
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeAlg.getTreeExample();
		TreeAlg.postOrder(root);
		TreeNode p = new TreeNode();
		p.val = 101;
		//System.out.println(containsNode(root,p));
		TreeNode q = new TreeNode();
		q.val = 100;
		System.out.println();
		System.out.println(lowestCommonAncestor(root,p,q).val);
		System.out.println(lowestCommonAncestor1(root,p,q).val);
	}

}
