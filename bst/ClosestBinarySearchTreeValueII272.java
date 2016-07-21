package qiang.bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import qiang.tree.TreeNode;


public class ClosestBinarySearchTreeValueII272 {
	double tar = 0;
	public List<Integer> closestKValues(TreeNode root, double target, int k) {  
		
		List<Integer> ans = new ArrayList<>();
		if(root == null) return ans;
		this.tar = target;
		Comparator<Integer> com = new Comparator<Integer>(){
			public int compare(Integer a,Integer b){
				return (int)(Double.compare(Math.abs(tar-b), Math.abs(tar-a)));
			}
		};
		PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(com);
		LinkedList<TreeNode> path = new LinkedList<>();
		// 形成路径
		while(root != null){
			if(maxQueue.size() < k){
				maxQueue.add(root.val);
			}else{
				int top = maxQueue.peek();
				if(this.isCloser(root.val, top, target)){
					maxQueue.poll();
					maxQueue.add(root.val);
				}
			}
			if(root.val <  target){
				// 要向右侧走了
				if(root.left!=null)
					path.add(root.left);
				root = root.right; 
			}else{
				// 向左走
				if(root.right != null) path.add(root.right);
				root = root.left;
			}
			// 路径回溯
			while(path.isEmpty()==false){
				
				TreeNode top = path.getLast();
				if(maxQueue.size() == k){
					int t = maxQueue.peek();
					if(this.isCloser(t,top.val, target)){
						continue;
					}
				}
				// 这里是需要继续向下走
				while(top != null){
					if(maxQueue.size() < k){
						maxQueue.add(root.val);
					}else{
						int t = maxQueue.peek();
						if(this.isCloser(root.val, t, target)){
							maxQueue.poll();
							maxQueue.add(root.val);
						}else{
							break;
						}
					}
					if(root.val <  target){
						// 要向右侧走了
						if(root.left!=null)
							path.add(root.left);
						root = root.right; 
					}else{
						// 向左走
						if(root.right != null) path.add(root.right);
						root = root.left;
					}
			
				}
				
			}
		}
		return ans;
	}
	boolean isCloser(int a,int b,double target){
		if(Math.abs(target-a) < Math.abs(target-b)) return true;
		return false;
	}
}
