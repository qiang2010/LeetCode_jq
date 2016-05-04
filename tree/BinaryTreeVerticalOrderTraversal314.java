package qiang.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BinaryTreeVerticalOrderTraversal314 {

	Map<Integer,List<Integer>> res = new TreeMap<>();
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		if(root ==null) return ans;
		preOrder(root,0);
		for(int w:res.keySet()){
			ans.add(res.get(w));
		}
		return ans;
	}
	void preOrder(TreeNode root , int w){
		if(root == null ) return;
		if(res.containsKey(w)){
			res.get(w).add(root.val);
		}else{
			res.put(w,new LinkedList<Integer>());
			res.get(w).add(root.val);
		}
		preOrder(root.left,w-1);
		preOrder(root.right,w+1);
	}
}
