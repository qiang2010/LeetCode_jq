package qiang.tree;

import java.util.LinkedList;

public class BinarySearchTreeIterator173 {

	
	LinkedList<TreeNode> stack = new LinkedList<>();
	
    public BinarySearchTreeIterator173(TreeNode root) {
    
    	while(root !=null){
    		stack.addLast(root);
    		root = root.left;
    	}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    	int ans = -1;
    	TreeNode top ;
    	if(!stack.isEmpty()){
    		top = stack.getLast();
    		stack.removeLast();
    		ans = top.val;
    		
    		if(top.right !=null){
    			top = top.right;
    			while(top!=null){
    				stack.addLast(top);
    				top = top.left ;
    			}
    		}
    	}
    	return ans;
    }
	
    
    public static void main(String[] args) {
		
    	TreeNode root = TreeAlg.getTreeForSerialized("213");
    	BinarySearchTreeIterator173 bst= new BinarySearchTreeIterator173(root);
    	while(bst.hasNext()){
    		System.out.println(bst.next()+" ");
    	}
    	
    	
	}
}
