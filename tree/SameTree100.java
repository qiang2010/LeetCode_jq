package qiang.tree;

public class SameTree100 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String pre1 = "12";
		String mid1 = "21";
		String pre2 = "12";
		String mid2 = "21";
		TreeNode p = TreeAlg.buildTree(pre1, 0, pre1.length()-1, mid1, 0, mid1.length()-1);
		TreeNode q = TreeAlg.buildTree(pre2, 0, pre2.length()-1, mid2, 0, mid2.length()-1);
		System.out.println(SameTree100.isSameTree(p, q));
	}
	public  static boolean isSameTree(TreeNode p, TreeNode q){
		if(p==null && q!= null || p!=null && q==null)return false;
		if(p==null && q==null) return true;
		if(p.val != q.val) return false;
		
		boolean leftSame = isSameTree(p.left, q.left);
		if(leftSame == false) return false;
		boolean rightSame = isSameTree(p.right,q.right);
		if(rightSame == false) return false;
		
		return true;
	}


}
