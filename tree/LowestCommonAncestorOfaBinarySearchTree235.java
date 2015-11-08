package qiang.tree;

import java.util.ArrayList;

public class LowestCommonAncestorOfaBinarySearchTree235 {

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		ArrayList<TreeNode> pPath = getPath(root, p);
		ArrayList<TreeNode> qPath = getPath(root, q );
		
//		for(TreeNode temp:pPath){
//		System.out.print(temp.val+" ");
//		}
//		System.out.println();
//		for(TreeNode temp:qPath){
//			System.out.print(temp.val+" ");
//		}
////		
//		System.out.println();
		int size1 = pPath.size();
		int size2 = qPath.size();
		size1 = size1>size2? size2:size1;
		int i = 0 ; 
		for( i = 0 ; i < size1; i++){
			if(pPath.get(i).val == qPath.get(i).val){
				continue;
			}else{
				break;
			}
		}
		return pPath.get(i-1);
	}
	
	static ArrayList<TreeNode> getPath(TreeNode rootNode,TreeNode q){
	 
		ArrayList<TreeNode> resArrayList = new  ArrayList<TreeNode>();
		if(rootNode == null || q == null ) return resArrayList;
		while(rootNode != null){
			resArrayList.add(rootNode);
			if(rootNode.val == q.val ) {
				return resArrayList;
			}else{
				if(rootNode.val < q.val ){
					rootNode = rootNode.right;
				}else {
					rootNode = rootNode.left;
				}
			}
			
		}
		return resArrayList;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeAlg.getTreeExample();
		TreeAlg.preOrder(root);
		TreeNode p = new TreeNode();
		p.val = 102;
		//System.out.println(containsNode(root,p));
		TreeNode q = new TreeNode();
		q.val = 104;
		System.out.println();
		System.out.println(lowestCommonAncestor(root,p,q).val);	}

}
