package qiang.treeLinkNode;

import java.util.LinkedList;

import qiang.dynamicPromming.BestTimeToBuyAndSellStockIII123;
import qiang.tree.TreeAlg;
import qiang.tree.TreeNode;

public class PopulatingNextRightPointersInEachNodeII117 {

	
	
	 /**
	  *  沿着currenLineNode 找，返回第一个不为空的儿子节点。
	  * @param tempHead
	  * @return
	  */
	 static TreeNode currenLineNode = null;
	 static boolean isLeft = false;
	 static   boolean isNeedGetNextNotnull = false;
	 private static TreeNode getNextNotNull(){
		if(currenLineNode == null)return null;
		isLeft = false;
		while(currenLineNode !=null){
			if(currenLineNode.left != null ){
				isLeft = true;
				isNeedGetNextNotnull = false;
				return currenLineNode.left;
			}
			if(currenLineNode.right!= null ){
				isNeedGetNextNotnull = true;
				return currenLineNode.right;
			}
			currenLineNode = currenLineNode.next;
		}
		return null;
	}
	/**
	 *  不超时的做法。当上一层已经连接完毕后，下一层就可以根据上一层来连接了。
	 * @param root
	 */
	 public static void connect_level(TreeNode root) {
		 
		  if(root == null) return ;
		
		  TreeNode firstNotNullNode = null,tempFirst=null;
		
		  boolean isFirstNotNull= true;
		  while(root!=null){
		  		 isFirstNotNull = true;
		  		firstNotNullNode = null;
				 while(root!=null){
					 if(root.left!=null){
						 if(isFirstNotNull){
							 firstNotNullNode = root.left;
							 tempFirst = root.left;
							 isFirstNotNull = false;
						 }else{
							 tempFirst.next = root.left;
							 tempFirst = root.left;
						 }
						 
					 }
					 if(root.right!=null){
						 if(isFirstNotNull){
							 firstNotNullNode = root.right;
							 isFirstNotNull = false;
							 tempFirst = root.right;
						 }else {
							tempFirst.next = root.right;
							tempFirst = root.right;
						}
						 
					 }
					 root = root.next;
				 }
				 root = firstNotNullNode;
		  	}
		  	
		  	
		  }

	
	
	public static void main(String[] args) {
		
		TreeNode root = TreeAlg.getTreeForSerialized("1234567");//123#45#8
		connect_level(root);
//		TreeLinkNodeAlg.printTree(root);
		TreeNode tempNode;
		System.out.println(root.val);
		currenLineNode = root;
		tempNode = getNextNotNull();
		while(tempNode!=null){
			currenLineNode = root;
			tempNode = getNextNotNull();
			root = tempNode;
			while(root !=null){
				System.out.print(root.val +" ");
				root = root.next;
			}
			System.out.println();
		    root = tempNode;
		}
		
	}
}
