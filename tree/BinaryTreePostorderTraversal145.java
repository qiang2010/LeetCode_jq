package qiang.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal145 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//BinaryTreePreorderTraversal144 ins = new BinaryTreePreorderTraversal144();
		TreeNode root = TreeAlg.getTreeForSerialized("1#23#");
		//System.out.println(ins.preorderTraversal(root).toString());
		TreeAlg.postOrder(root);
		System.out.println("p:"+postorderTraversal(root).toString());
		
	}
    public static  List<Integer> postorderTraversal(TreeNode root) {
    	
    	List<Integer> ans = new LinkedList<>();
    	if(root == null) return ans;
    	LinkedList<PostNode> postStack = new LinkedList<PostNode>();
    	PostNode topNode = null;
    	while(root != null){
    		topNode = new PostNode(root,false);
    		postStack.addLast(topNode);
    		root = root.left;
    	}
    
    	TreeNode topTreeNode;
    	while(!postStack.isEmpty()){
    		topNode = postStack.getLast();
    		
    		if(topNode.rightVisited || topNode.curNode.right==null){
    			ans.add(topNode.curNode.val);
    			postStack.removeLast();
    		}else{
    			
    			topNode.rightVisited = true;
    			topTreeNode = topNode.curNode;
    			
    			// 右子树节点加入到栈中。
    			postStack.addLast(new PostNode(topTreeNode.right, false));
    			topTreeNode = topTreeNode.right;
    		    while(topTreeNode.left != null){
    		    	postStack.addLast(new PostNode(topTreeNode.left, false));
    		    	topTreeNode = topTreeNode.left;
    		    }
    		}
    	}
    return ans;
    }
}
class PostNode{
	TreeNode curNode;
	boolean rightVisited = false;
	public PostNode(TreeNode n,boolean v){
		curNode = n;
		rightVisited = v;
	}
}
