package qiang.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView199 {

	
   
	
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<Integer>();
        if(root == null) return ans;
		
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.addLast(root);
		TreeNode top;
		int last = 1;
		int cur  = 0;
		while(!queue.isEmpty()){
			top = queue.getFirst();
			queue.removeFirst();
			last--;
			
			if(top.left != null ){
				queue.addLast(top.left);
				cur++;
			}
			if(top.right != null){
				queue.addLast(top.right);
				cur++;
			}
			if(last == 0){
				ans.add(top.val);
				last = cur;
				cur = 0;
			}
		}
        return ans;
        
    
	}
	public static void main(String[] args) {
		
		TreeNode root = TreeAlg.getTreeForSerialized("1");
		System.out.println(new BinaryTreeRightSideView199().rightSideView(root));
		
		
	}
}
