package qiang.tree;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII95 {
 
	public static void main(String[] args) {
		UniqueBinarySearchTreesII95 temp = new UniqueBinarySearchTreesII95();
		temp.generateTrees2(5);
	}
	
	public List<TreeNode> generateTrees2(int n) {
		 List<TreeNode> ansList = new LinkedList<TreeNode>();
		 if(n==0) {
			 ansList.add(null);
			 return ansList;
		 }
		 
		 ansList =  buildTreeK(1, n);
		 //System.out.println(ansList.size());
		 return ansList;
	 
	 }
	 
	public List<TreeNode> buildTreeK(int left,int right){
		List<TreeNode> ans = new LinkedList<>();
		if(left > right) {
			ans.add(null);
			return ans;
		}
		if(left == right){
			TreeNode newRoot= new TreeNode(left);
			ans.add(newRoot);
			return ans;
		}
		if(left+1 == right){
			TreeNode newL1 = new TreeNode(left);
			TreeNode newR1 = new TreeNode(right);
			newL1.right = newR1;
			ans.add(newL1);
			TreeNode newL2 = new TreeNode(left);
			TreeNode newR2 = new TreeNode(right);
			newR2.left = newL2;
			ans.add(newR2);
			return ans;
		}
		
		List<TreeNode> allAns  = new LinkedList<TreeNode>();
		TreeNode  tempRoot;
		for(int i = left; i < right+1; i++){
			List<TreeNode> leftSide = buildTreeK(left, i-1);
			List<TreeNode> rightSide = buildTreeK(i+1, right);
			for(int j = 0 ; j< leftSide.size();j++){
				for(int k = 0; k < rightSide.size();k++){
					tempRoot = new TreeNode(i);
					tempRoot.left = leftSide.get(j);
					tempRoot.right = rightSide.get(k);
					allAns.add(tempRoot);
				}
			}
		}
		return allAns;
		
	}
	
	
	
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
	 


}
