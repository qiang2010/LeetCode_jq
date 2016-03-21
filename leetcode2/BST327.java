package qiang.leetcode2;


public class BST327 {

	class Node{
		// 用两个变量分别记录一个节点其左子树节点数量
		int countLeft;
		long val;
		Node left,right;
		Node(long val){
			this.val = val;
			this.countLeft = 0;
			left = right = null;
		}
	}
	Node root;
	public BST327(){
		root = null;
	}
	public void insertOneNum(long val){
		if(root == null){
			root = new Node(val);
			return ;
		}
		Node tempR = root,last = tempR;
		boolean left = true;
		while(tempR != null){
			last = tempR;
			if(val <= tempR.val){
				tempR.countLeft++;
				tempR = tempR.left;
				left = true;
			}else{
				tempR = tempR.right;
				left = false;
			}
		}
		tempR = new Node(val);
		if(left) last.left = tempR;
		else{
			last.right = tempR;
		}
	}
 
	int findLessThanEqal(long upper){
		if(root == null){
			return 0;
		}
		int ans = 0;
		Node tempR = root;
		while(tempR != null){
			if(upper < tempR.val){
				tempR = tempR.left;
			}else{
				ans+=tempR.countLeft+1;
				tempR = tempR.right;
				
			}
		}
		return ans;
	}
	void print(){
		this.printTree(root);
	}
	void printTree(Node root){
		if(root == null)return;
		if(root != null){
			System.out.print(root.val+"\t");
		}
		printTree(root.left);
		printTree(root.right);
	}
}
