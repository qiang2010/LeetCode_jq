package qiang.treeLinkNode;

import java.util.LinkedList;

import qiang.tree.TreeAlg;
import qiang.tree.TreeNode;

public class PopulatingNextRightPointersInEachNode116 {

	
	/**
	 *  不超时的做法。当上一层已经连接完毕后，下一层就可以根据上一层来连接了。
	 * @param root
	 */
	 public static void connect_level(TreeNode root) {
		 
		 
		  if(root == null) return ;
		  if(root.left == null) return; 
		  TreeNode tempRoot = root;
		  while(root.left != null){
			 tempRoot = root;
			 while(root!=null){
				 if(root.left != null){
					 root.left.next = root.right;
				 }
				 if(root.next != null){
					 root.right.next = root.next.left;
				 }
				 root = root.next;
			 }
			 root = tempRoot.left;
		  }
	 }
	
	/**
	 * 层次遍历超时了。
	 * @param root
	 */
    public void connect(TreeNode root) {
        
    	if(root == null ) return;
    	int i = 1;
    	LinkedList<TreeNode> queue = new LinkedList<>();
    	queue.addLast(root);
    	TreeNode tempNode,lastNode = null;
    	int k = 1;
    	while(queue.isEmpty() == false){
    		tempNode = queue.getFirst();
    		queue.removeFirst();
    		if(tempNode.left != null){
    			queue.addLast(tempNode.left);
    		}
    		if(tempNode.right != null){
    			queue.addLast(tempNode.right);
    		}
    		if(k == 1){
    			lastNode = tempNode;
    		}else{
    			lastNode.next = tempNode;
    			lastNode = tempNode;
    		}
    		k++;
    		if(k == i+1){
    			i = i<<1;
    			k = 1;
    		}
    	}
    }	
	
	
	
	public static void main(String[] args) {
		
		TreeNode root = TreeAlg.getTreeForSerialized("1234567");
		connect_level(root);
		TreeLinkNodeAlg.printTree(root);
	}
}
