package qiang.tree;

public class InorderSuccessorInBST285 {

	public static void main(String[] args) {
		
		TreeNode root = TreeAlg.getTreeForSerialized("123##4##5");
		InorderSuccessorInBST285 dd = new InorderSuccessorInBST285();
		TreeAlg.inOrder(root);
		TreeNode n = dd.inorderSuccessor(root, new TreeNode(2));
		System.out.println();
		System.out.println(n==null? null :n.val);
		
	}
	TreeNode next= null;
	boolean find = false;
	TreeNode inorderSuccessor(TreeNode root, TreeNode p){
		
		if(root == null) return  next;
		this.inorderSuccessor(root.left, p);
		if(next != null) return next;
		if(find){
			next = root;
			find = false;
			return next;
		}
		if(root.val == p.val || root == p){
			find = true;
		}
		this.inorderSuccessor(root.right, p);
		return next; 
	}
	
}
