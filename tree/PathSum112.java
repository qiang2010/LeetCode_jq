package qiang.tree;

public class PathSum112 {

    public static boolean hasPathSum(TreeNode root, int sum) {
    	
    	if(root == null && sum ==0) return false;
    	if(root == null ) return false;
    	return hasPathPreOrder(root, sum);
    	
    }
    
    private static boolean  hasPathPreOrder(TreeNode root,int sum){
    	if(root != null&&root.left==null && root.right==null && sum ==root.val) return true;
    	if(root == null ) return false;
    	boolean left = hasPathPreOrder(root.left, sum-root.val);
    	if(left) return true;
    	return hasPathPreOrder(root.right, sum-root.val);
    }
	public static void main(String[] args) {
		TreeNode root = TreeAlg.getTreeForSerialized("123##47");
		System.out.println(hasPathSum(root, 8));
	}

}
