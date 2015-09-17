package qiang.tree;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII95 {
	 
	
  public List<TreeNode> generateTrees(int n) {
	
	  List<TreeNode> ansList = new LinkedList<TreeNode>();
	  if(n==0) return ansList;
	  
	  buildBST(ansList, n, 1, n);
	  System.err.println(ansList.size());
	  return ansList;
  }	
	
  public TreeNode buildBST(List<TreeNode> ansList,int size,int left,int right){
	  if(left > right) return null;
	  if(left == right){
		  return new TreeNode(left);
	  }
	  TreeNode root=null;
	  TreeNode rightNode;
	  TreeNode leftNode;
	  for (int i = left; i < right+1; i++) {
		leftNode = buildBST(ansList,size,left, i-1);
		rightNode = buildBST(ansList,size,i+1, right);
		root = new TreeNode(i);
		root.left = leftNode;
		root.right = rightNode;
		if(right- left== size-1){
			TreeNode tempRoot = new TreeNode(root.val);
			TreeAlg.preOrder(root);
			System.out.println();
			TreeAlg.inOrder(root);
			System.out.println();
			ansList.add(tempRoot);
		}else{
			 return new TreeNode(root.val);
		}
	  }
	  return root;
   }
	 
	public static void main(String[] args) {
		UniqueBinarySearchTreesII95 temp = new UniqueBinarySearchTreesII95();
		temp.generateTrees(3);
	}

}
