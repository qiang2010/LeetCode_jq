package qiang.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class BinaryTreeLevelOrderTraversal102 {

	
	
	
    public static List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root == null ) return ans;
        List<Integer> tempAns = null ;
        LinkedList<TreeNode> inQueue = new LinkedList<>();
        LinkedList<Integer>  levelQueue = new LinkedList<>();
        int level = 1,lastLevel=0;
        TreeNode tempNode;
        inQueue.addLast(root);
        levelQueue.addLast(1);
        while(inQueue.isEmpty() == false){
        	tempNode = inQueue.getFirst();
        	level = levelQueue.getFirst(); 
        		inQueue.removeFirst();
        		levelQueue.removeFirst();
        	if(level != lastLevel){
        		lastLevel = level;
        		
        		if(tempAns != null){
        			if(level % 2 == 1 ){
            			Collections.reverse(tempAns);
            		}
        			ans.add(tempAns);
        		}
        		tempAns = new LinkedList<>();
        	}
        	tempAns.add(tempNode.val);
        	if(tempNode.left != null){
        		inQueue.addLast(tempNode.left);
        		levelQueue.addLast(level+1);
        	}
        	if(tempNode.right != null){
        		inQueue.addLast(tempNode.right);
        		levelQueue.addLast(level+1);
        	}
        }
        // 最后一层
        if(lastLevel % 2 == 0 ){
			Collections.reverse(tempAns);
		}
        ans.add(tempAns);
        return ans;   
    }
	public static void main(String[] args) {
		
		TreeNode root = TreeAlg.getTreeForSerialized("392##17");
		PrintUtil.print2DList(levelOrder(root));
	}
	
}
