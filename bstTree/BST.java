package qiang.bstTree;

public class BST {

	class BSTNode{
		int val;
		BSTNode left, right;
		public BSTNode(int val){
			left = right = null;
		}
	}
	BSTNode root;
	public BST(){
		root =null;
	}
	// 这里bst中的值都是唯一的，当树中存在和v相等的时候，就不插入。
	// 有时候我们也插入，默认是插入到左子树中。
	public void insert(int v){
		if(root == null){
			root = new BSTNode(v);return;
		}
		BSTNode cur = root;
		while(true){
			if(v == cur.val)return;
			if(v< cur.val ){
				// 小于当前值，并且cur.left 为null，那么就插入到这个位置
				if(cur.left ==null){
					cur.left = new BSTNode(v);
					return;
				}
				cur = cur.left;
			}else{
				if(cur.right == null){
					cur.right = new BSTNode(v);
					return;
				}
				cur = cur.right;
			}
		}
	}
	public void delete(int v){
		if(root == null) return;
		
		
	}
	
	
	
	
}
