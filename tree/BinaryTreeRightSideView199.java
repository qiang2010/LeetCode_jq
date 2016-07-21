package qiang.tree;

import java.util.ArrayList;
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
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root, ans,0);
        return ans;
    }
    void preOrder(TreeNode root, List<Integer> ans,int level){
        if(root ==  null ) return;
        if(level == ans.size()){
            ans.add(root.val);
        }
        preOrder(root.right,ans,level+1);
        preOrder(root.left, ans, level+1);
        
    }
	public static void main(String[] args) {
		TreeNode root = TreeAlg.getTreeForSerialized("1");
		System.out.println(new BinaryTreeRightSideView199().rightSideView(root));
	}
}
