package qiang.tree;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree99 {
	
	
	/**
	 * 下面的空间使用是O(N)
	 * 
	 */
	List<TreeNode> inOrderList = new ArrayList<>();
	public void recoverTree(TreeNode root) {
	        
		inOrder(root);
		int size = inOrderList.size();
		if(size < 2)return ;
		int curValue;
		TreeNode curNode = inOrderList.get(0),nextNode,firstNode;
		curValue = curNode.val;
		firstNode = curNode;
		int i =1;
		for( i =1 ; i <size; i++){
			nextNode  = inOrderList.get(i);
			if(nextNode.val < curValue){
				break;
			}else{
				curValue = nextNode.val;
			}
		}
		// 上面找到第一个结点。
		firstNode = inOrderList.get(i-1);
		i++;
		TreeNode secondNode= null;
		curValue = firstNode.val;
		while(i<size){
			nextNode = inOrderList.get(i);
			if(curValue < nextNode.val){
				break;
			}
			i++;
		}
		secondNode = inOrderList.get(i-1);
		int fV = firstNode.val;
		firstNode.val = secondNode.val ;
		secondNode.val = fV;
		System.out.println(firstNode.val);
		System.out.println(secondNode.val);
	}
	
	public void inOrder(TreeNode root){
		if(root == null) return;
		inOrder(root.left);
		inOrderList.add(root);
		inOrder(root.right);
	}
	
	/**
	 * 这里我们一边中序遍历，一边记录要求解的节点
	 * @param root
	 */
	TreeNode pre = null,first = null,second = null;
	public void recoverTree2(TreeNode root) {
		if(root == null) return;
		inOrder2(root);
		if(first!=null && second !=null){
			
			int temp = first.val;
			first.val = second.val;
			second.val = temp;
		}
	}
	void inOrder2(TreeNode root){
		if(root == null) return;
		inOrder2(root.left);
		if(pre != null && pre.val > root.val){
			if(first == null) first = pre;
			if(first != null) second = root;
		}
		pre = root; // 每次都更新pre
		inOrder2(root.right);
	}
	
	
	
	public static void main(String[] args) {
		RecoverBinarySearchTree99 temp = new RecoverBinarySearchTree99();
		TreeNode root = TreeAlg.getTreeForSerialized("45");
		
		temp.recoverTree(root);
	}

}
