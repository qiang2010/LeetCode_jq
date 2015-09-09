package qiang.breakthroughOfOffer;

import qiang.tree.TreeAlg;
import qiang.tree.TreeNode;

public class SubstructureTree18 {

	
	/**
	 * 
	 *  树tree2是否是root的子树
	 *  
	 * @param root
	 * @param tree2
	 * @return
	 */
	public boolean hasSubtree(TreeNode root,TreeNode tree2){
		
		if(root == null && tree2 == null ) return true;
		if(root != null && tree2 == null ) return true;
		if(root == null && tree2 != null ) return false;
		boolean tempFlag = false;
		if(root.val == tree2.val){
			tempFlag = isTree1HasTree2(root, tree2);
		}
		if(!tempFlag){
			tempFlag = hasSubtree(root.left, tree2);
		}
		if(!tempFlag){
			tempFlag = hasSubtree(root.right, tree2);
		}
		return tempFlag;
	}
	boolean isTree1HasTree2(TreeNode tree1,TreeNode tree2){
		
		if(tree2 == null )return true;
		if(tree1 == null ) return false;
		if(tree1.val != tree2.val)return false;
		return isTree1HasTree2(tree1.left, tree2.left) && isTree1HasTree2(tree1.right, tree2.right);
	}
	
	
	public static void main(String[] args) {

		TreeNode tree1 = TreeAlg.getTreeForSerialized("1#23#");
		TreeNode tree2 = TreeAlg.getTreeForSerialized("1#24");
		SubstructureTree18 substructureTree18 = new SubstructureTree18();
		
		System.out.println(substructureTree18.hasSubtree(tree1, tree2));
		
	}

}
