package qiang.dynamicPromming;

import qiang.tree.TreeAlg;
import qiang.tree.TreeNode;

public class HouseRobberIII337 {    
	
	public static void main(String[] args) {

		HouseRobberIII337 hr = new HouseRobberIII337();
		TreeNode root = TreeAlg.getTreeForSerialized("34513#1");
		System.out.println(hr.rob(root));
	}
	class Node{
		int st;
		int not;
		Node(int st,int not){
			this.st = st;
			this.not = not;
		}
	}
	/**
	 * 后根遍历的方式。
	 * @param root
	 * @return
	 */
	public int rob(TreeNode root){
		Node n = robDfs(root);
		return Math.max(n.not, n.st);
	}
	Node robDfs(TreeNode root){
		
		if(root == null)return new Node(0,0);
		if(root.left ==null && root.right==null){
			return new Node(root.val,0);
		}
		Node left = robDfs(root.left);
		Node right = robDfs(root.right);
		int s = left.not+right.not+root.val;
		int no = Math.max(left.not, left.st)+Math.max(right.not,right.st);
		return new Node(s,no);
	}
	
	int ans = 0;
	public int rob2(TreeNode root) {
		if(root == null) return 0;
		robD(root, 0, 0);
		return ans;
	}
	// 只要能进入该函数，表明root不为空
	void robD(TreeNode root,int dp0,int dp1){
		
		if(root.left ==null && root.right == null){
			ans += dp1;
			return ;
		}
		int curP = Math.max(dp0+root.val, dp1);
		if(root.left == null && root.right!=null){
			robD(root.right, dp1, curP);
		}else{
			if(root.left != null && root.right==null)
				robD(root.left, dp1, curP);
			else{ // 左右子树都不null
				
			}
		}
		
	}
}
