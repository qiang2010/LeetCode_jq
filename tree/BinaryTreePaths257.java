package qiang.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths257 {
	   
	public static void main(String[] args) {
		TreeNode root = TreeAlg.getTreeForSerialized("1");
		List<String> ans = new BinaryTreePaths257().binaryTreePaths(root);
		for(String s:ans){
			System.out.println(s);
		}
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
	        
		List<String> ans = new LinkedList<>();
		preOrder(root, new LinkedList<Integer>(), ans);
		return ans;
	}
	
	void preOrder(TreeNode root,LinkedList<Integer> path,List<String> ans){
		if(root ==null) return ;
		if(root.left == null && root.right==null){
			StringBuilder sb = new StringBuilder();
			for(int a:path){
				sb.append(a+"->");
			}
			sb.append(root.val);
			ans.add(sb.toString());
			return ;
		}
		path.addLast(root.val);
		preOrder(root.left, path, ans);
		preOrder(root.right, path, ans);
		path.removeLast();
		
	}
	
}
