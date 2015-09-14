package qiang.tree;

public class TreeNode {
	public TreeNode left,right,next;
	public int  val;
	
	public TreeNode(){
		left = right = null;
		val = -1;
	}
	public TreeNode(int v){
		left = right = null;
		val = v;
	}
}