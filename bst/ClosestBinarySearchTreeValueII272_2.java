package qiang.bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import qiang.tree.TreeAlg;
import qiang.tree.TreeNode;


public class ClosestBinarySearchTreeValueII272_2 {
	
	
	public static void main(String[] args) {
		
		ClosestBinarySearchTreeValueII272_2 cc = new ClosestBinarySearchTreeValueII272_2();
		TreeNode root = TreeAlg.getTreeForSerialized("539248#");
		System.out.println(cc.closestKValues(root, 3, 5));
		
	}
	
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
		dfs(maxQueue, root, k, target);
		for(int a :maxQueue){
			ans.add(a);
		}
		return ans;
	}
	
	void dfs(PriorityQueue<Integer> maxQueue,TreeNode root,int k,double target){
		if(root == null ) return;
		if(maxQueue.size()<k){
			maxQueue.add(root.val);
		}else{
			int top = maxQueue.peek();
			if(this.isCloser(root.val, top, target)){
				maxQueue.poll();
				maxQueue.add(root.val);
			}else{
				// 这里是maxQueue的size 为k，同时root距离target的距离又很大。于是可以舍弃一侧。
				if(root.val < target){
					dfs(maxQueue, root.right, k, target); 
				}else{
					dfs(maxQueue, root.left, k, target); 
				}
				return;
			}
		}
		dfs(maxQueue, root.left, k, target);
		dfs(maxQueue, root.right, k, target);
		
		
	}
	
	boolean isCloser(int a,int b,double target){
		if(Math.abs(target-a) < Math.abs(target-b)) return true;
		return false;
	}
}
