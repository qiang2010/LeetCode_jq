package qiang.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UniqueBinarySearchTreesII95_withCache {
 
	public static void main(String[] args) {
		UniqueBinarySearchTreesII95_withCache temp = new UniqueBinarySearchTreesII95_withCache();
		List<TreeNode> ans = temp.generateTrees2(7);
		for(TreeNode t:ans){
			TreeAlg.postOrder(t);
		}
	}
	// 使用一个map存放已经求得的子问题。
	Map<Long,List<TreeNode>> tempSubTrees;
	public List<TreeNode> generateTrees2(int n) {
		 List<TreeNode> ansList = new LinkedList<TreeNode>();
		 if(n==0) {
			 ansList.add(null);
			 return ansList;
		 }
		 tempSubTrees = new HashMap<>();
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
		
		
		long key = left;
		
		key = (key<<32)|right;
		if(tempSubTrees.containsKey(key))return tempSubTrees.get(key);
		
		if(left == right){
			TreeNode newRoot= new TreeNode(left);
			ans.add(newRoot);
			//key = (left<<32)|right;
			tempSubTrees.put(key, ans);
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
//			key = (left<<32)|right;
			tempSubTrees.put(key, ans);
			return ans;
		}
		
		List<TreeNode> allAns  = new LinkedList<TreeNode>();
		TreeNode  tempRoot;
		List<TreeNode> leftSide;
		List<TreeNode> rightSide;
		
		for(long i = left; i < right+1; i++){
			key = left;
			key = (key<<32) | (i-1);
			if(tempSubTrees.containsKey(key))
				leftSide = tempSubTrees.get(key);
			else{
				leftSide = buildTreeK(left, (int)i-1);
				tempSubTrees.put(key, leftSide);
			}
			key = ((i+1)<<32) | (right);
			if(tempSubTrees.containsKey(key)){
				rightSide = tempSubTrees.get(key);
			}else{
				rightSide = buildTreeK((int)i+1, right);
				tempSubTrees.put(key, rightSide);
			}
			for(int j = 0 ; j< leftSide.size();j++){
				for(int k = 0; k < rightSide.size();k++){
					tempRoot = new TreeNode((int)i);
					tempRoot.left = leftSide.get(j);
					tempRoot.right = rightSide.get(k);
					allAns.add(tempRoot);
				}
			}
			
		}
		key = left;
		key =  (key<<32) | right;
		tempSubTrees.put(key, allAns);
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
