package qiang.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class BinaryTreeZigzagLevelOrderTraversal103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeZigzagLevelOrderTraversal103 b = new BinaryTreeZigzagLevelOrderTraversal103();
		
		TreeNode root = TreeAlg.getTreeForSerialized("1");
		TreeAlg.preOrder(root);
		PrintUtil.print2DList(b.zigzagLevelOrder(root));
		
	}
	
	
	/**
	 * 使用两个栈，来回倒腾。
	 * @param root
	 * @return
	 */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	
    	if(root == null){
    		return ans;
    	}
    	LinkedList<TreeNode> stack1 = new LinkedList<>(); 
    	LinkedList<TreeNode> stack2 = new LinkedList<>();
    	stack1.addLast(root);
    	while(!stack1.isEmpty() || !stack2.isEmpty()){
    		
    		List<Integer> temp = new ArrayList<>();
    		TreeNode top;
    		while(!stack1.isEmpty()){
    			top = stack1.getLast();
    			stack1.removeLast();
    			temp.add(top.val);
    			if(top.left!=null)
    				stack2.addLast(top.left);
    			if(top.right!=null)
    			stack2.addLast(top.right);
    		}
    		
    		ans.add(temp);
    		
    		temp = new ArrayList<>();
    		while(!stack2.isEmpty()){
    			top = stack2.getLast();
    			stack2.removeLast();
    			temp.add(top.val);
    			if(top.right!=null)
    				stack1.add(top.right); // 这里要先放右节点。
    			if(top.left!=null)
    				stack1.add(top.left);
    		}
    		if(!temp.isEmpty()) /// 开始的是忘了判断了。
    		ans.add(temp);
    	}
    	return ans;
    }
	
	

}
