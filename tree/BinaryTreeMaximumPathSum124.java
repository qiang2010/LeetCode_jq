package qiang.tree;

public class BinaryTreeMaximumPathSum124 {

	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
	
		if(root == null ) {
			return 0;
		}
		if(root.left == null && root.right == null){
			return root.val;
		}
		maxPartSum(root);
		return max;
	}
	public int maxPartSum(TreeNode root) {
		if(root == null)return 0;
		if(root.left == null && root.right == null) {
			max =  max > root.val? max: root.val; 
			return root.val;
		}
		int left = maxPartSum(root.left);
		int right = maxPartSum(root.right);
		left  = left > 0 ? left : 0;
		right = right > 0 ? right : 0;
		int temp =  left + right + root.val;
		// System.out.println(temp);
		 int tempMax = left > right ? left : right;
		// System.out.println(tempMax);
//		 if(tempMax > 0){
//			 root.val += tempMax;
//		 }
		 
		max = temp > max ? temp : max;
		return root.val+tempMax;
    }
	public static void main(String[] args) {

		TreeNode root = TreeAlg.getTreeForSerialized("0");
		System.out.println(new BinaryTreeMaximumPathSum124().maxPathSum(root));
	}

}
