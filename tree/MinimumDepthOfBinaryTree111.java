package qiang.tree;

import java.util.LinkedList;

public class MinimumDepthOfBinaryTree111 {
	
	
	
	/** 
	 * 使用递归
	 * @param root
	 * @return
	 */
	 public static int minDepth(TreeNode root) {
		 if(root == null) return 0;
		 if(root.left ==null && root.right == null) return 1;
		 int leftDepth = root.left != null ? minDepth(root.left): Integer.MAX_VALUE;
		 int rightDepth = root.right != null ? minDepth(root.right):Integer.MAX_VALUE;
		 return Math.min(leftDepth, rightDepth)+1;
		 
	 }
	
	/**
	 *  层次遍历
	 * @param root
	 * @return
	 */
    public static int minDepth2(TreeNode root) {
    	
    	if(root == null) return 0;
    	LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
    	LinkedList<Integer>  queue2 = new LinkedList<>();
    	queue1.addLast(root);
    	queue2.addLast(1);
    	TreeNode tempNode;
    	int level=1;
    	while(!queue1.isEmpty()){
    		tempNode = queue1.getFirst();
    		queue1.removeFirst();
    		level = queue2.getFirst();
    		queue2.removeFirst();
    		
    		if(tempNode.left == null && tempNode.right == null){
    			return level;
    		}else{
    			if(tempNode.left !=null){
    				queue1.addLast(tempNode.left);
    				queue2.addLast(level+1);
    			}
    			if(tempNode.right !=null){
    				queue1.addLast(tempNode.right);
    				queue2.addLast(level+1);
    			}
    		}
    	}
    	return level;
     
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeAlg.getTreeExample();
		System.out.println(minDepth(root));
	}

}
