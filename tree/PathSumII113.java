package qiang.tree;

import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class PathSumII113 {

	List<List<Integer>> ans = new LinkedList<List<Integer>>();
    public  List<List<Integer>> pathSum(TreeNode root, int sum) {
    	
    	if(root == null ) return ans;
    	preorder(root, sum, new LinkedList<Integer>());
    	return ans;
    }
    public void preorder(TreeNode root, int sum,LinkedList<Integer> one){
    	if(root!= null && root.left==null && root.right == null && sum ==root.val){
    		List<Integer> onePath = new LinkedList<>();
    		one.add(root.val);
    		onePath.addAll(one);
    		ans.add(onePath);
    		//System.out.println("one res");
    		one.removeLast();
    	}
    	if(root == null) return ;
    	one.add(root.val);
    	preorder(root.left, sum-root.val,one);
    	preorder(root.right, sum-root.val, one);
    	one.removeLast();
    }

	public static void main(String[] args) {
		TreeNode root = TreeAlg.getTreeForSerialized("1235#47");
		PathSumII113 pSumII113 = new PathSumII113();
		PrintUtil.print2DList(pSumII113.pathSum(root, 8));
	}

}
