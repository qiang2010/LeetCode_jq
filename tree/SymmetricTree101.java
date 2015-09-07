package qiang.tree;

public class SymmetricTree101 {
    
	/**
	 * 左子树的左子树和右子树的右子树判断是否是对称的
	 * 左子树的右子树和右子树的左子树判断是否是对称的。
	 */
	public static boolean isSymmetric(TreeNode root) {
		
		if(root == null ) return true;
		if(root.left ==null && root.right == null ) return true;
		return isMiror(root.left, root.right);
		
	}
	
	private static boolean isMiror(TreeNode node1, TreeNode node2){
		if(node1 == null && node2 == null) return true;
		if(node1 != null && node2 == null) return false;
		if(node1 == null && node2 != null) return false;
		if(node1.val != node2.val ) return false;
		return isMiror(node1.left, node2.right) && isMiror(node1.right,node2.left );
	}
	
	
	/**
	 * 下面是错误的解法。
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isSymmetric2(TreeNode root) {
    
		if(root==null) return true;
		if(root.left == null && root.right == null) return true;
		if(root.left != null && root.right == null) return false;
		if(root.left == null && root.right != null) return false;
		if(root.left.val != root.right.val) return false;
		boolean left = isSymmetric(root.left);
		boolean right = isSymmetric(root.right);
    	
    	return left && right;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = TreeAlg.getTreeForSerialized("123##4");
		TreeAlg.preOrder(root);
		TreeAlg.postOrder(root);
		
		System.out.println(isSymmetric(root));
	}

}
