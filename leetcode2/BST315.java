package qiang.leetcode2;

/**
 * 我们要在logn时间内找到小于给定数的个数。
 * 可以构建一个BST
 * @author jq
 *
 */
public class BST315 {
	class Node{
		int count=1;
		Node left,right;
		int val;
		Node(int val){
			this.val = val;
			this.count = 1;
			this.left = this.right = null;
		}
	}
	Node root;
	public void insert(int val){
		if(root == null){
			root = new Node(val);return;
		}
		Node tempR = root;
		boolean left= true;
		Node last = tempR;
		while(tempR!=null){
			last = tempR;
			if(val <= tempR.val ){
				tempR.count++;
				tempR = tempR.left;
				left = true;
			}else{
				tempR = tempR.right;
				left = false;
			}
		}
		if(left) last.left = new Node(val);
		else last.right =  new Node(val);
	}
	public int findLess(int val){
		if(root == null)return 0;
		int ans =0 ;
		Node tempR = root;
		while(tempR != null){
			if(val > tempR.val){
				ans += tempR.count;
				tempR = tempR.right;
			}else{
				tempR = tempR.left;
			}
		}
		return ans;
	}
	
}
